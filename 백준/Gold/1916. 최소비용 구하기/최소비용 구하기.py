import heapq
N = int(input())
M = int(input())
INF = 1e9
graph = [[] for _ in range(N+1)]

for _ in range(M):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

start, end = map(int, input().split())
distance = [INF]*(N+1)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    while q:
        weight, now = heapq.heappop(q) 

        if weight > distance[now]: #이미 방문한 곳
            continue
        #현재 노드와 인접한 노드 살피기
        for i in graph[now]:
            #인접노드에서의 비용 
            cost = weight + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost #갱신
                heapq.heappush(q, (cost,i[0]))

dijkstra(start)
print(distance[end])

            

