import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()
V, E = map(int, input().split())
K = int(input()) #시작정점
INF = 1e9

graph = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    

distance = [INF] *(V+1)
distance[K] = 0 #시작점

def dijkstra(K):
    q = []
    heapq.heappush(q, (0, K)) #시작점을 넣어야지
    while q:
        w, now = heapq.heappop(q)
        #연결된 노드들 거리 갱신
        for i in graph[now]:
            cost = w + i[1]
            if distance[i[0]] < cost:
                continue
            if cost < distance[i[0]]:
                distance[i[0]] = cost #갱신
                heapq.heappush(q , (cost, i[0]))

dijkstra(K)
for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])


            
