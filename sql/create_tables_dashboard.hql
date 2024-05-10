USE team9_projectdb;

CREATE TABLE IF NOT EXISTS evaluation (
    model varchar(200),
    AUROC float,
    Accuracy float,
    F1 float
)
row format delimited fields terminated by ',';
LOAD DATA INPATH '../team9/project/output/evaluation.csv' OVERWRITE INTO TABLE evaluation;

CREATE TABLE IF NOT EXISTS model1_predictions (
    label float,
    prediction float
)
row format delimited fields terminated by ',';
LOAD DATA INPATH '../team9/project/output/model1_predictions.csv' OVERWRITE INTO TABLE model1_predictions;

CREATE TABLE IF NOT EXISTS model2_predictions (
    label float,
    prediction float
)
    row format delimited fields terminated by ',';
LOAD DATA INPATH '../team9/project/output/model2_predictions.csv' OVERWRITE INTO TABLE model2_predictions;

CREATE TABLE IF NOT EXISTS model3_predictions (
    label float,
    prediction float
)
    row format delimited fields terminated by ',';
LOAD DATA INPATH '../team9/project/output/model3_predictions.csv' OVERWRITE INTO TABLE model3_predictions;


