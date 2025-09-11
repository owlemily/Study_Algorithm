-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, CASE when (SEX_UPON_INTAKE like '%Neutered%') or (SEX_UPON_INTAKE like '%Spayed%') then 'O' else 'X' END AS '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
