N, M = map(int, input().split())
move = [i for i in range(0, 101)]

for i in range(N):
    a, b = map(int, input().split())
    move[a] = b
for j in range(M):
    a, b = map(int, input().split())
    move[a] = b

dist = [-1] * 101 #방문 표시
from collections import deque
q = deque()
q.append(1)
while q:
    x = q.popleft()
    if x == 100:
        break
    for d in range(1, 7):
        nx = x + d
        if nx > 100:
            continue
        nx = move[nx] #사다리 뱀적용
        if dist[nx] == -1 : #처음가는칸
            dist[nx] = dist[x] + 1
            q.append(nx)

print(dist[100] + 1)


