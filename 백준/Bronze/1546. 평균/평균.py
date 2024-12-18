N = int(input())
scores = list(map(int, input().split()))
M = max(scores)
new = list()
for num in scores:
    new.append(num/M * 100)

sum = 0    
for i in new:
    sum += i
    
print(sum/N)
    