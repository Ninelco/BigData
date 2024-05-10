""" Script to running ml models"""
#1. Connect to Hive
import math
from pprint import pprint
from pyspark.sql import SparkSession


from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer, VectorAssembler, Imputer

from pyspark.sql.functions import when, date_format
from pyspark.sql.functions import sin, cos, col

from pyspark.ml.tuning import ParamGridBuilder, CrossValidator

from pyspark.ml.evaluation import BinaryClassificationEvaluator, MulticlassClassificationEvaluator
from pyspark.ml.classification import GBTClassifier, RandomForestClassifier
from pyspark.ml.classification import LogisticRegression


# Add here your team number teamx
TEAM = "team9"

# location of your Hive database in HDFS
WAREHOUSE = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName(f"{TEAM} - spark ML")\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.executor.instances", 20)\
        .config("spark.sql.warehouse.dir", WAREHOUSE)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()

sc = spark.sparkContext

spark.sql("SHOW DATABASES").show()
spark.sql("USE team9_projectdb").show()
spark.sql("SHOW TABLES").show()
spark.sql("SELECT * FROM team9_projectdb.ctr_part").show()


#2. list Hive databases

print(spark.catalog.listDatabases())
spark.sql("SHOW DATABASES;").show()

print(spark.catalog.listTables("team9_projectdb"))


ctr = spark.read.format("avro").table('team9_projectdb.ctr_part')


ctr.printSchema()

spark.sql("SELECT * FROM ctr_part WHERE user_id=287005").show()

spark.sql("SELECT AVG(product_category_1) FROM ctr_part;").show()

# Feature extraction

ctr1_temp = ctr

ctr1_temp = ctr1_temp.orderBy(col("DateTime"))

# # Convert the datetime column to date type
# Split dates to year, month, day

ctr1_temp = ctr1_temp.withColumn("year", date_format("datetime", "yyyy").cast('int'))
ctr1_temp = ctr1_temp.withColumn("month", date_format("datetime", "MM").cast('int'))
ctr1_temp = ctr1_temp.withColumn("day", date_format("datetime", "dd").cast('int'))
ctr1_temp = ctr1_temp.withColumn("hour", date_format("datetime", "HH").cast('int'))
ctr1_temp = ctr1_temp.withColumn("minute", date_format("datetime", "mm").cast('int'))
ctr1_temp = ctr1_temp.drop("datetime")

ctr1_temp.select('year').distinct().count()
ctr1_temp.select('month').distinct().count()

# Encode cyclical month and days
#the columns 'year' and 'month' have only one distinct value. We can remove them from the database

# ctr1_temp = ctr1_temp.withColumn("month_sin", sin(2 * math.pi * ctr1_temp.month / 12))
# ctr1_temp = ctr1_temp.withColumn("month_cos", cos(2 * math.pi * ctr1_temp.month / 12))
ctr1_temp = ctr1_temp.withColumn("day_sin", sin(2 * math.pi * ctr1_temp.day / 31))
ctr1_temp = ctr1_temp.withColumn("day_cos", cos(2 * math.pi * ctr1_temp.day / 31))
ctr1_temp = ctr1_temp.drop(*["month", "day", "year"])

# Encode cyclical hours and minutes

ctr1_temp = ctr1_temp.withColumn("hour_sin", sin(2 * math.pi * ctr1_temp.hour / 24))
ctr1_temp = ctr1_temp.withColumn("hour_cos", cos(2 * math.pi * ctr1_temp.hour / 24))
ctr1_temp = ctr1_temp.withColumn("minute_sin", sin(2 * math.pi * ctr1_temp.minute / 60))
ctr1_temp = ctr1_temp.withColumn("minute_cos", cos(2 * math.pi * ctr1_temp.minute / 60))
ctr1_temp = ctr1_temp.drop(*["hour", "minute"])

categoricalCols = ['product', 'gender']
nanCols = ['user_group_id', 'user_depth', 'age_level']

# Table
# Fill missing values with median
imputer_median = Imputer(
    inputCols=nanCols, outputCols=[f"{c}_imputed" for c in nanCols]
    ).setStrategy("median")

