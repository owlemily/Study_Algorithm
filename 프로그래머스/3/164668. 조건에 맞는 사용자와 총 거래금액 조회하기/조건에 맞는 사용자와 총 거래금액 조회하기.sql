-- 코드를 입력하세요
-- 거래 완료 된 건 status
-- Board_id와 user_id 조인
-- price 합치기
with done_list as(
   SELECT WRITER_ID, PRICE, STATUS
   FROM USED_GOODS_BOARD
   where status = 'DONE'
)
select u.USER_ID as USER_ID, u.NICKNAME, SUM(d.PRICE) as TOTAL_SALES
from done_list d
left join USED_GOODS_USER u on u.USER_ID = d.WRITER_ID
group by u.USER_ID, u.NICKNAME
having SUM(d.PRICE) >= 700000
order by TOTAL_SALES