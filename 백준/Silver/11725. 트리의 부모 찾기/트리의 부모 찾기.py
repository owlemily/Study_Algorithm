import sys
input = lambda:sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**8)

N = int(input())

graph = [[] for _ in range(N+1)]

# 트리 만들기
for _ in range(N-1):
    u, v = map(int, input().split())
    graph[v].append(u)
    graph[u].append(v)

visited = [0] * (N+1)
parents = [0] * (N+1)
parents[1] = 1
def dfs(node):
    visited[node] = 1 #방문표시
    for i in graph[node]:
        if visited[i] == 0: #방문하지 않았다면
            parents[i] = node #부모로 지정
            dfs(i)

dfs(1)

for i in range(2, N+1):
    print(parents[i])
    
            



