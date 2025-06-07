N = int(input())
size = list(map(int, input().split()))
T, P = map(int, input().split())

count_T = 0
# 티셔츠를 살 때 나머지가 있다면 몫을 1더해라. = 사야할 묶음의 개수
for i in size:
    if i%T != 0:
        count_T += (i//T) + 1
    else:
        count_T += (i//T)

print(count_T)
print(N//P, end=" ")
print(N%P)