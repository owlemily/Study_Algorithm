-- 코드를 작성해주세요
Select ID, Case when SIZE_OF_COLONY <= 100 then 'LOW'
when (SIZE_OF_COLONY > 100 and SIZE_OF_COLONY <= 1000) then 'MEDIUM'
when SIZE_OF_COLONY > 1000 then 'HIGH' End SIZE
from ECOLI_DATA
order by ID