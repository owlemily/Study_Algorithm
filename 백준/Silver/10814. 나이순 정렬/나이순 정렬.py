import sys
input = sys.stdin.readline

N = int(input())
members = list()
for i in range(N):
    age, name = input().split()
    age = int(age)
    members.append([age, name])
    
members.sort(key = lambda x: x[0])
for i in members:
    print(i[0], i[1])

    