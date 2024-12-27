S = set()
import sys
input = sys.stdin.readline
M = int(input())
#answer = list()
              
def add_all():
    for i in range(1, 21):
        S.add(i)
    set(S)
    return S

for i in range(M):
    instruct = input()
    if instruct.strip() == "all":
        add_all()
    elif instruct.strip() == "empty":
        S = set()
    else:
        calc, num = instruct.split()
        num = int(num)
        if calc == "add":
            S.add(num)
        elif calc == "remove":
            S.discard(num)
        elif calc == "check":
            if S & {num}: #교집합 연산은 집합 객체를 반환한다. 비어있지 않다면 True
                #answer.append(1)
                print(1)
            else: 
                #answer.append(0)
                print(0)
        elif calc == "toggle":
            if S & {num}:
                S.discard(num)
            else:
                S.add(num)
        
        
#for i in answer:
#    print(i)