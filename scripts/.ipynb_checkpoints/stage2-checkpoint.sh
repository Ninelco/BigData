#!/bin/bash
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc

password=$(head -n 1 secrets/.hive.pass)

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/db.hql > output/hive_results.txt 2> /dev/null

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/q1.hql
echo "webpage_id, count" > output/q1.csv 
hdfs dfs -cat project/output/q1/* >> output/q1.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/q2.hql
echo "gender, count" > output/q2.csv 
hdfs dfs -cat project/output/q2/* >> output/q2.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/q3.hql
echo "product, total_clicks" > output/q3.csv 
hdfs dfs -cat project/output/q3/* >> output/q3.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/q4.hql
echo "user_group_id, count" > output/q4.csv 
hdfs dfs -cat project/output/q4/* >> output/q4.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team9 -p $password -f sql/q5.hql
echo "campaign_id, total_clicks" > output/q5.csv 
hdfs dfs -cat project/output/q5/* >> output/q5.csv

