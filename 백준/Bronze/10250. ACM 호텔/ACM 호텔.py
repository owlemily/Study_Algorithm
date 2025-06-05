T = int(input())
for i in range(T):
    H, W, N = map(int, input().split())
    floor = N % H
    if floor == 0:
        floor = H
        room = int(N//H)
    else: 
        room = int(N//H) + 1
    if len(str(room)) == 1:
        room = "0"+ str(room)
    print(floor, end='')
    print(room, end='')
    print()