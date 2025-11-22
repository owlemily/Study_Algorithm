def solve(n, r, c):
    if n == 0:
        return 0

    half = 1 << (n - 1)          # 2^(n-1)
    area = half * half           # 한 사분면 칸 수

    # 사분면 결정
    if r < half and c < half:        # 0: 왼위
        return solve(n-1, r, c)
    elif r < half and c >= half:     # 1: 오른위
        return area + solve(n-1, r, c-half)
    elif r >= half and c < half:     # 2: 왼아래
        return 2*area + solve(n-1, r-half, c)
    else:                            # 3: 오른아래
        return 3*area + solve(n-1, r-half, c-half)

N, r, c = map(int, input().split())
print(solve(N, r, c))