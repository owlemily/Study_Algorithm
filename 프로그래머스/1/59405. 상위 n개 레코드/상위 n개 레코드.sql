with rank_date as(
select name, ROW_NUMBER() OVER(order by DATETIME, animal_id) as rn
from animal_ins)
select name
from rank_date
where rn = 1


