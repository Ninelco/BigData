USE team9_projectdb;

DROP TABLE IF EXISTS q5_results;
CREATE EXTERNAL TABLE q5_results(
campaign_id STRING,
total_clicks INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q5';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT campaign_id, SUM(is_click) AS total_clicks
FROM ctr_part
GROUP BY campaign_id;

SELECT * FROM q5_results;