# Add imputation cols to df
ctr1_temp = imputer_median.fit(ctr1_temp).transform(ctr1_temp)
ctr1_temp = ctr1_temp.drop(*["user_group_id", "user_depth","age_level"])

# Fill missing values with mode
ctr1_temp = ctr1_temp.withColumn("gender", when(ctr1_temp["gender"] == "NaN", 'Male')\
                                 .otherwise(ctr1_temp["gender"]))
#drop these columns
ctr1_temp = ctr1_temp.drop(*["product_category_2", "city_development_index"])

#Encode categorical columns
indexers_temp = [StringIndexer(inputCol=c, outputCol=f"{c}_indexed")\
                 .setHandleInvalid("skip") for c in categoricalCols]
pipeline = Pipeline(stages=indexers_temp)
ctr1_temp = pipeline.fit(ctr1_temp).transform(ctr1_temp).drop(*categoricalCols + ["session_id"])


# Assemble all features into single column
assembler = VectorAssembler(inputCols=[i for i in ctr1_temp.schema.names if i != "is_click"],\
                            outputCol="features")
pipeline = Pipeline(stages=[assembler])

ctr1_temp = pipeline.fit(ctr1_temp).transform(ctr1_temp)
ctr1_temp = ctr1_temp.select(["is_click", "features"]).withColumnRenamed("is_click", "label")



#  split the data into 60% training and 40% test (it is not stratified)
train_data = ctr1_temp.limit(int(ctr1_temp.count() * 0.7))
test_data = ctr1_temp.subtract(train_data)


train_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")


test_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")


#9. First model

## 9.1 Build a model

# Create Linear Classification Model
lr = LogisticRegression()

# Fit the data to the pipeline stages
model_lr = lr.fit(train_data)

# 9.2 Predict for test data
predictions = model_lr.transform(test_data)


# 9.3 Evaluate the model

# Evaluate the performance of the model
lrEval = BinaryClassificationEvaluator(labelCol='label')
auroc = lrEval.evaluate(predictions,{lrEval.metricName:'areaUnderROC'})
aupr = lrEval.evaluate(predictions,{lrEval.metricName:'areaUnderPR'})

print(f"AUROC: {auroc}")
print(f"AUPR: {aupr}")

# Initialize the MulticlassClassificationEvaluator
evaluator1 = MulticlassClassificationEvaluator(labelCol="label", predictionCol="prediction")

# Compute accuracy, precision, recall, and F1 score
accuracy1 = evaluator1.evaluate(predictions, {evaluator1.metricName: "accuracy"})
precision1 = evaluator1.evaluate(predictions, {evaluator1.metricName: "weightedPrecision"})
recall1 = evaluator1.evaluate(predictions, {evaluator1.metricName: "weightedRecall"})
f11 = evaluator1.evaluate(predictions, {evaluator1.metricName: "f1"})

# Print the metrics

print(f"Accuracy: {accuracy1}")
print(f"Precision: {precision1}")
print(f"Recall: {recall1}")
print(f"F1 Score: {f11}")


#9.4. Hyperparameter optimization

paramGrid = ParamGridBuilder() \
    .addGrid(model_lr.regParam, [0.1, 0.01]) \
    .addGrid(model_lr.fitIntercept, [False, True]) \
    .addGrid(model_lr.elasticNetParam, [0.0, 0.5, 1.0]) \
    .build()


cv = CrossValidator(estimator = lr,
                    estimatorParamMaps = paramGrid,
                    evaluator = lrEval,
                    parallelism = 5,
                    numFolds=3)


cvModel = cv.fit(train_data)
bestModel = cvModel.bestModel


#9.5. Best model 1

model1 = bestModel
pprint(model1.extractParamMap())



#9.6 Save the model to HDFS
model1.write().overwrite().save("project/models/model1")




#9.7. Predict for test data using best model1
predictions = model1.transform(test_data)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model1_predictions.csv")



#9.8. Evaluate the best model1


# Evaluate the performance of the model
lrEval1 = BinaryClassificationEvaluator(labelCol='label')
# evaluator2_area_ROC = lrEval.evaluate(predictions)
auroc1 = lrEval1.evaluate(predictions,{lrEval1.metricName:'areaUnderROC'})
aupr1 = lrEval1.evaluate(predictions,{lrEval1.metricName:'areaUnderPR'})

