-- 코드를 입력하세요
/*SELECT CAR_ID, case when ((start_date = '2022-10-16') or (end_date = '2022-10-16') or (start_date < '2022-10-16' and end_date >= '2022-10-16')) then '대여중'
else '대여 가능' end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID DESC*/

WITH base AS(SELECT CAR_ID,
    CASE WHEN START_DATE <= '2022-10-16' and END_DATE >= '2022-10-16' then 1 else 0 end as AVAILABLE_CNT
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
)
SELECT CAR_ID, CASE WHEN SUM(AVAILABLE_CNT) >= 1 then '대여중' ELSE '대여 가능' end as AVAILABILITY
from base
group by car_id
order by car_id desc