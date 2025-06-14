N = int(input())
fac = 1
for i in range(1, N+1):
    fac *= i
fac = str(fac)
count = 0
for j in range(len(fac)-1, -1, -1):
    if fac[j] != '0':
        break
    if fac[j] == '0':
        count += 1
        continue
print(count)
