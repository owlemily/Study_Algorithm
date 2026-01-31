-- 코드를 입력하세요
/*SELECT CAR_ID, case when ((start_date = '2022-10-16') or (end_date = '2022-10-16') or (start_date < '2022-10-16' and end_date >= '2022-10-16')) then '대여중'
else '대여 가능' end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID DESC*/

-- 차 목록과 대여 히스토리를 분리해서 생각할 필요가 있다. 
select CAR_ID,
case when exists(
    select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.CAR_ID = car.CAR_ID 
    and ((start_date = '2022-10-16') 
         or (end_date = '2022-10-16')
        or (start_date < '2022-10-16' and end_date >= '2022-10-16'))
) then '대여중' else '대여 가능' end as AVAILABILITY
from (select distinct CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY) car
order by CAR_ID DESC