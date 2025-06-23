'''
1. 8x8로 잘라내는 경우의수
(M - 8) * (N - 8) 
2. 각 경우에서 다시 칠해야할 수 구하기
- (B로 시작하는 경우) or (w로 시작하는 경우) 칠해야할 칸 수가 다르다. 
- 칠해야할 칸 수가 더 적은 경우를 구해야한다..
1에서 자른 범위 내에서 몇개가 B로 칠해졌고, 몇개가 W로 칠해졌지?
3. min()값 구해서 출력하기 
'''
N, M = map(int, input().split())
board = []
answer = []

for i in range(N):
    board.append(input())

for i in range(N-7): #8x8 전체 틀 잡기
    for j in range(M-7): #8x8 전체 틀잡기
        draw1 = 0 #B로 시작하는 경우
        draw2 = 0 #W로 시작하는 경우
        for a in range(i, i+8): #틀 내에서 8칸 이동
            for b in range(j, j+8): #틀 내에서 8칸 이동
                if (a+b) %2 == 0 :
                    if board[a][b] != 'B':
                        draw1 += 1 #색깔 바꿔주기
                    if board[a][b] != 'W':
                        draw2 += 1 #색깔 바꿔주기
                else: #홀수칸일때는 B로 시작하면 홀수칸에는 W여야함
                    #W로 시작하면 홀수칸에는 B여야함
                    if board[a][b] != 'W':
                        draw1 += 1
                    if board[a][b] != 'B':
                        draw2 += 1
        # 8x8 틀 내에서 한번 칠해줬으면 결과값에 추가
        answer.append(draw1)
        answer.append(draw2)

print(min(answer))
                    


