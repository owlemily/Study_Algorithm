'''
N번째 수를 구하는 것인데 
N번 반복해서 N번쨰 수를 찾아내면 된다. 
N번을 어떻게 반복할까? N수를 1씩 줄여가며 반복해도 된다.
N은 10,000 이하의 수이기 때문에 하나씩 반복문을 돌려도 시간초과가 안난다.
'''
N = int(input())
num = 666

while N !=0:
    if "666" in str(num):
        N -= 1
    num += 1

print(num - 1) # 위의 반복문에서 num이 항상 1 더해지도록 했으니.
        