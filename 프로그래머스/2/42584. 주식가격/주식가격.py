from collections import deque
def solution(prices):
    deq = deque(prices)
    answer = []
    while deq:
        seq = 0
        p = deq.popleft()
        #print("p:", p)
        for q in deq:
            #print("q:", q)
            if q >= p:
                seq += 1
                #print(seq)
            else:
                seq += 1
                #print(seq)
                break
        answer.append(seq)
        #print(answer)
    return answer