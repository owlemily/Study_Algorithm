import sys
input = sys.stdin.readline
N, M = map(int, input().split())
never_heard = list()
never_seen = list()
for i in range (N):
    never_heard.append(input().strip())
for j in range(M):
    never_seen.append(input().strip())


answer = list(set(never_heard) & set(never_seen))
answer.sort()
count = len(answer)
print(count)
for i in answer:
    print(i)