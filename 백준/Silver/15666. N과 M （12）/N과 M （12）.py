N, M = map(int, input().split())
numList = [int(x) for x in input().split()]

numList = sorted(list(set(numList))) # 중복 제거후 정렬
n = len(numList)
answer = list()
seq = []

def dfs(num, depth):
    if depth == M:
        print(" ".join(map(str, seq)))
        return

    for i in range(numList.index(num), n):
        seq.append(numList[i])
        dfs(numList[i], depth + 1)
        seq.pop()

dfs(numList[0], 0)