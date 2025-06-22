n = int(input())
stack = []
answer = []
flag = True
a = 1 # 스택에 넣는 순서는 무조건 1부터 n까지다. 1부터 순서대로 하나씩 올라가는 숫자가 있어야함
for i in range(n):
    num = int(input())
    while(num >= a):
        stack.append(a)
        answer.append('+')
        a += 1
    if stack[-1] == num:
        stack.pop()
        answer.append('-')
    else:
        print("NO")
        flag = False
        break

if flag == True:
    for i in answer:
        print(i)

