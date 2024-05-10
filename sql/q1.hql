USE team9_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results(
webpage_id INT, count INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q1';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
-- SELECT COUNT(DISTINCT user_id) AS unique_users
-- FROM ctr_part;
SELECT webpage_id, COUNT(*) as count
FROM ctr_part
WHERE webpage_id IS NOT NULL
GROUP BY webpage_id;

INSERT OVERWRITE DIRECTORY 'project/output/q1'
    ROW FORMAT DELIMITED FIELDS
    TERMINATED BY ','
SELECT * FROM q1_results;

