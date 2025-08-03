#import math
import sys
input = lambda: sys.stdin.readline().rstrip()
n = int(input())
dp = [0] *(n+1)
dp[1] = 1

for i in range(2, n+1):
    min_calc = 50000
    for j in range(1, int(i**(1/2) + 1)):
        min_calc = min(min_calc, dp[i-j*j])
        #print(min_calc)
    dp[i] = min_calc + 1

    
print(dp[n])