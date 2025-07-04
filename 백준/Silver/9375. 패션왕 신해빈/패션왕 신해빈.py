import sys
from itertools import combinations
input = lambda: sys.stdin.readline().rstrip()
T = int(input())
for i in range(T):
    n = int(input())
    dict = {}
    for j in range(n):
        name, kind = input().split()
        if kind in dict.keys():
            dict[kind].append(name)
        else:
            dict[kind] = [name]
    answer = 1
    for k in dict:
        answer *= len(dict[k])+1
    print(answer - 1)




    
