'''
스택의 pop과 queue의 pop 리스트에서의 동작순서를 헷갈리지말자
'''
from collections import deque
N = int(input())
deque = deque()
#제일 윗쪽 카드를 버리고, 그다음 카드를 맨 밑에 넣는거니까 큐 / 먼저 넣은 것을 먼저 빼니까.
for i in range(1, N+1):
    deque.append(i)

while(True):
    #print(deque)
    if len(deque) == 1:
        print(deque[0])
        break
    deque.popleft()
    #print(deque)
    if len(deque) == 1:
        print(deque[0])
        break
    deque.append(deque.popleft())
    #print(deque)

