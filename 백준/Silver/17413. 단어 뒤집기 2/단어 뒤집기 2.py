# stack에 넣고, " "를 만나면 stack을 pop해서 단어를 거꾸로 출력
from collections import deque
queue = deque()
S = input()
stack = []
answer = ""
i = 0
while(i < len(S)):
    if '<' == S[i]:
        answer += '<'
        i += 1
        while(True):
            if S[i] == '>':
                answer += '>'
                i+= 1
                break
            else:
                answer += S[i]
                i += 1
    elif S[i] == ' ':
        answer += ' '
        i += 1
    else:
        #스택에 단어 하나만 저장
        while i < len(S) and S[i] != ' ' and S[i] != '<':
            stack.append(S[i])
            i += 1
            
        while(stack): # 거꾸로 출력
            answer += stack.pop()

print(answer)
    