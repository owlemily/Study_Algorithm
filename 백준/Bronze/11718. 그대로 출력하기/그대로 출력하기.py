'''
input() (built-in)은 EOF에서 EOFError를 발생시키지만, sys.stdin.readline()은 예외가 아니라 빈 문자열을 반환하므로 try-except는 작동하지 않음.
그냥 except를 하면 EOF에 도달해도 빈문자열 ''를 반환할 뿐, Exception을 발생시키지 않는다. 
'''
import sys
input = sys.stdin.readline
while True:
    s = input().rstrip()
    print(s)
    if not s:
        break