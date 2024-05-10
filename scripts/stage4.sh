#!/bin/bash

hdfs dfs -put output/evaluation.csv project/output
hdfs dfs -put output/model1_predictions.csv project/output
hdfs dfs -put output/model2_predictions.csv project/output
hdfs dfs -put output/model3_predictions.csv project/output

password=$(head -n 1 secrets/.hive.pass)

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/create_tables_dashboard.hql


beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/hyperparamets_create.hql

