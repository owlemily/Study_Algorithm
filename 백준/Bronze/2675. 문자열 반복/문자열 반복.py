T = int(input())

answer = ""
for i in range(T):
    R, S = input().split()
    R = int(R)
    for j in range(len(S)):
        for k in range(R):
            answer = answer + S[j]
    
    print(answer)
    answer = ""
