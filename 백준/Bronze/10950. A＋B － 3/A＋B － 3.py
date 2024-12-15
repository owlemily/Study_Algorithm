T = int(input())
result = list()
for i in range(T):
    A, B = map(int, input().split())
    result.append(A+B)
    
for i in range(len(result)):
    print(result[i])