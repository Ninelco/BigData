USE team9_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results(
product STRING,
total_clicks INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q3';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT product, SUM(is_click) AS total_clicks
FROM ctr_part
-- WHERE product IN ('J', 'I')
GROUP BY product;

INSERT OVERWRITE DIRECTORY 'project/output/q3'
    ROW FORMAT DELIMITED FIELDS
    TERMINATED BY ','
SELECT * FROM q3_results;
