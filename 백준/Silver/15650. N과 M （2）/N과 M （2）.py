n, m = map(int, input().split())
num = []

def dfs(now):
  if len(num) == m: # 숫자의 개수가 m개이면
    print(' '.join(map(str, num))) # 수열을 출력
    return

  for i in range(now, n+1): 
    if i not in num: # 리스트안에 i가 없다면
      num.append(i) # i를 추가해줌
      dfs(i+1) # 현재 숫자보다 큰 숫자만 탐색(작은 경우를 pruning)
      num.pop()
    
dfs(1)