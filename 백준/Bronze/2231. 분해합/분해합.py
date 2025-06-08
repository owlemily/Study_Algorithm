N = int(input())
found = False

for i in range(max(1, N - 9 * len(str(N))), N):  # 탐색 범위 최적화 포함
    digit_sum = sum(int(d) for d in str(i))
    if i + digit_sum == N:
        print(i)
        found = True
        break

if not found:
    print(0)
