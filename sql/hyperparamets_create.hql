USE team9_projectdb;

drop TABLE if EXISTS hyperparametrs_1;
CREATE TABLE IF NOT EXISTS hyperparametrs_1 (
    Parameter varchar(200),
    Tuned_Value string,
    Grid_Search_Range string
);

INSERT INTO hyperparametrs_1(
    Parameter, Tuned_Value, Grid_Search_Range
)
values(
"regParam","0.01","[0.1, 0.01]"),
(
"fitIntercept","True","[False, True]"
),
("elasticNetParam","0.0","[0.0, 0.5, 1.0]");

select * from hyperparametrs_1;


drop TABLE if EXISTS hyperparametrs_2;
CREATE TABLE IF NOT EXISTS hyperparametrs_2 (
    Parameter varchar(200),
    Tuned_Value float,
    Grid_Search_Range string
);

INSERT INTO hyperparametrs_2(
    Parameter, Tuned_Value, Grid_Search_Range
)
values
("maxDepth",10,"[2, 5, 10]"),

("maxBins",30,"[20, 30]");

select * from hyperparametrs_2;



drop TABLE if EXISTS hyperparametrs_3;

CREATE TABLE IF NOT EXISTS hyperparametrs_3 (
    Parameter varchar(200),
    Tuned_Value float,
    Grid_Search_Range string
);

INSERT INTO hyperparametrs_3(
    Parameter, Tuned_Value, Grid_Search_Range
)
values
("numTrees",30,"[10, 20, 30]"),
("maxDepth",10,"[3, 5, 10]");

select * from hyperparametrs_3;