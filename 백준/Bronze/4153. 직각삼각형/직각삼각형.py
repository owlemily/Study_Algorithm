a, b, c = sorted(list(map(int, input().split())))
answer = list()
while(a != 0 and b !=0 and c !=0):
    if(a **2 + b**2 != c**2):
        answer.append("wrong")
    else:
        answer.append("right")
    a, b, c = sorted(list(map(int, input().split())))
    
for i in answer:
    print(i)