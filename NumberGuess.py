import random as rd

Bool = False
randA = rd.randint(0, 10)
guessIn = input('Guess the number: ')
guess = int(guessIn)
score = 10
while not Bool:
    if guess == randA:
        print('You guessed the number correctly: {}. '.format(guess))
        Bool = True
        print('Your score was {} / 10'.format(score))
    elif guess != randA:
        # print ('Wrong guess: {}. '.format(guess))
        score -= 1
        if guess < randA:
            print ('Guess is lower than actual number. {}. '.format(guess))
            guessIn = input('Guess the number: ')
            guess = int(guessIn)
        elif guess > randA:
            print('Guess is higher than actual number. {}. '.format(guess))
            guessIn = input('Guess the number: ')
            guess = int(guessIn)
        Bool = False
