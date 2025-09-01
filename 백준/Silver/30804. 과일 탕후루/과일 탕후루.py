from collections import defaultdict

N = int(input())
arr = list(map(int, input().split()))

left = 0
fruit = defaultdict(int)
kind_count = 0
answer = 0

for right in range(N):
    if fruit[arr[right]] == 0:
        kind_count += 1
    fruit[arr[right]] += 1

    while kind_count > 2:
        fruit[arr[left]] -= 1
        if fruit[arr[left]] == 0:
            kind_count -= 1
        left += 1

    answer = max(answer, right - left + 1)

print(answer)
