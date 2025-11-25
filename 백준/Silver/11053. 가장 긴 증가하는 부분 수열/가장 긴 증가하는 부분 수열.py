'''
N = int(input())
ls = list(map(int, input().split()))

from collections import deque
q = deque(ls)
answer = []
answer.append(q.popleft())
while(q):
    a = q.popleft()
    if a > answer[-1]:
        answer.append(a)
    

print(len(answer))
'''

# 가장 긴 수열이 포인트
N = int(input())
ls = list(map(int, input().split()))

len_ls = [1] * (N)
if len(ls) == 1:
    print(1)
else:
    for i in range(1, N):
        for j in range(i):
            if ls[i]>ls[j]:
                len_ls[i] = max(len_ls[j]+1, len_ls[i])


    print(max(len_ls))