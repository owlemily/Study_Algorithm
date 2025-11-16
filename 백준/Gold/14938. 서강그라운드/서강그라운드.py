n, m, r = map(int, input().split())
item = [0] * (n+1)
temp_ls = list(map(int, input().split()))
for i in range(1, n+1):
    item[i] = temp_ls[i-1]

INF = 1e9
graph = [[INF] * (n+1) for _ in range(n+1)]
for _ in range(r):
    a, b, l = map(int, input().split())
    #if graph[a][b] > l:
    graph[a][b] = l
    graph[b][a] = l

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            graph[i][j] = 0

for k in range(1, n+1): #거쳐가는
    for i in range(1, n+1): #출발
        for j in range(1, n+1): #도착
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
item_sum = 0
for i in range(1, n+1): #출발
    total_item = 0
    for j in range(1, n+1): #도착
        if graph[i][j] <= m: #수색범위 안 #시작점도포함
            total_item += item[j]
    item_sum = max(item_sum, total_item)

print(item_sum)