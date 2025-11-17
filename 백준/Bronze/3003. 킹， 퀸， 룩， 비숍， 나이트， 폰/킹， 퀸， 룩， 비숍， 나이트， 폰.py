# 3003번 킹, 퀸, 룩, 비숍, 나이트, 폰
n = list(map(int, input().split()))

# 원래 필요한 말의 개수.
right_nums = [1, 1, 2, 2, 2, 8]

# 입력과 필요한 말의 개수를 비교해준다.
for i in range(6):
    print(right_nums[i] - n[i], end=" ")