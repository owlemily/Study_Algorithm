from collections import Counter
def solution(nums):
    answer = 0
    count = Counter(nums)
    if len(count) <= len(nums) / 2:
        answer = len(count)
    else:
        answer = len(nums) / 2
    return answer