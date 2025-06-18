K = int(input())
stack = []
for i in range(K):
    n = int(input())
    if n != 0:
        stack.append(n)
    else:
        stack.pop()
    
print(sum(stack))
    