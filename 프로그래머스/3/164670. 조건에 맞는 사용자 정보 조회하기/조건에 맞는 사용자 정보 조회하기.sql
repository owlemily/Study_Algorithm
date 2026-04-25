-- 코드를 입력하세요
-- 게시물을 3건 이상 등록한 사용자
with base_user as(
    select WRITER_ID, COUNT(BOARD_ID) as cnt
    from USED_GOODS_BOARD
    group by WRITER_ID
    having cnt >= 3
)

SELECT bu.WRITER_ID, gu.NICKNAME, 
CONCAT(gu.CITY, " ", gu.STREET_ADDRESS1, " ", gu.STREET_ADDRESS2) AS 전체주소, 
CONCAT(SUBSTRING(gu.TLNO, 1, 3), '-', SUBSTRING(gu.TLNO, 4, 4), '-', SUBSTRING(gu.TLNO, 8, 4)) as 전화번호
FROM base_user bu
LEFT JOIN USED_GOODS_USER gu ON gu.USER_ID = bu.WRITER_ID
ORDER BY bu.WRITER_ID DESC