N, M = map(int, input().split())
nums = list(map(int, input().split()))

nums.sort()
visited = [0] * N
s = []

def dfs():
    if len(s) == M:          # 🌟 기저(멈추는 조건)
        print(*s)
        return

    prev = None              # 이번 depth에서 이미 사용한 값

    for i in range(len(nums)):
        if visited[i]:
            continue
        if prev == nums[i]:  # 같은 값으로 시작하는 분기를 한 번만!
            continue

        prev = nums[i]

        visited[i] = 1
        s.append(nums[i])

        dfs()

        s.pop()
        visited[i] = 0

dfs()
