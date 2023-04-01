from timeit import default_timer as timer

start = timer()
######################################################################################################################
# Project Euler Project27

######################################################################################################################
# Project Euler Project26
# import math
#
#
# number = input("Enter spiral dimension: ")
# number = int(number)
#
# listDiagonal = [0]
# i = 1
# k = 4
# while listDiagonal[-1] != number**2:
#     listDiagonal.append(i)
#     i += 2 * math.floor(k/4)
#     k += 1
#
# listDiagonalTrim = listDiagonal[2:]
#
# sumA = 1
# sumB = 0
# for i in range(len(listDiagonalTrim)):
#     if i%2 == 0:
#         sumA += listDiagonalTrim[i]
#     else:
#         sumB += listDiagonalTrim[i]
#
#
# print(sumA+sumB)
#######################################################################################################################
# Project Euler Project25
# number = input("Enter number: ")
# number = int(number)
#
# def digitFinder(number):
#     strNum = str(number)
#     numbers = []
#     for i in strNum:
#         numbers.append(int(i))
#
#     return numbers
#
#
# def sumCalc(numbers, power):
#     sumA = 0
#     for i in digitFinder(numbers):
#         sumA += i ** power
#     return sumA
#
# final = []
# for i in range(2, 10000000):
#     if sumCalc(i, number) == i :
#         final.append(i)
#
# finalAlpha = 0
# for i in final:
#     finalAlpha += i
# print(finalAlpha)
#######################################################################################################################
# Project Euler Project24
# rangeEnter = input('Enter the number till which the sum of self powers must be computed: ')
# rangeEnter = int(rangeEnter)
#
# sumP = 0
# for i in range(rangeEnter):
#     sumP += (i+1) ** (i+1)
#
# print(str(sumP)[-10:])
#######################################################################################################################
# Project Euler Project23
# from itertools import permutations


# permutationInput = input("Enter numbers to find permutations for: ")
# permutationInputA = map(int, permutationInput.split())
# permutationInputB = []
# for i in permutationInputA:
#     permutationInputB.append(i)
# print(permutationInputB)
# l = list(permutations(permutationInputB))
#
#
# strA = []
# for i in l:
#     numA = '0'
#     for j in i:
#         numA = numA + str(j)
#     strA.append(numA[1:])
#
#
# intA = []
# for i in strA:
#     intA.append(int(i))
# intA.sort()
# print(intA[999999])
################################################################################################################
# Project Euler Project22
# with open('p022_names.txt') as f:
#     nameLine = f.readline()
#     nameLine = nameLine.split(",")
#     operableWords = []
#     for name in nameLine:
#         operableWords.append(name.strip('"'))
#     operableWords.sort()
#
#
# def scoreFinder(operableWords):
#     jA = 1
#     sumAlpha = 0
#     final = 0
#     for i in operableWords:
#         sumA = 0
#         for j in i:
#             sumA += listAlphaScore[j]
#         sumAlpha = jA * sumA
#         jA += 1
#         final += sumAlpha
#     return final
#
#
# listAlphaScore = dict()
# i = 1
# listAlpha = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
# listAlpha = listAlpha.split()
# for alpha in listAlpha:
#     listAlphaScore[alpha] = i
#     i += 1
#
# test = ['AARON', 'ABBEY']
# print(scoreFinder(operableWords))
#######################################################################################################################
# Project Euler Project21
# import math
#
#
# # dayReq = input('Enter the required date separated by a space: ')
# # dayReq = tuple(int(i) for i in dayReq.split(' '))
#
#
# def dayDif(day):
#     a = day[0]
#     day31 = [1, 3, 5, 7, 8, 10, 12]
#     day30 = [4, 6, 9, 11]
#     sumA = 0
#     for i in day31:
#         if i < day[1] != 1:
#             sumA += 31
#     for i in day30:
#         if i < day[1]:
#             sumA += 30
#     if 2 < day[1]:
#         sumA += 28
#     elif 2 == day[1]:
#         sumA = 31
#     elif 1 == day[1]:
#         sumA = 0
#     difYear = (day[2] - 1900) * 365
#     for i in range(1901, day[2]):
#         if i % 4 == 0:
#             difYear += 1
#     return a + sumA + difYear
#
#
# # print(dayDif(dayReq))
#
#
# def find_day(date):
#     listDays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"] * (math.ceil(dayDif(date) / 7))
#     for i in range(dayDif(date)):
#         a = (i+1, listDays[i])
#     return a
#
#
# def find_day_eff(date):
#     listDays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
#     b = listDays[dayDif(date) % 7]
#     return listDays[dayDif(date) % 7]
#
# listDays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
# print(listDays[(dayDif((7, 10, 1932)) % 7) -1 ])
# print("The day on this date is {}.".format(find_day((7, 10, 1932))[1]))

