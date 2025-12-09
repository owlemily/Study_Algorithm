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


parent = [0] * (N + 1)   # parent[i] = i의 부모
visited = [False] * (N + 1)

def dfs(node):
    visited[node] = True
    for nxt in graph[node]:
        if not visited[nxt]:
            parent[nxt] = node      # 여기서 부모 기록!
            dfs(nxt)

dfs(1)  # 루트를 1번이라고 가정

# 이제 parent[x] 가 x의 부모 노드 번호
for i in range(2, N + 1):
    print(parent[i])