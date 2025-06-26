M, N = map(int, input().split())

for i in range(M, N+1):
    if i == 1:
        continue #1은 소수가 아니므로 계속 진행
    for j in range(2, int(i**0.5)+1): 
    # 2부터 i까지 즉 특정 수 이전까지의 모든 숫자중에서 약수가 있는지를 보면 시간초과가 난다. 
    # 에라토스테네스의 체 : 소수 판별 알고리즘 N보다 작거나 같은 모든 소수를 효율적으로 구하는 방법
    # 에라토스테네스의 체 원리를 이용하면 속도가 매우 빠르다.
        if i % j == 0:
            break
    else:
        print(i)
    
        



    
