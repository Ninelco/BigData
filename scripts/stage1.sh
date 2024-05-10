#!/bin/bash
url="https://disk.yandex.ru/d/SO01y2lVh9-uYA"

rm data/data.zip

wget "$(yadisk-direct $url)" -O data/data.zip

unzip data/data.zip -d data/

python3 scripts/build_projectdb.py

password=$(head -n 1 secrets/.psql.pass)

#sqoop list-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team9_projectdb --username team9 --password $password
# Delete anything from warehouse
hdfs dfs -rm -R -skipTrash project/warehouse/*
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team9_projectdb --username team9 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1

mv *.java output/
mv *.avsc output/