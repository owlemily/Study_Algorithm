from collections import deque
n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

answer = [[-1] * m for _ in range(n)]
q = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            answer[i][j] = 0 #애초에 못가는 땅
        if graph[i][j] == 2:
            answer[i][j] = 0
            q.append((i, j)) #q초기화
#상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(): #시작점 위치 튜플
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = dx[k] + x
            ny = dy[k] + y
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0: #못가는땅이면 스킵
                continue
            if answer[nx][ny] != -1: #이미 방문했다는 뜻
                continue
            answer[nx][ny] = answer[x][y] + 1
            q.append((nx, ny))

bfs()
for i in range(n):
    print(*answer[i])




