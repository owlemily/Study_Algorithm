lst=list()
for i in range(9):
    x = int(input())
    lst.append(x)
answer = max(lst)
print(answer)
print(lst.index(answer) + 1)
