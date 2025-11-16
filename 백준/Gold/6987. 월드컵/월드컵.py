def dfs(idx): #idx에서 몇번째 경기를 처리중인지
    global possible

    #이미 가능한 경우를 찾았다면 
    if possible:
        return #끝내기
    
    #15경기를 다 처리했다면?
    if idx == 15:
        for i in range(6):
            if win[i] != 0 or draw[i] != 0 or lose[i] != 0:
                return #그냥 False가 됨
        possible = True
        return
    
    a, b = matches[idx]
    #1) a가 이기고 b가 지는 경우
    if win[a] > 0 and lose[b] > 0:
        win[a] -= 1
        lose[b] -= 1
        dfs(idx + 1)
        win[a] += 1 #되돌리기(백트래킹)
        lose[b] += 1

    #2) 무승부인 경우
    if draw[a]>0 and draw[b]>0:
        draw[a] -= 1
        draw[b] -= 1
        dfs(idx + 1)
        draw[a] += 1
        draw[b] += 1

    #3) a가 지고 b가 이기는 경우
    if lose[a] > 0 and win[b] > 0:
        lose[a] -= 1
        win[b] -=1
        dfs(idx + 1)
        lose[a] += 1
        win[b] += 1

matches = []
for i in range(6):
    for j in range(i+1, 6):
        matches.append((i, j))
for i in range(4):
    possible = False
    # 팀별 승, 무, 패 저장
    win = [0] * 6
    draw = [0] * 6
    lose = [0] * 6

    data = list(map(int, input().split()))
    for i in range(6): #3개씩 6번으로 팀 기록을 저장
        win[i] = data[3 * i]
        draw[i] = data[3*i + 1]
        lose[i] = data[3*i + 2]
        
    dfs(0)
    if possible:
        print(1, end =" ")
    else:
        print(0, end = " ")