import sys
from collections import deque

T = int(sys.stdin.readline().strip())

for _ in range(T):
  ch = [False for _ in range(10001)]
  A, B = map(int, sys.stdin.readline().strip().split())
  
  Q = deque()
  Q.append([A, ''])
  ch[A] = True

  while Q:
    n, cmd = Q.popleft()
	
    # B(최종 값)과 A에 연산을 적용한 n과 동일하다면
    if n == B:
      # 적용한 연산들 출력 후 while문 종료
      print(cmd)
      break

    # D
    d = (n * 2) % 10000
    if not ch[d]:
      ch[d] = True
      Q.append([d, cmd + 'D'])

    # S
    s = (n - 1) % 10000
    if not ch[s]:
      ch[s] = True
      Q.append([s, cmd + 'S'])

    # L
    l = n//1000 + (n % 1000) * 10
    if not ch[l]:
      ch[l] = True
      Q.append([l, cmd + 'L'])

    # R
    r = n//10 + (n%10) * 1000
    if not ch[r]:
      ch[r] = True
      Q.append([r, cmd + 'R'])