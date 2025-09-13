-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(*) AS count
from animal_ins
group by ANIMAL_TYPE
order by animal_type