'''
- len()함수는 내장함수, 정수이기때문에 반복문을 쓸 때 range()안에 써주기
'''
s = input()
for i in range(len(s)):
    if s[i].isupper():
        print(s[i].lower(), end='')
    else: 
        print(s[i].upper(), end='')