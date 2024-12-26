import sys
input = sys.stdin.readline
N = int(input())
nums = list()
for i in range(N):
    num = int(input())
    nums.append(num)
    
nums.sort(reverse=False)

for num in nums:
    print(num)