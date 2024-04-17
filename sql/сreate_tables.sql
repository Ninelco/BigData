START TRANSACTION;

CREATE TABLE IF NOT EXISTS CTR (
    session_id INTEGER NOT NULL PRIMARY KEY,
    DateTime TIMESTAMP NOT NULL,
    user_id INTEGER NOT NULL,
    product CHAR(1) NOT NULL,
    campaign_id INTEGER NOT NULL,
    webpage_id INTEGER NOT NULL,
    product_category_1 INTEGER,
    product_category_2 FLOAT,
    user_group_id FLOAT,
    gender VARCHAR(6),
    age_level FLOAT,
    user_depth FLOAT,
    city_development_index FLOAT,
    var_1 INTEGER,
    is_click INTEGER NOT NULL
);

COMMIT;