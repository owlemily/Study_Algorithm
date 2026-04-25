-- 코드를 입력하세요
-- 대여 시작일 조건
-- 대여 횟수가 5회 이상
With base as(
    SELECT  CAR_ID, COUNT(*) as rental_count
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE >= '2022-08-01' and START_DATE <= '2022-10-31'
    group by CAR_ID
    having COUNT(*) >= 5
)
SELECT MONTH(h.START_DATE) as MONTH, h.CAR_ID as CAR_ID, COUNT(h.HISTORY_ID) AS RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
join base b on b.CAR_ID = h.CAR_ID
where h.START_DATE >= '2022-08-01' and h.START_DATE<= '2022-10-31'
GROUP BY MONTH(h.START_DATE), h.CAR_ID
-- having COUNT(h.HISTORY_ID) > 0
ORDER BY MONTH(h.START_DATE), CAR_ID DESC

    