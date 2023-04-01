import csv


with open("TopUni.csv", "r") as uniList:
    reader = csv.reader(uniList)
    i = -1
    listUni = []
    setCountry = set()
    for row in (reader):
        if i != -1:
            listUni.append(row)
        i +=1

    for Uni in listUni:
        setCountry.add(Uni[2])
    displayAlpha = str(setCountry)
    print(displayAlpha.replace("'", "").replace("{", "").replace("}", ""))


with open("capitals.csv", "r") as listCapitals:
    readerC = csv.reader(listCapitals)
    listCapitals = []

    setCapitals = set()
    for capital in readerC:
        listCapitals.append(capital)
        if capital[5] != "Continent":
            setCapitals.add(capital[5])
        displayBeta = str(setCapitals)
    print(displayBeta.replace("'", "").replace("{", "").replace("}", ""))


def continentCheck(countryChoiceA):
    continentSelected = None
    for capital in listCapitals:
        if capital[0] == countryChoiceA:
            continentSelected = capital[5]
    return continentSelected


countryChoice = input("Specify a country name to display the corresponding information.: ")
listSelected = []

for row in listUni:
    if row[2] == countryChoice:
        listSelected.append(row)

choiceRank = str(listSelected[0][0])
choiceName = str(listSelected[0][1])

for row in listSelected:
    if row[3] == '1':
        choiceNameA = str(row[1])
        choiceRankA = str(row[3])

score = 0
numUni = 0
for row in listSelected:
    score += float(row[8])
    numUni += 1
score /= numUni

print(continentCheck(countryChoice))
for row in listUni:
    if continentCheck(row[2]) == continentCheck(countryChoice):
        contHigh = float(row[8])
        break

scoreB = (score/contHigh) * 100
for row in listCapitals:
    if row[0] == countryChoice:
        capital = row[1]

listCapitalUni = []
for row in listSelected:
    listUniWord = row[1].split(' ')
    for word in listUniWord:
        if word == capital:
            listCapitalUni.append(row[1])
displayGamma = str(listCapitalUni).replace("'", " ").replace("[", "").replace("]", "").replace('''"''', "")


with open("output.txt", 'w') as f:
    f.write("Total number of universities => " + str(i) + "\n")
    f.write("Available countries => " + displayAlpha.replace("'", "").replace("{", "").replace("}", "").upper() + "\n")
    f.write("Available continents => " + displayBeta.replace("'", "").replace("{", "").replace("}", "").upper() + "\n")
    f.write("At international rank => " + choiceRank + " the university name is => " + choiceName + "\n")
    f.write("At national rank => " + choiceRankA + " the university name is => " + choiceNameA + "\n")
    f.write("The average score => " + str(score) + "%" + "\n")
    f.write("The relative score in the continent " + continentCheck(countryChoice) + " is => " + str(scoreB) + "%" + "\n")
    f.write("The capital is  => " + capital + "\n")
    f.write("The capital containing universities are  => " + displayGamma + "\n")



