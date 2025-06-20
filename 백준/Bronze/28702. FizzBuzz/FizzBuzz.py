answer = 0
for i in range(3):
    is_num = input()
    if is_num.isdigit():
        answer += int(is_num)+(3-i)
        break



if answer % 15 == 0:
    print("FizzBuzz")
elif answer % 3==0 and answer % 5 != 0:
    print("Fizz")
elif answer % 5 == 0 and answer % 3 != 0:
    print("Buzz")
else:
    print(answer)
