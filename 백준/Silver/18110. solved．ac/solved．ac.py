'''
n의 범위의 양끝값에서 예외상황이 생길 수 있으니 주의해라.
'''
import sys
input = lambda: sys.stdin.readline().rstrip()
n = int(input())
scores = []
for i in range(n):
    num = int(input())
    scores.append(num)
scores.sort()
cutline = n * 0.15
def myround(cutline):
    if cutline - int(cutline) >= 0.5:
        return int(cutline) + 1
    else:
        return int(cutline)

cutline = myround(cutline)
trimmed = scores[cutline:n-cutline]
    
if (n-2*cutline) != 0:
    a = (sum(trimmed)/(n-2*cutline))
    print(myround(a))
else:
    print(0)