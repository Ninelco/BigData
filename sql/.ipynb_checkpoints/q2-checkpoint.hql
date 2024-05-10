USE team9_projectdb;

DROP TABLE IF EXISTS q2_results;
-- CREATE EXTERNAL TABLE q2_results(
-- average_age DOUBLE)
CREATE EXTERNAL TABLE q2_results (gender STRING, count BIGINT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q2';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
-- SELECT AVG(age_level) AS average_age
-- FROM ctr_part;
SELECT gender, COUNT(*) as count
FROM ctr_part
GROUP BY gender;

SELECT * FROM q2_results;
