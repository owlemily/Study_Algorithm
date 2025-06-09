'''
서로 다른 n개에서 순서에 상관없이 서로 다른 r개를 선택해야함.
'''
from itertools import combinations
N, M = map(int, input().split())
cards = list(map(int, input().split()))
selection = list(combinations(cards, 3)) #[(a, b, c), (d, e, f), ... ] 이런식으로 나온다.
answer = 0
for j in selection:
    temp = sum(j)
    if ((M-temp) <= (M-answer)) and (M-temp) >= 0 and (M-answer)>=0:
        answer = temp
    

print(answer)
    
