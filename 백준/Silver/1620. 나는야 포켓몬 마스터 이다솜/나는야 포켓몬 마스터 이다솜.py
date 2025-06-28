import sys
input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())

dict = {}

for i in range(N):
    name = input()
    dict[i+1] = name
    dict[name] = i+1

for j in range(M):
    q = input()
    if q.isdigit():
        print(dict[int(q)])
    else:
        print(dict[q])
     