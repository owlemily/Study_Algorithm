N = int(input())

lst = list(map(int, input().split()))

answer = 0 #소수 개수
#1357
for num in lst: #3
    count = 0 #소수가 아닌 지 판정 #따지고보면 약수의 개수인셈
    
    if num > 1:
        for i in range(2,num): #2
            if num % i == 0:#3%2
                count += 1 
            
        if count == 0:
            answer += 1
            
print(answer)
    