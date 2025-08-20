import sys
import heapq

tc=int(sys.stdin.readline())

for _ in range(tc):
    n=int(sys.stdin.readline())

    isDeleted=[False]*n

    minHeap = [] # 최소 힙
    maxHeap = [] # 최대 힙

    for i in range(n): # 몇번째 과정인지의 i를 밑에서 key로 사용할 것임!

        cmd,target=sys.stdin.readline().rstrip().split()
        target=int(target)

        if cmd=='I': # 삽입
            # (value, key) 꼴로 넣는다
            heapq.heappush(minHeap,(target,i))
            heapq.heappush(maxHeap,(-target,i))
            
        else: # 삭제
            if target==1: # 최대값 삭제
                while maxHeap and isDeleted[maxHeap[0][1]]: # maxHeap이 비어있지 않고 최상단이 원래는 삭제된 놈이면,
                    heapq.heappop(maxHeap) # 실제로 maxHeap에서 그것을 삭제한다!
                    
                if maxHeap: # 위 과정을 다 하고도 maxHeap에 뭐가 있으면,
                    number,key=heapq.heappop(maxHeap) # 최상단을 삭제하고,
                    isDeleted[key]=True # 그 수가 삭제된 것임을 표시

            else: #최솟값 삭제
                while minHeap and isDeleted[minHeap[0][1]]: # minHeap이 비어있지 않고 최상단이 원래는 삭제된 놈이면,
                    heapq.heappop(minHeap) # 실제로 minHeap에서 그것을 삭제한다!

                if minHeap: # 위 과정을 다 하고도 minHeap에 뭐가 있으면,
                    number,key=heapq.heappop(minHeap) # 최상단을 삭제하고,
                    isDeleted[key] = True # 그 수가 삭제된 것임을 표시

                    
    # 모든 과정을 거치고 마무리로 다시 minHeap과 maxHeap의 간극 삭제
    while maxHeap and isDeleted[maxHeap[0][1]]:
        heapq.heappop(maxHeap)
    while minHeap and isDeleted[minHeap[0][1]]:
        heapq.heappop(minHeap)


    if not minHeap: # (minHeap과 maxHeap을 이루는 수는 같으므로 하나만 empty 존재 여부 확인해도 ok)
        print("EMPTY")
    else:
        print(-maxHeap[0][0],minHeap[0][0]) # (최대값, 최솟값) 출력