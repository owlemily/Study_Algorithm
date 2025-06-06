remains = []
count = 0
for i in range(10):
    num = int(input())
    r = num % 42
    if r not in remains:
        remains.append(r)
        count += 1

print(count)