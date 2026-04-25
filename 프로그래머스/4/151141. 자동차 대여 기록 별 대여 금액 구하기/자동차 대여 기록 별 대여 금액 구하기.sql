-- 코드를 입력하세요
-- history와 car 테이블을 합쳐서 -> 기록별로 자동차 타입과 duration_type, 대여기간->  계산해서 base 테이블 만들기
-- discount_plan과 조인해서 discount_rate 열 합치기
-- 마지막에 price와 대여기간 곱하고, discount_rate 게산해서 히스토리 id, fee 추출하기
with base_truck as(
    SELECT h.HISTORY_ID, h.CAR_ID, (DATEDIFF(h.END_DATE, h.START_DATE) + 1) as duration, 
    CASE WHEN (DATEDIFF(h.END_DATE, h.START_DATE)+1) >= 90 then '90일 이상'
         WHEN (DATEDIFF(h.END_DATE, h.START_DATE)+1) >= 30 then '30일 이상'
         WHEN (DATEDIFF(h.END_DATE, h.START_DATE)+1) >= 7 then '7일 이상'
    ELSE '기타' END AS DURATION_TYPE,
    c.CAR_TYPE, c.DAILY_FEE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    LEFT JOIN CAR_RENTAL_COMPANY_CAR c on c.CAR_ID = h.CAR_ID
    WHERE c.CAR_TYPE = '트럭'
), 
discount_table as(
    SELECT bt.HISTORY_ID, bt.CAR_ID, bt.duration, bt.DAILY_FEE, dp.DURATION_TYPE, dp.DISCOUNT_RATE
    from base_truck bt
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp on dp.DURATION_TYPE = bt.DURATION_TYPE and dp.CAR_TYPE = bt.car_type
)
SELECT HISTORY_ID, CASE WHEN DISCOUNT_RATE is null then (DAILY_FEE * DURATION) ELSE ((DAILY_FEE * duration) - (DAILY_FEE * duration)*(DISCOUNT_RATE/100)) END AS FEE
FROM discount_table
order by FEE DESC, HISTORY_ID DESC