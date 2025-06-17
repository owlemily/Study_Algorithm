from collections import deque

N, K = map(int, input().split())
dq = deque(range(1, N+1))
answer = []

while dq:
    dq.rotate(-(K-1))  # 왼쪽으로 K-1만큼 회전
    answer.append(dq.popleft())

print("<", end="")
print(", ".join(map(str, answer)), end=">")
