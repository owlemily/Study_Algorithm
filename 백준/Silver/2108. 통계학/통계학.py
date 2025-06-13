import sys

input = lambda: sys.stdin.readline().strip()
N = int(input())
nums = []

for i in range(N):
    num = int(input())
    nums.append(num)

nums.sort()
temp = 0
for i in nums:
    temp += i

#산술평균
mean_num = round(temp/N)
print(mean_num)
#중앙값
print(nums[N//2])
# 최빈값
dic = dict()
for i in nums:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1
maximum = max(dic.values()) #가장 큰 빈도수수
mx = [] #최빈값들 저장하기기

for i in dic:
    if dic[i] == maximum:
        mx.append(i)
mx.sort()
if len(mx) == 1:
    print(mx[0])
else:
    print(mx[1])

# 범위
print(max(nums) - min(nums))

