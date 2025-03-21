def solution(participant, completion):
    answer = ''
    players = dict()
    complete = dict()
    for i in participant:
        players[i] = 0
        complete[i] = 0
    #print(players, complete)
    
    for i in participant:
        players[i] += 1
    #print(players)
    for i in completion:
        complete[i] += 1
    #print(complete)
    for i in players:
        if players[i] != complete[i]:
            answer += i
            break
    
    return answer
