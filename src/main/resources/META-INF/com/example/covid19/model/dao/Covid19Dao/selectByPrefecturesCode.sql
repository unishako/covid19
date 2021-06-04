SELECT /*%expand*/*
FROM covid19
WHERE prefectures_code = /* prefecturesCode */'21'
ORDER BY yyyy_mm_dd;