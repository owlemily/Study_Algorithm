-- 코드를 작성해주세요
SELECT COUNT(*) as COUNT
FROM ECOLI_DATA
WHERE 1=1 and (GENOTYPE & 2) != 2 and ((GENOTYPE & 1) = 1 or (GENOTYPE & 4) = 4)