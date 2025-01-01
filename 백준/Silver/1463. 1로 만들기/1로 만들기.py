N = int(input())
count = dict()
count[1] = 0

for i in range(2, N+1):
    count[i] = count[i-1] + 1 #1을 더해주는 것이 계산 횟수 더하는 것임
    if(i % 2 == 0):
        count [i] = min(count[i], count[i//2]+1) #1을 뺸 값과 2로 나눈 값 중 작은 횟수인 것을 선택하기
    if(i%3 == 0):
        count[i] = min(count[i], count[i//3]+1)
        
        
print(count[N])

