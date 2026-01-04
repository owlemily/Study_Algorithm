-- 코드를 입력하세요
with base as(
    SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES, 
    ROW_NUMBER() OVER(PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC, REST_ID) as rank_fav
    from rest_info
)
select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from base
where rank_fav = 1
order by FOOD_TYPE DESC


