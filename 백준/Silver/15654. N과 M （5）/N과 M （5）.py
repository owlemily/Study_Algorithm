N, M = map(int, input().split())

nums = list(map(int, input().split()))

nums.sort()

s = []
def dfs(start):
    if len(s) == M:
        print(' '.join(map(str, s)))
        return

    for i in range(0, len(nums)):
        if nums[i] in s:
            continue
        s.append(nums[i])
        dfs(i)
        s.pop()


dfs(0)
