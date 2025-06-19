'''
파이썬으로 방정식을 푸는거아닌가?
m은 0-9이니 for문으로 찾아주면 될듯.
*이 마지막일수도 있음
'''

s = input()
sum_weight = 0

for i in range(len(s)):
    if s[i] == "*":
            star_idx = i
            continue
    if i % 2 == 0 or i == 0:
        sum_weight += int(s[i]) * 1
    else: 
        sum_weight += int(s[i]) * 3
            
for i in range(10):
    if star_idx % 2== 0:
         temp = sum_weight + i * 1
    else:
         temp = sum_weight + i * 3

    if temp % 10 == 0:
         print(i)
         break



    
    