print(f"AUROC: {auroc1}")
print(f"AUPR: {aupr1}")

# Initialize the MulticlassClassificationEvaluator
evaluator1 = MulticlassClassificationEvaluator(labelCol="label", predictionCol="prediction")

# Compute accuracy, precision, recall, and F1 score
accuracy1 = evaluator1.evaluate(predictions, {evaluator1.metricName: "accuracy"})
precision1 = evaluator1.evaluate(predictions, {evaluator1.metricName: "weightedPrecision"})
recall1 = evaluator1.evaluate(predictions, {evaluator1.metricName: "weightedRecall"})
f11 = evaluator1.evaluate(predictions, {evaluator1.metricName: "f1"})

# Print the metrics
print(f"Accuracy: {accuracy1}")
print(f"Precision: {precision1}")
print(f"Recall: {recall1}")
print(f"F1 Score: {f11}")



##10. Second model

#10.1. Build a model


# Create Linear Regression Model
gbt = GBTClassifier()

# Fit the data to the pipeline stages
model_gbt = gbt.fit(train_data)


#10.2. Predict for test data
predictions = model_gbt.transform(test_data)


#10.3. Evaluate the model


# Evaluate the performance of the model
lrEval2 = BinaryClassificationEvaluator(labelCol='label')
auroc2 = lrEval2.evaluate(predictions,{lrEval2.metricName:'areaUnderROC'})
aupr2 = lrEval2.evaluate(predictions,{lrEval2.metricName:'areaUnderPR'})

print(f"AUROC: {auroc2}")
print(f"AUPR: {aupr2}")

# Initialize the MulticlassClassificationEvaluator
evaluator2 = MulticlassClassificationEvaluator(labelCol="label", predictionCol="prediction")

# Compute accuracy, precision, recall, and F1 score
accuracy2 = evaluator2.evaluate(predictions, {evaluator2.metricName: "accuracy"})
precision2 = evaluator2.evaluate(predictions, {evaluator2.metricName: "weightedPrecision"})
recall2 = evaluator2.evaluate(predictions, {evaluator2.metricName: "weightedRecall"})
f12 = evaluator2.evaluate(predictions, {evaluator2.metricName: "f1"})

# Print the metrics

print(f"Accuracy: {accuracy2}")
print(f"Precision: {precision2}")
print(f"Recall: {recall2}")
print(f"F1 Score: {f12}")

#10.4. Hyperparameter optimization


grid = ParamGridBuilder()
grid = grid.addGrid(model_gbt.maxDepth, [2, 5, 10]).addGrid(model_gbt.maxBins, [20, 30]).build()

cv = CrossValidator(estimator = gbt,
                    estimatorParamMaps = grid,
                    evaluator = lrEval2,
                    parallelism = 5,
                    numFolds=3)

cvModel = cv.fit(train_data)
bestModel = cvModel.bestModel



#10.5. Best model 2

model2 = bestModel
pprint(model2.extractParamMap())




#10.6. Save the model to HDFS
model2.write().overwrite().save("project/models/model2")


#10.7. Predict for test data using best model2
predictions = model2.transform(test_data)


predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model2_predictions.csv")



#10.8. Evaluate the best model2


# Evaluate the performance of the model
lrEval2 = BinaryClassificationEvaluator(labelCol='label')
auroc2 = lrEval2.evaluate(predictions,{lrEval2.metricName:'areaUnderROC'})
aupr2 = lrEval2.evaluate(predictions,{lrEval2.metricName:'areaUnderPR'})

print(f"AUROC: {auroc2}")
print(f"AUPR: {aupr2}")

# Initialize the MulticlassClassificationEvaluator
evaluator2 = MulticlassClassificationEvaluator(labelCol="label", predictionCol="prediction")

# Compute accuracy, precision, recall, and F1 score
accuracy2 = evaluator2.evaluate(predictions, {evaluator2.metricName: "accuracy"})
precision2 = evaluator2.evaluate(predictions, {evaluator2.metricName: "weightedPrecision"})
recall2 = evaluator2.evaluate(predictions, {evaluator2.metricName: "weightedRecall"})
f12 = evaluator2.evaluate(predictions, {evaluator2.metricName: "f1"})

