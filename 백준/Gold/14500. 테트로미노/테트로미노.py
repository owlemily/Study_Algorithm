N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

# dfs를 돌면서 4칸 탐색
visited = [[0]*M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def dfs(now, depth, num_sum):
    global answer
    if depth == 4:
        answer = max(answer, num_sum)
        return
    
    for i in range(4):
        nx = now[0] + dx[i] 
        ny = now[1] + dy[i]
        if nx < 0 or nx >=N or ny < 0 or ny >= M:
            continue
        if visited[nx][ny] == 0:   
            visited[nx][ny] = 1
            dfs((nx, ny), depth+1, graph[nx][ny] + num_sum)
            visited[nx][ny] = 0 #백트래킹

# dfs로는 ㅗ ㅜ ㅏ ㅓ 모양은 탐색할 수 없다. 
# 따라서 ㅗ 류를 탐색하는 함수를 따로 만들어야한다. 
def check_t(now):
    global answer
    center = graph[now[0]][now[1]]
    wings = [] #중심점에서 뻗어나가는 날개가 3개이상 있어야 ㅗ ㅓ ㅏ ㅜ 모양을 만들 수 있다. 

    for i in range(4):
        nx = now[0] + dx[i]
        ny = now[1] + dy[i]

        if 0<=nx<N and 0<=ny<M:
            wings.append(graph[nx][ny])
    if len(wings)<3: #center에서 다 탐색을 했는데 날개가 3개가 안되면 그 지점에서 ㅗ모양은 만들수가 없는거
        return 

    wings.sort(reverse=True) #가장 큰 날개3개 더해서 T모양 최대값 만들기
    num_sum = center + wings[0] + wings[1] + wings[2]
    answer = max(answer, num_sum)



answer = 0
for i in range(N):
    for j in range(M):
        visited[i][j] = 1
        dfs((i, j), 1, graph[i][j])
        visited[i][j] = 0

        # T모양탐색
        check_t((i,j))

print(answer)