'''
파이썬에는 swith-case 문이 없다. 
if와 elif, else를 사용해서 케이스를 구분할 수 있다.

주의) 당연히 입력을 word, n = input().split(" ") 이렇게 받도록 했는데
생각해보니 top, size, empty와 같은 명령어는 n이 없고 word만 있다..

if not stack: -> 이렇게 빈 배열을 표현.
'''
import sys
stack = []
input = lambda: sys.stdin.readline().strip()
N = int(input())
for i in range(N):
    parts = input().split(" ")
    word, *n = parts
    if word == "push":
        stack.append(n[0])
        continue
    elif word == "pop":
        if not stack:
            print(-1)
            continue
        else:
            print(stack.pop())
            continue
    elif word == "size":
        print(len(stack))
        continue
    elif word == "empty":
        if not stack:
            print(1)
            continue
        else:
            print(0)
            continue
    elif word == "top":
        if not stack:
            print(-1)
            continue
        else:
            print(stack[-1])
            continue