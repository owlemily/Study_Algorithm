import sys
sys.setrecursionlimit(10**6)  # 이 줄 추가!
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(str, input())))

non_color = [['']*N for _ in range(N)] # 리스트내부 초기화 중요

for i in range(N):
    for j in range(N):
        if graph[i][j] == 'G':
            non_color[i][j] = 'R'
        else:
            non_color[i][j] = graph[i][j]
#print(graph)
#print(non_color)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited1 = [[0]* N for _ in range(N)]
visited2 = [[0]* N for _ in range(N)]

def dfs(visited, picture, x, y):
    visited[x][y] = 1
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx<0 or nx >=N or ny<0 or ny>=N or visited[nx][ny] == 1:
            continue
        if picture[nx][ny] == picture[x][y] and visited[nx][ny] == 0:
            dfs(visited, picture, nx, ny)
    

answer1 = 0
answer2 = 0
for i in range(N):
    for j in range(N):
        if visited1[i][j] == 1 and visited2[i][j]==1:
            continue
        if visited1[i][j] == 0:
            dfs(visited1, graph, i, j)
            answer1 += 1
            
        if visited2[i][j] == 0:
            dfs(visited2, non_color, i, j)
            answer2 += 1
        
            
        
print(answer1, answer2)