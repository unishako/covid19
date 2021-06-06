CREATE TABLE covid19
(
    yyyy_mm_dd                     DATE,
    prefectures_code               CHAR(2),
    prefectures_name               VARCHAR(10),
    infection_person_count_one_day INTEGER,
    infection_person_count_total   INTEGER,
    dead_count_one_day             INTEGER,
    dead_count_total               INTEGER,
    PRIMARY KEY (yyyy_mm_dd, prefectures_code)
);

CREATE TABLE prefectures
(
    prefectures_code CHAR(2),
    prefectures_name VARCHAR(10),
    PRIMARY KEY (prefectures_code)
);
