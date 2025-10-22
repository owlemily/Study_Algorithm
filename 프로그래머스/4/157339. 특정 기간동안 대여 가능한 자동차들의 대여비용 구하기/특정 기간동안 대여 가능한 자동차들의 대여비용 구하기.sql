WITH possible as(
    SELECT r.CAR_ID, r.CAR_TYPE, r.DAILY_FEE
    from CAR_RENTAL_COMPANY_CAR r
    where (r.CAR_TYPE = '세단' or r.CAR_TYPE = 'SUV')
    and not exists (
        SELECT 1
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        where h.START_DATE < '2022-12-01' and h.END_DATE >= '2022-11-01'
        and r.CAR_ID=h.CAR_ID
    )
),
fee as(
    select p.CAR_ID, p.CAR_TYPE, FLOOR(p.DAILY_FEE * 30 *(1 - d.DISCOUNT_RATE/100)) as FEE
    from possible p
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d ON p.CAR_TYPE=d.CAR_TYPE and d.DURATION_TYPE = '30일 이상'
)

select *
from fee
where FEE >= 500000 and FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC