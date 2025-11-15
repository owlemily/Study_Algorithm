import heapq
N, M = map(int, input().split())
INF = 1e9
graph = [[INF]*(N+1) for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            graph[i][j] = 0
for _ in range(M):
    A, B = map(int, input().split())
    graph[A][B] = 1
    graph[B][A] = 1


for k in range(1, N+1): #거쳐가는 노드수
    for i in range(1, N+1): #출발
        for j in range(1, N+1): #도착
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

answer = []
for i in range(1, N+1):
    heapq.heappush(answer, (sum(graph[i]), i))

print(heapq.heappop(answer)[1])
    
