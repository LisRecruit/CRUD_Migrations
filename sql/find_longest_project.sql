--WITH project_durations AS (
--    SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE,
--           EXTRACT(YEAR FROM (FINISH_DATE, START_DATE)) * 12 +
--           EXTRACT(MONTH FROM (FINISH_DATE, START_DATE)) AS duration_months
--    FROM project
--)
--SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE, duration_months
--FROM project_durations
--WHERE duration_months = (
--    SELECT MAX(duration_months)
--    FROM project_durations
--);

WITH project_durations AS (
    SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE,
           DATEDIFF(FINISH_DATE, START_DATE) AS duration_days
    FROM project
)
SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE,
       duration_days / 30 AS duration_months
FROM project_durations
WHERE duration_days = (

    SELECT MAX(duration_days)
    FROM project_durations
);