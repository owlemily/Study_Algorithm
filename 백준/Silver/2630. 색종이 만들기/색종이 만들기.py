import sys
input = lambda: sys.stdin.readline().rstrip()
N = int(input())
paper = []
for i in range(N):
    paper.append(list(map(int, input().split())))

result = [0, 0] #흰색, 파란색 개수 저장
def div(y, x, n):
    color = paper[y][x]
    for i in range(y, y+n):
        for j in range(x, x+n):
            if color != paper[i][j]: #찾는 과정에서 색이 달라지면
                m = n//2
                div(y, x, m) #색종이 분할(2사분면)
                div(y, x+m, m) #색종이 분할(1사분면)
                div(y+m, x, m) #색종이 분할(3사분면)
                div(y+m, x+m, m) #색종이 분할(4사분면)
                return
    if color == 0:
        result[0] += 1

    else:
        result[1] += 1

div(0, 0, N)
print(result[0])
print(result[1])            
    