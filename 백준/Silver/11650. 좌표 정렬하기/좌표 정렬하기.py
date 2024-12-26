import sys
input = sys.stdin.readline

N = int(input())
nums = list()

for i in range (N):
    x, y = list(map(int, input().split()))
    nums.append([x, y])
    
    
nums.sort(key = lambda x: x[1])
nums.sort(key = lambda x: x[0])

for i in nums:
    print(i[0], i[1])