def solution(n):
    answer = [[0] * n for _ in range(n)]
    dir = 'r'
    x = 0 
    y = 0
    if n == 1:
        return [[1]]
    for i in range(n*n):
        answer[x][y] = i+1
        if dir =='r':
            y = y+1
            if y == n-1 or answer[x][y+1] != 0:
                dir = 'd'
        elif dir == 'd':
            x = x+1
            if x == n-1 or answer[x+1][y] != 0:
                dir = 'l'
        elif dir == 'l':
            y = y-1
            if y == 0 or answer[x][y-1] != 0:
                dir = 'u'
        elif dir == 'u':
            x = x-1
            if x == 0 or answer[x-1][y] != 0:
                dir = 'r'           
        
    return answer