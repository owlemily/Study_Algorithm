'''
while 반복문으로 접근할 수 있지만, 이는 마지막 테스트케이스에서 10억번을 반복하는 시간초과 문제가 발생한다.
'''
import math
A, B, V = map(int, input().split())

# (V - A)만큼을 다 올라가야한다. 위에서부터 A만큼을 일단 뺴놓고 생각하는 것이 어려웠다.
answer = math.ceil(((V-A) / (A-B))) + 1

print(answer)