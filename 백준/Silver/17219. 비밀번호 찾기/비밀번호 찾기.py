import sys
input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())
dict = {}
for i in range(N):
    url, num = input().split()
    dict[url] = num

for j in range(M):
    s = input()
    if s in dict.keys():
        print(dict[s])

