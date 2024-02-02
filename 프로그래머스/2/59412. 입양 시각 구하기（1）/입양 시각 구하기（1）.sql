SELECT DATE_FORMAT(DATETIME, "%H") AS HOUR, COUNT(*)
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, "%H") BETWEEN 9 AND 20
GROUP BY DATE_FORMAT(DATETIME, "%H")
ORDER BY HOUR