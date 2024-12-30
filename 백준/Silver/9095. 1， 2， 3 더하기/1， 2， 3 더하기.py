import sys
input = sys.stdin.readline

T = int(input())
memo = dict()
memo[1] = 1
memo[2] = 2
memo[3] = 4
def counting(n):
    if n not in memo:
        prev3 = counting(n-3)
        prev1 = counting(n-2)
        prev2 = counting(n-1)
        memo[n] = prev1 + prev2 + prev3
    return memo[n]
answer = list()
for i in range(T):
    N = int(input())
    answer.append(counting(N))
    
for i in answer:
    print(i)