# Print the metrics
print(f"Accuracy: {accuracy2}")
print(f"Precision: {precision2}")
print(f"Recall: {recall2}")
print(f"F1 Score: {f12}")


##11. Third Model

#11.1. Model training


# Create Random Forest Model
rf = RandomForestClassifier(featuresCol = 'features', labelCol = 'label')

# Fit the data to the rf model
rfModel = rf.fit(train_data)


#11.2. Prediction

# Transform the data (Prediction)
predictions = rfModel.transform(test_data)

#11.3. Evaluation

# Evaluate the performance of the model
lrEval3 = BinaryClassificationEvaluator(labelCol='label')
auroc3 = lrEval3.evaluate(predictions,{lrEval3.metricName:'areaUnderROC'})
aupr3 = lrEval3.evaluate(predictions,{lrEval3.metricName:'areaUnderPR'})

print(f"AUROC: {auroc3}")
print(f"AUPR: {aupr3}")

# Initialize the MulticlassClassificationEvaluator
evaluator3 = MulticlassClassificationEvaluator(labelCol="label", predictionCol="prediction")

# Compute accuracy, precision, recall, and F1 score
accuracy3 = evaluator3.evaluate(predictions, {evaluator3.metricName: "accuracy"})
precision3 = evaluator3.evaluate(predictions, {evaluator3.metricName: "weightedPrecision"})
recall3 = evaluator3.evaluate(predictions, {evaluator3.metricName: "weightedRecall"})
f13 = evaluator3.evaluate(predictions, {evaluator3.metricName: "f1"})

# Print the metrics
print(f"Accuracy: {accuracy3}")
print(f"Precision: {precision3}")
print(f"Recall: {recall3}")
print(f"F1 Score: {f13}")


#11.4. Hyperparameter optimization

grid = ParamGridBuilder()
grid = grid.addGrid(rfModel.numTrees, [10, 20, 30]) \
    .addGrid(rfModel.maxDepth, [3, 5, 10])\
    .build()

cv = CrossValidator(estimator = rf,
                    estimatorParamMaps = grid,
                    evaluator = lrEval3,
                    parallelism = 5,
                    numFolds=3)

cvModel = cv.fit(train_data)
bestModel = cvModel.bestModel


#11.5. Select best model

model3 = bestModel
pprint(model3.extractParamMap())


#11.6. Save the model to HDFS

model3.write().overwrite().save("project/models/model3")



#11.7. Prediction

predictions = model3.transform(test_data)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model3_predictions.csv")


#11.8. Evaluation

# Evaluate the performance of the model
lrEval3 = BinaryClassificationEvaluator(labelCol='label')
auroc3 = lrEval3.evaluate(predictions,{lrEval3.metricName:'areaUnderROC'})
aupr3 = lrEval3.evaluate(predictions,{lrEval3.metricName:'areaUnderPR'})

print(f"AUROC: {auroc3}")
print(f"AUPR: {aupr3}")

# Initialize the MulticlassClassificationEvaluator
evaluator3 = MulticlassClassificationEvaluator(labelCol="label", predictionCol="prediction")

# Compute accuracy, precision, recall, and F1 score
accuracy3 = evaluator3.evaluate(predictions, {evaluator3.metricName: "accuracy"})
precision3 = evaluator3.evaluate(predictions, {evaluator3.metricName: "weightedPrecision"})
recall3 = evaluator3.evaluate(predictions, {evaluator3.metricName: "weightedRecall"})
f13 = evaluator3.evaluate(predictions, {evaluator3.metricName: "f1"})

# Print the metrics

print(f"Accuracy: {accuracy3}")
print(f"Precision: {precision3}")
print(f"Recall: {recall3}")
print(f"F1 Score: {f13}")

#12. Compare best models
models = [["LogisticRegressionModel",auroc1, accuracy1, f11],
          ["GBTClassificationModel",auroc2, accuracy2, f12],
          ["RandomForestClassificationModel",auroc3, accuracy3, f13]]

df = spark.createDataFrame(models, ["model", "AUROC", "Accuracy", "F1"])

df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/evaluation.csv")
