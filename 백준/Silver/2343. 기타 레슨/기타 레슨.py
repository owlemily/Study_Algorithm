N, M = map(int, input().split())
lectures = list(map(int, input().split()))

left = max(lectures)  # 가장 긴 강의보다 작으면 그 강의를 담을 수 없음
right = sum(lectures)
result = right

def count_bluelays(mid):
    cnt = 1
    total = 0
    for lec in lectures:
        if total + lec > mid:
            cnt += 1
            total = 0
        total += lec
    return cnt

while left <= right:
    mid = (left + right) // 2
    cnt = count_bluelays(mid)
    if cnt <= M:
        result = mid
        right = mid - 1
    else:
        left = mid + 1

print(result)
