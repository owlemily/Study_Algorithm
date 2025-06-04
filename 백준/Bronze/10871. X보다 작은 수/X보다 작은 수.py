N, X = map(int, input().split())
nums = list(map(int, input().split()))

for j in nums:
    if j < X:
        print(j, end = " ")