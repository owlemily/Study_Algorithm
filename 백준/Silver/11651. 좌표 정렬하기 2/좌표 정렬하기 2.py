N = int(input())
ls = []
for i in range(N):
    xy = tuple(map(int, input().split()))
    ls.append(xy)

ls.sort(key=lambda x:(x[1], x[0]))

for j in ls:
    print(j[0], j[1])
