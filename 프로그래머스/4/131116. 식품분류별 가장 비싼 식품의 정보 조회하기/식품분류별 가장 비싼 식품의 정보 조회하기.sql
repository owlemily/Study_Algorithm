-- 코드를 입력하세요
/*SELECT CATEGORY, max(PRICE) over(PARTITION BY CATEGORY) as MAX_PRICE, PRODUCT_NAME
from food_product
where category = '과자' or category = '국'or category = '김치' or category = '식용유'
group by category
order by price desc */

with base as(select CATEGORY, max(PRICE) as MAX_PRICE
from food_product
group by category
having category = '과자' or category ='국' or category ='김치' or category ='식용유'
)
select b.category, b.max_price, f.product_name
from food_product f
join base b on b.MAX_PRICE = f.PRICE and b.CATEGORY = f.CATEGORY
order by b.max_price desc
