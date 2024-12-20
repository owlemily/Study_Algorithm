words = list()
N = int(input())

for i in range(N):
    word = input()
    words.append(word)
    
words = list(set(words)) #중복제거

words.sort() #사전순으로 정렬
words.sort(key=len) #길이 오름름차순

for i in words:
    print(i)