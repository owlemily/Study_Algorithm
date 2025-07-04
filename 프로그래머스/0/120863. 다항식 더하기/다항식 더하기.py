def solution(polynomial):
    nums = polynomial.split()
    print(nums)
    a = 0
    x = []
    
    for i in nums:
        if 'x' in i:
            x.append(i)
            nums.remove(i)
        elif '+' in i:
            nums.remove(i)
        else:
            a += int(i)
            nums.remove(i)
    print(x)    
    for i in range(len(x)):
        x[i] = x[i][:-1]
        if x[i] == '':
            x[i] = '1'
    print(x)
    x_sum = 0
    for i in range(len(x)):
        x_sum += int(x[i])
    answer = ''
    
    if x_sum == 1:
        answer += 'x'
    elif x_sum == 0:
        answer += ''
    else:
        answer += str(x_sum) + 'x'
    
    if a == 0:
        print(answer)

    else:
        if answer == '':
            answer += str(a)
        else:
            answer += ' ' + '+' + ' ' + str(a)
    
    return answer