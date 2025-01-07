import sys
input = sys.stdin.readline

n = int(input())
answer = [0] * (n+1)
score = [0] *(n+1)
for i in range(1, n+1):
    score[i] = int(input())

for i in range(1, n+1):
    if i == 1:
        answer[i] = score[i]
    elif i == 2:
        answer[i] = answer[1] + score[i]
    else:
        answer[i] = max(answer[i-3]+score[i-1]+score[i], answer[i-2]+score[i])
        
        
print(answer[n])

