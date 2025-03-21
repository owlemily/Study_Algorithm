from collections import deque
def solution(numbers, target):
    answer = 0
    queue = deque()
    n = len(numbers)
    queue.append([numbers[0], 0]) #원소, 그래프의 깊이
    queue.append([-1*numbers[0], 0])
    while queue:
        node, index = queue.popleft()
        index += 1
        if index < n:
            queue.append([node+numbers[index], index])
            queue.append([node-numbers[index], index])
        else: #index가 numbers 길이와 같아지면
            if node == target:
                answer += 1
    return answer