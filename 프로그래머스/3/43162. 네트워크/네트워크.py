def solution(n, computers):
    answer = 0
    visited = [0] * n
    def dfs(x):
        visited[x] = 1 #방문표시 # 2
        for i in range(n):
            if i == x: #0
                continue
            if visited[i] == 1: #이미 방문한경우
                continue
            if computers[x][i] == 1: #방문도 안했고 1이야
                dfs(i)
            if computers[x][i] == 0:
                continue
        return 1
                    
        
    for i in range(n):
        if visited[i] == 0:
            answer += dfs(i)
    return answer