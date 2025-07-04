def solution(chicken):
    answer = 0
    remain = 0
    while(chicken>=10):
        answer += chicken // 10 #108 # 118 #119 
        remain += chicken % 10 # 1 #1+8 
        print(remain)
        chicken = chicken // 10 #108//10=10
        print(chicken)
        
    #remain = remain + chicken
    
    remain += chicken
    
    if remain >=10:
        answer += remain // 10
        remain = (remain % 10) + (remain // 10)
        if remain >= 10:
            answer += remain // 10
    
            
    return answer