#######################################################################################################################
# Project Euler Project20
# Not exactly correct, but we roll with it...
# triangle = "75  " \
#            "95 64  " \
#            "17 47 82  " \
#            "18 35 87 10  " \
#            "20 04 82 47 65  " \
#            "19 01 23 75 03 34  " \
#            "88 02 77 73 07 63 67  " \
#            "99 65 04 28 06 16 70 92  " \
#            "41 41 26 56 83 40 80 70 33  " \
#            "41 48 72 33 47 32 37 16 94 29  " \
#            "53 71 44 65 25 43 91 52 97 51 14  " \
#            "70 11 33 28 77 73 17 78 39 68 17 57  " \
#            "91 71 52 38 17 14 91 43 58 50 27 29 48  " \
#            "63 66 04 68 89 53 67 30 73 16 69 87 40 31  " \
#            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
#
# triangle = triangle.split('  ')
# y = [i.split(' ') for i in triangle]
# sumA = 0
# choiceNum = 0
# for i in range(len(y)):
#     if i == 0:
#         sumA += int(y[i][0])
#         choiceNum = 0
#     elif i == 1:
#         if y[1][0] > y[1][1]:
#             sumA += int(y[1][0])
#             choiceNum = 0
#         elif y[1][1] < y[1][0]:
#             sumA += int(y[1][1])
#             choiceNum = 1
#     else:
#         if y[i][choiceNum] > y[i][choiceNum + 1]:
#             sumA += int(y[i][choiceNum])
#             choiceNum = choiceNum
#         elif y[i][choiceNum + 1] > y[i][choiceNum]:
#             sumA += int(y[i][choiceNum + 1])
#             choiceNum = choiceNum + 1
#
# print(sumA)

####################################################################################################################
# Project Euler Project19
# def DivPrin(numberLocal):
#     listDiv = [1]
#     for i in range(2, int(numberLocal / 2) + 1):
#         if numberLocal % i == 0:
#             listDiv.append(i)
#     return listDiv
#
#
# def sumNum(listNum):
#     sumA = 0
#     for i in listNum:
#         sumA += i
#     return sumA
#
# # Did not realize soon enough that this function wasn't required
# def isPrime(numberCheck):
#     till = 10000
#     listOp = [False] + [True]*till
#     for i in range(1, till):
#         if listOp[i] and i != 1:
#             for j in range(2, int(till/i)+1):
#                 listOp[i*j] = False
#     return listOp[numberCheck]
#
#
# a = (i for i in range(1, 10000) if i == sumNum(DivPrin(sumNum(DivPrin(i)))) and i != sumNum(DivPrin(i)))
#
# sumA = 0
# for i in a:
#     sumA += i
# print('The sum of all amicable number below 10000 is {}.'.format(sumA))
######################################################################################################################
# Project Euler Project18
# import math
#
# number = input('Enter the required number to be converted to word: ')
# number = int(number)
#
# num2words = {1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', 5: 'Five',
#              6: 'Six', 7: 'Seven', 8: 'Eight', 9: 'Nine', 10: 'Ten',
#              11: 'Eleven', 12: 'Twelve', 13: 'Thirteen', 14: 'Fourteen',
#              15: 'Fifteen', 16: 'Sixteen', 17: 'Seventeen', 18: 'Eighteen',
#              19: 'Nineteen', 20: 'Twenty', 30: 'Thirty', 40: 'Forty',
#              50: 'Fifty', 60: 'Sixty', 70: 'Seventy', 80: 'Eighty',
#              90: 'Ninety', 0: 'Zero'}
#
#
# def num2word(num):
#     if len([*str(num)]) == 1:
#         return num2words[num]
#     elif len([*str(num)]) == 2:
#         if num in range(10, 20) or num % 10 == 0:
#             return num2words[num]
#         else:
#             letterA = (math.floor(num / 10)) * 10
#             letterB = num - letterA
#             return num2words[letterA] + '' + num2words[letterB]
#     elif num % 100 == 0 and len([*str(num)]) == 3:
#         return num2words[num / 100] + 'hundred'
#     elif len([*str(num)]) == 3:
#         letterA = (math.floor(num / 100))
#         letterBC = num2word(num - letterA * 100)
#         return num2words[letterA] + 'hundredand' + letterBC.lower()
#     elif num == 1000:
#         return "OneThousand"
#
#
# sumNum = 0
# for i in range(0, number):
#     sumNum += len(num2word(i+1))
# print(sumNum)

