DROP DATABASE IF EXISTS team9_projectdb CASCADE;

CREATE DATABASE team9_projectdb LOCATION "project/hive/warehouse";
USE team9_projectdb;

CREATE EXTERNAL TABLE CTR STORED AS AVRO LOCATION 'project/warehouse/ctr' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/ctr.avsc');

-- SELECT * FROM CTR;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

CREATE EXTERNAL TABLE ctr_part(session_id int, DateTime TIMESTAMP, user_id int, campaign_id int, webpage_id int, product_category_1 int, product_category_2 FLOAT, user_group_id FLOAT, gender VARCHAR(6), age_level FLOAT, user_depth FLOAT, city_development_index FLOAT, var_1 int, is_click int) PARTITIONED BY (product CHAR(1)) STORED AS AVRO LOCATION 'project/hive/warehouse/ctr_part' TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT INTO ctr_part
PARTITION (product)
SELECT session_id, from_unixtime(FLOOR(CAST(DateTime AS BIGINT)/1000), 'yyyy-MM-dd HH:mm:ss.SSS') as DateTime, user_id, campaign_id, webpage_id, product_category_1, product_category_2, user_group_id, gender, age_level, user_depth, city_development_index, var_1, is_click, product
FROM CTR;

DROP TABLE CTR;
