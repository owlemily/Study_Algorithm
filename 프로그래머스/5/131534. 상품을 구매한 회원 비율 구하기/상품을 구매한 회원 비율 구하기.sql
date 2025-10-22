-- 코드를 입력하세요
-- 코드를 입력하세요
WITH joined_2021 AS( -- 2021년도에 가입한 고객
    SELECT *
    from USER_INFO u
    WHERE u.JOINED LIKE '2021%'
),
purchase AS( -- 2021년도에 가입한 고객 중 실제 구매한 고객
    Select s.USER_ID, s.SALES_DATE
    from ONLINE_SALE s
    JOIN joined_2021 j ON j.USER_ID = s.USER_ID
)

SELECT 
YEAR(SALES_DATE) as YEAR, 
MONTH(SALES_DATE) as MONTH,
count(DISTINCT p.USER_ID) as PURCHASED_USERS,
ROUND(count(DISTINCT p.USER_ID)/
     (j.all_cnt),1)as PURCHASED_RATIO
from purchase p
CROSS JOIN (SELECT count(DISTINCT USER_ID) as all_cnt from joined_2021) AS j
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE)
ORDER BY YEAR, MONTH;