#######################################################################################################################
# Project Euler Project18
# gridSize = input('Enter grid size: ')
# gridSize = int(gridSize)
#
# def genFib(number):
#     fibonacci = 1
#     fibonacciA = 0
#     fibon = 0
#     count = 0
#     while len([*str(fibon)]) != number:
#         count += 1
#         fibonacciA = fibonacci
#         fibonacci = fibon
#         fibon = fibonacci + fibonacciA
#     print(count)
#
# genFib(gridSize)
################################################################################################################
# Project Euler Project17
# import math
#
#
# gridSize = input('Enter grid size: ')
# gridSize = int(gridSize)
# totalNumberOfWays = math.factorial(gridSize*2)/((math.factorial(gridSize))**2)
# print('The total number of ways to cross the grid is {}.'.format(int(totalNumberOfWays)))
########################################################################################################################
# Project Euler Project16
# prod = 1
# for i in range(1, 101):
#     prod *= i
# prod = str(prod)
# prod = map(int, prod)
# sum = 0
# for i in prod:
#     sum += i
# print(sum)
######################################################################################################################
# Project Euler Project15
# from timeit import default_timer as timer
# start = timer()
#
# # number = input("Enter the number that you want the divisors to: ")
# # number = int(number)
#
#
# def genTrian(num):
#     return int (num * (num +1)/2)
#
# def genDivLen(num):
#     listFree = [1]
#     for i in range(2, num+1):
#         if num % i == 0:
#             listFree.append(i)
#     return len(listFree)
#
# test = 0
# lenMax = 0
# for i in range(12000, 13000):
#     test = genDivLen(genTrian(i))
#     if lenMax < test:
#         lenMax = test
#         print(lenMax)
#         if test > 500:
#             print(genTrian(i))
#
# # print(genDivLen(genTrian(number)))
#
#
# end = timer()
# print('The time taken for the given computation is {} seconds.'.format(end-start))
#####################################################################################################################
# Project Euler Project14
# annoyinglyLargeNum = (paste number here)
#
# annoyinglyLargeNum = annoyinglyLargeNum.split(' ')
# annoyinglyLargeNum = map(int, annoyinglyLargeNum)
# sum = 0
# for i in annoyinglyLargeNum:
#     sum += i
#
# print(sum)
####################################################################################################################
# Project Euler Project13
# def collatz(collatzList):
#     for i in collatzList:
#         if i == 1:
#             break
#         if i % 2 == 0:
#             collatzList.append(int(i / 2))
#         elif i % 2 != 0:
#             collatzList.append(int(3 * i + 1))
#     return len(collatzList)
#
# highCollLen = 0
# val = 0
# for i in range(100, 1000000):
#     if highCollLen < collatz([i]):
#         highCollLen = collatz([i])
#         val = i
#
# print("The value giving the largest sequence is {} which gives one of length {}.".format(val, highCollLen))


