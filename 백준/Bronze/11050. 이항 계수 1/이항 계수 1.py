import math
N, K = map(int, input().split())
answer = math.factorial(N) / (math.factorial(K) * math.factorial(N-K))

print(int(answer))