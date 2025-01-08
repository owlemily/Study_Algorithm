a, b = map(int, input().split())
cnt = 1

while b != a:
    if b%10 == 1:
        b = int(b/10)
        cnt += 1
        
    elif b%2 == 0 and b!=0:
        b = int(b/2)
        cnt += 1
    else:
        cnt = -1
        break
        
print(cnt)