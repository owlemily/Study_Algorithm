'''
>, > 이면 더 윗 순위 부여. 
만약, >, < 이거나 <, >이면 등수를 올리지 않음.
'''
#전체 사람 수
N = int(input())
ls = [] #(몸무게, 키) 리스트 
answer = [1] * N

for i in range(N):
    a = tuple(map(int, input().split()))
    ls.append(a)

#완전탐색
for i in range(len(ls)):
    for j in range(len(ls)):
        if i == j:
            continue
        if((ls[i][0]<ls[j][0] and ls[i][1]<ls[j][1])):
            answer[i] += 1
        

for i in answer:
    print(i, end=" ")






