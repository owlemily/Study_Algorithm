N = int(input())
found = False
for i in range(N):
    sum = 0
    M = str(i)
    for j in range(len(M)):
        sum += int(M[j])
    if N == int(M) + sum:
        found = True
        print(M)
        break
    
if found == False:
    print(0)
