while(True):
    s = input()
    if s == '0':
        break
    # 길이가 홀수라면 -> 가운데수를 제외하고 앞뒤가 같으면됨.
    # 길이가 짝수라면 -> 절반씩 모두 같아야함.
    found = False
    for i in range(len(s)//2):
        if s[i] != s[len(s)-1-i]:
            print("no")
            found = True
            break

    if found == False:
        print("yes")    

            

            
