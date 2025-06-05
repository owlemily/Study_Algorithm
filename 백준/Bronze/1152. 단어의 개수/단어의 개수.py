'''
문장의 앞뒤에 공백으로 시작하거나 끝날 수 있기 때문에 공백을 없애주는 
'''

s = input().strip()
count = 0
if len(s) == 0:
    count = 0

else:
    for i in range(len(s)):
        if s[i] == " ":
            count += 1
    count += 1

print(count)