LOAD DATA LOCAL INFILE '/docker-entrypoint-initdb.d/pref.csv' INTO TABLE prefectures FIELDS TERMINATED BY ',' ENCLOSED BY '"' IGNORE 1 LINES;
