-- 2022.11.01~2022.11.30 대여해야하니까 history에 없는 자동차 중 -> 세단, SUV 이고 -> 대여금액 : 30일 x daily fee x(1-할인율) 
with base_car as(
    select c.CAR_ID, c.CAR_TYPE, c.DAILY_FEE, c.OPTIONS
    from CAR_RENTAL_COMPANY_CAR c
    where not exists(
        select 1
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        where c.CAR_ID = h.CAR_ID
        and START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'
    )
    and (c.CAR_TYPE = '세단' or c.CAR_TYPE = 'SUV')
) 
select b.CAR_ID, b.CAR_TYPE, (30 * b.DAILY_FEE * (1- p.DISCOUNT_RATE/100)) as FEE
from base_car b
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on p.CAR_TYPE = b.CAR_TYPE and DURATION_TYPE = '30일 이상'
where (30 * b.DAILY_FEE * (1- p.DISCOUNT_RATE/100)) >=500000 and (30 * b.DAILY_FEE * (1- p.DISCOUNT_RATE/100)) < 2000000
ORDER BY FEE DESC, b.CAR_TYPE ASC, b.CAR_ID DESC 