import sys
input = sys.stdin.readline
N, M = map(int, input().strip().split())
n_list = list(map(int, input().strip().split()))

sum = [0] * (N+1) #index 1부터 N까지로 하기 위해 각 인덱스까지의 합을 저장하기

for i in range(1, N+1):
    sum[i] = sum[i-1] + n_list[i-1] #n_list의 인덱스는 0부터임을 주의
    
answer = list()
    
for i in range(M):
    start, end = map(int, input().split())
    result = sum[end] - sum[start-1]
    answer.append(result)
    
for i in answer:
    print(i)