#######################################################################################################################
# Project Euler Project12
# powerStr = input("Enter the power of 2 that you wish to be used: ")
# power2 = int(powerStr)
#
# calcSol = 2**power2
# calcSolStr = str(calcSol)
# listr = map(int, [*calcSolStr])
# sumCal = 0
# for i in listr:
#     sumCal += i
# print(sumCal)
#######################################################################################################################
# Project Euler Project11
# from timeit import default_timer as timer
# start = timer()
#
#
# LongNum = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " \
#         "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " \
#         "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " \
#         "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " \
#         "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " \
#         "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " \
#         "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " \
#         "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " \
#         "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " \
#         "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " \
#         "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " \
#         "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " \
#         "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " \
#         "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " \
#         "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " \
#         "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " \
#         "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " \
#         "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " \
#         "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " \
#         "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"
#
#
# def maxProdRow(longNumber):
#     listNum = longNumber.split(' ')
#     listNum = map(int, listNum)
#     listNum = list(listNum)
#     prodRow = 0
#     for i in range(len(listNum)-3):
#         prod4 = listNum[i] * listNum[i+1] * listNum[i+2] * listNum[i+3]
#         if (i+1) % 19 != 0 and (i+2) % 19 != 0 and i % 19 != 0 and prodRow < prod4:
#             prodRow = prod4
#     return prodRow
#
#
# def maxProdColumn(longNumber):
#     listNum = longNumber.split(' ')
#     listNum = map(int, listNum)
#     listNum = list(listNum)
#     prodCol = 0
#     for i in range(len(listNum)-3):
#         # prod4 = listNum[i] * listNum[i+20] * listNum[i+40] * listNum[i+60]
#         if (i+60) < (len(listNum)-1) and prodCol < listNum[i] * listNum[i+19] * listNum[i+38] * listNum[i+57]:
#             prodCol = listNum[i] * listNum[i+19] * listNum[i+38] * listNum[i+57]
#     return prodCol
#
# def maxProdDiagonal(longNumber):
#     listNum = longNumber.split(' ')
#     listNum = map(int, listNum)
#     listNum = list(listNum)
#     prodCol = 0
#     for i in range(len(listNum) - 3):
#         # prod4 = listNum[i] * listNum[i+20] * listNum[i+40] * listNum[i+60]
#         if (i + 63) < (len(listNum) - 1) and prodCol < listNum[i] * listNum[i + 21] * listNum[i + 42] * listNum[i + 63]:
#             prodCol = listNum[i] * listNum[i + 21] * listNum[i + 42] * listNum[i + 63]
#     return prodCol
#
#
# print('The maximum product of 4 consecutive horizontal numbers is {}.'.format(maxProdRow(LongNum)))
# print('The maximum product of 4 consecutive vertical numbers is {}.'.format(maxProdColumn(LongNum)))
# print('The maximum product of 4 consecutive diagonal numbers is {}.'.format(maxProdDiagonal(LongNum)))
#
# end = timer()
# print('The time taken for the given computation is {} seconds.'.format(end-start))
######################################################################################################################
# Project Euler Sieve of Eratosthenes
# import math
#
#
# def SieveOEratosthenesPrimGen(primeTill):
#     BooList = [True] * primeTill
#
#     for i in range(0, primeTill):
#         if i == 0 or i == 1:
#             BooList[i] = False
#         if BooList[i]:
#             for j in range(2, math.ceil(primeTill / i)):
#                 BooList[i * j] = False
#
#     sumPrime = 0
#     listPrime = []
#     for k in range(1, int(primeTill)):
#         if BooList[k]:
#             listPrime = listPrime + [k]
#     return listPrime
#
# print(SieveOEratosthenesPrimGen(200))
#######################################################################################################################
# # Project Euler Project10🥳
# uppLim = input('Enter the upper limit of primes: ')
# Lim = int(uppLim)
#
# def isPrime(number):
#     for i in range(2, int(number**0.5) + 1):
#         if number%i == 0:
#             return False
#     return True
#
#
# genPrime = (i for i in range(Lim) if isPrime(i) and i != 1)
# sumPrime = 0
# for num in genPrime:
#     sumPrime += num
# print('The sum of primes till that value is {}.'.format(sumPrime))

#######################################################################################################################
# Project Euler Project9
# listLong = input("Enter the number to operate on: ")
# consNum = input("Enter the number of consecutives: ")
#
#
# def conToList(longnumber):
#     lonStr = str(longnumber)
#     listNum = [int(i) for i in lonStr]
#     return listNum
#
#
# listNum = conToList(listLong)
# multip = 0
# for i in range(len(listNum)):
#     if (len(listNum) >= i + 13) \
#             and (multip < listNum[i] * listNum[i + 1] * listNum[i + 2] * listNum[i + 3] * listNum[i+4]
#                 * listNum[i+5] * listNum[i+6] * listNum[i+7] * listNum[i+8] * listNum[i+9]
#                 * listNum[i+10] * listNum[i+11] * listNum[i+12]):
#         multip = listNum[i] * listNum[i + 1] * listNum[i + 2] * listNum[i + 3] * listNum[i+4] \
#                  * listNum[i+5] * listNum[i+6] * listNum[i+7] * listNum[i+8] * listNum[i+9] \
#                  * listNum[i+10] * listNum[i+11] * listNum[i+12]
#         print(listNum[i])

# for i in listNum:
#     for j in range(int(consNum)):
#         cow =

# print(multip)

