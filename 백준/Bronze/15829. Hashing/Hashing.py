import sys
r = 31
M = 1234567891
input = sys.stdin.readline
l = int(input())
string = input()

sum = 0
for i in range (l):
    sum += (ord(string[i]) - 96) * pow(r, i)
    
print(sum % M)