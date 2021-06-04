CREATE TABLE covid19
(
    yyyy_mm_dd                     DATE,
    prefectures_code               CHAR(2),
    prefectures_name               VARCHAR(10),
    infection_person_count_one_day INTEGER,
    infection_person_count_total   INTEGER,
    dead_count_one_day             INTEGER,
    dead_count_total               INTEGER
);

LOAD
DATA LOCAL INFILE '/docker-entrypoint-initdb.d/nhk_news_covid19_prefectures_daily_data.csv' INTO TABLE covid19 FIELDS TERMINATED BY ',' ENCLOSED BY '"' IGNORE 1 LINES;
