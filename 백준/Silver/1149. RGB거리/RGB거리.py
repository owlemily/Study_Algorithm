# 비용을 그래프로 본다면 계속 대각선으로 이동하면 되지않을까
# 다이나믹 프로그래밍?
'''
N = int(input())
cost = []
for _ in range(N):
    cost.append(list(map(int, input().split())))
#print(cost)

least_cost = [0]*(N)
now_index = 0
for i in range(N):
    if i == 0:
        least_cost[i] = min(cost[0])
        now_index = cost[0].index(min(cost[0]))
    else:
        min_cost = 10**8
        next_now_index = 0
        for j in range(3):
            
            if now_index == j:
                continue
            if j == 0:
                min_cost = cost[i][j]
                next_now_index = j
            else:
                if min_cost > cost[i][j]:
                    min_cost = cost[i][j]
                    next_now_index = j

        least_cost[i] = least_cost[i-1] + min_cost
        now_index = next_now_index
print(least_cost[-1])
            
'''   

N = int(input())
cost = []
for _ in range(N):
    cost.append(list(map(int, input().split())))

dp = [[0]* 3 for _ in range(N)]

dp[0][0], dp[0][1], dp[0][2] = cost[0][0], cost[0][1], cost[0][2]
for i in range(1, N):
    dp[i][0] = min(dp[i-1][1] + cost[i][0], dp[i-1][2] + cost[i][0])
    dp[i][1] = min(dp[i-1][0] + cost[i][1], dp[i-1][2] + cost[i][1])
    dp[i][2] = min(dp[i-1][0] + cost[i][2], dp[i-1][1] + cost[i][2])

print(min(dp[N-1]))


