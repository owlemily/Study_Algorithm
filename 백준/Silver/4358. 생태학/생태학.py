import sys

input = sys.stdin.readline
trees = {} #나무종류와 개수를 저장
sum_trees = 0 #전체 비율 계산할 때 필요

while True:
    line = input().strip()#입력에서 한줄을 읽어들이고 공백제거후 text에 저장
    if not line: #빈문자열은 False -> not text는 True #빈문자열이면 반복문 종료
        break;
    if line in trees:
        trees[line] += 1
    else:
        trees[line] = 1
    sum_trees += 1 #전체 단어 개수 하나 추가
sorted_tree = sorted(trees.keys()) #오름차순으로 단어 정렬
for t in sorted_tree:
    print("%s %.4f" %(t, (trees[t] / sum_trees)*100))

    