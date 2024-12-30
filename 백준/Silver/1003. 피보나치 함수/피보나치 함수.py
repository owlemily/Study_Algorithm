import sys
input = sys.stdin.readline

T = int(input())
memo = dict()
memo[0] = (1, 0)
memo[1] = (0, 1)
def fibonacci(n):
    if n not in memo:
        prev1 = fibonacci(n-2)
        prev2 = fibonacci(n-1)
        memo[n] = tuple(a + b for a, b in zip(prev1, prev2))
    return memo[n]
answer = list()
for i in range(T):
    N = int(input())
    answer.append(fibonacci(N))
    
for a, b in answer:
    print(a, b)