########################################################################################################################
# Project Euler Project8
# list3 = [
#     [[(i, j, k) for i in range(1000) if ((i + j + k) == 1000) and (i ** 2 + j ** 2 == k ** 2)] for
#     j in range(1000)] for
#     k in range(1000)]
#
# for i in list3:
#     for j in i:
#         for k in j:
#             if len(k) != 0:
#                 print(k)
################################################################################################
# Project Euler Project7
# from numpy import number
#
# numberPr = input("Which prime number do you want: ")
# numberRe = int(numberPr)
#
#
# def isPrime(number):
#     for i in range(2, (int(number ** 0.5) + 1)):
#         if number % i == 0:
#             return False
#     return True
#
#
# genPrim = (i for i in range(999999) if isPrime(i))
# listPrim = []
#
# for i in genPrim:
#     if len(listPrim) <= numberRe + 1:
#         listPrim.append(i)
# print(listPrim[-1])


################################################################################################
# Project Euler Project6
# def isPalindrome(number):
#     numberA = str(number)
#     test = [*numberA]
#     test2 = test.copy()
#     test2.reverse()
#     if test == test2:
#         return True
#     else:
#         return False
#
#
# def max_list(list):
#     maxVal = list[0]
#     for i in list:
#         if i > maxVal:
#             maxVal = i
#     return maxVal
#
#
# palindromes = ([i * j for i in range(1000) if isPalindrome(i * j) and i >= 100] for j in range(1000) if j >= 100)
# maxx = 0
# for i in palindromes:
#     if len(i) != 0:
#         if max_list(i) > maxx:
#             maxx = max_list(i)
# print(maxx)

################################################################################################
# Project Euler Program5
# import sympy
# import math
#
#
# def is_prime(n):
#     for i in range(2, (int(n / 2) + 1)):
#         if (n % i) == 0:
#             return False
#     return True
#
#
# def isDiv(n, div):
#     if n % div == 0:
#         return True
#     elif div == 0:
#         return False
#     else:
#         return False
#
#
# given_numberA = input('Enter the number to calculate its greatest factor: ')
# given_number = int(given_numberA)
#
# primeList = (i for i in range(int(given_number / 2)+1) if is_prime(i) and i != 0)
# # for i in primeList:
# #     print(i)
#
# largestFactor = None
# for i in primeList:
#     if isDiv(given_number, i):
#         largestFactor = i
# print('The largest prime factor of the given number is {}.'.format(largestFactor))

################################################################################################
# Project Euler Program4
# import fractions
# import math
#
# from numpy import number
#
#
# def lcm(a, b):
#     return (a*b)/(math.gcd(int(a), b))
#
#
# numberIn = input('Enter Max Value: ')
# numberRe = int(numberIn)
#
# lcmTot = 1
#
# for i in range(numberRe):
#     lcmTot = lcm(lcmTot, (i+1))
#
# print(int(lcmTot))

#####################################
# Project Euler Program3
# rangeA = input('Select the amount of consecutive numbers to operate on: ')
# rangeInt = int(rangeA)
# sumSq = 0
# SqSum = 0
#
# for i in range(rangeInt):
#     sumSq = sumSq + (i+1)**2
# # print(sumSq)
#
# for i in range(rangeInt):
#     SqSum = SqSum + (i+1)
# # print(SqSum ** 2)
#
# print('The difference between the sum of the squared numbers and the square of the sums is {}.'.format((
# SqSum)**2-sumSq))
################################################################
# Project Euler Program2
# def listSum(list): sumA = 0 for a in range(len(list)): sumA = sumA + list[a] return sumA
#
#
# fibonacci = [1, 2]
# sumA = 0
# i = 0
#
# while fibonacci[i] + fibonacci[i + 1] < 4000000:
#     sumA = fibonacci[i] + fibonacci[i + 1]
#     fibonacci = fibonacci + [sumA]
#     i += 1
#
# fibonEven = [a for a in fibonacci if a % 2 == 0]
# print(fibonEven)
# print(listSum(fibonEven))

################################################################

# Project Euler Program1
# import random
#
#
# def div3(number):
#     if number % 3 == 0:
#         return True
#     else:
#         return False
#
#
# def div5(number):
#     if number % 5 == 0:
#         return True
#     else:
#         return False
#
#
# def listSum(list):
#     sumA = 0
#     for a in range(len(list)):
#         sumA = sumA + list[a]
#     return sumA
#
#
# varEntry = input("Enter range: ")
# var = int(varEntry)
# varList = [i for i in range(1, var) if div3(i) or div5(i)]
# print(varList)
# print(listSum(varList))

end = timer()
print('The time taken for the given computation is {} seconds.'.format(end - start))
