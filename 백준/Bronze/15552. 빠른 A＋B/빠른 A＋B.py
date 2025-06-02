import sys
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for i in range(T):
    A, B = map(int, input().split())
    print(A + B)