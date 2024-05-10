USE team9_projectdb;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results
(user_group_id INT,
  count BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q4';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
-- SELECT gender, AVG(product) AS product
-- FROM ctr_part
-- GROUP BY gender;
SELECT user_group_id, COUNT(*) as count
FROM ctr_part
WHERE user_group_id IS NOT NULL
GROUP BY user_group_id;


SELECT * FROM q4_results;
