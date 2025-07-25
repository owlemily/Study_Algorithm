'''
P_n은 I가 (n+1)개, O가 n개
'''

N = int(input())
M = int(input())
S = input()

#I에 "OI"를 몇 번 더했느냐
p_n = "I" 
p_n = p_n + ("OI")*N


count = 0

for i in range(len(S)-len(p_n)+1): #범위 실수
    if S[i:i+len(p_n)] == p_n:
        count += 1
        
print(count)

'''
S = IOI/O/I/OI
P_N = 1 = 3
'''
