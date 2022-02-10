# 점프 투 파이썬 연습 문제 풀이

# Q1 "a:b:c:d를 "a#b#c#d"로 바꾸기
Q1 = "a:b:c:d"
print(Q1.replace(":", "#"))

# Q2 딕셔너리 "C" 값에 70이 들어가게 수정
Q2 = {'A' : 90, 'B' : 80}
Q2['C'] = 70
print(Q2['C'])

#Q3 리스트에 + 와 extend의 차이점을 설명해라
"""
+는 문자열을 새로운 메모리 주소에 저장하고 교체한다.(메모리 주소가 바뀜)
extend 는 새로운 메모리 주소에 저장하지 않고 기존에 리스트에 값을 변경해서 사용한다.(메모리 주소가 바뀌지 않음)
"""
# Q4 리스트의 50점 이상의 점수의 총합을 구하여라
A = [20, 55, 67, 82, 45, 33, 90, 87, 100, 25]
Q4 = 0
for x in A:
    if x >= 50:
        Q4 += x
print(Q4)

# Q5 피보나치 수열: 정수 n을 받았을 때, n 이하까지의 피보나치 수열 값
n = int(input("Q5 피보나치 수열 n을 입력하세요: "))
nums = []
for i in range(0, n):
    if i == 0:
        nums.append(0)
    elif i == 1:
        nums.append(1)
    else:
        nums.append(nums[i - 2] + nums[i - 1])
print("결과:",nums)

# Q6 숫자의 총합구하기 : 사용자로부터 숫자들을 입력 받아 총합을 하라 구분자는 콤마(,)로 한다.
n = input("Q6 숫자의 총합을 구할 연속된 숫자를 입력하세요. 구분자는 콤마(,): ").split(',')
sum = 0
for i in n:
    sum += int(i)
print(sum)

# Q7 한 줄 구구단: 사용자의 입력을 받아서 한 줄로 구구단을 출력하세요 (2 ~ 9)
n = int(input("구구단을 출력할 숫자를 입력하세요(2 ~ 9): "))
if n > 9 or n < 2:
    print ("잘못된 숫자")
else:
    for i in range(1, 10):
        print(i * n, end = ' ')