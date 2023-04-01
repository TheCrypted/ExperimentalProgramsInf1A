# We will import csv (Comma-Separated Value) to organize the large amounts of data.
import csv


def file_total(TopUni, Capitals):
    # This list will have all the information on each uni.
    # It is outside the try and except function since it needs to exist regardless of the error.
    entireList = []

    try:
        # Creating Lists so that all the required info asked can be
        # taken from the text files and stored in an empty list.
        listOfCapitals = []
        TopUniList = []
        uniList = []

        # Opening csv files and then proceeding to read them.
        # encoding="utf8" is added so the program can read special characters.
        capitalsFile = open(Capitals, "r", encoding="utf-8")
        # Using the reader function so the program can go through and read the text files.
        capitalsReader = csv.reader(capitalsFile)
        topUniFile = open(TopUni, "r", encoding="utf-8")
        topUniReader = csv.reader(topUniFile)

        # Creating a "for" loop to iterate over the contents of the container, like a string.
        for capitals in capitalsReader:
            # Appending the list of capitals that we get to the empty list.
            listOfCapitals.append(capitals)

        # Similarly creating another "for" loop in which we later on append
        # all the university information to another empty list.
        for unis in topUniReader:
            TopUniList.append(unis)

        # Now we have a nested loop in which we nest the lists together into entireList.
        # Creating a loop for every capital in each row.
        for capitalRow in listOfCapitals:
            # The loop now formed is for every row in TopUniList.
            for uniRow in TopUniList:
                # Having an if statement where, if the 2nd indexed element (capital) has a presence in the university
                # name, then it is added to the "uniList" list.
                if uniRow[2] == capitalRow[0]:
                    for uniElement in uniRow:
                        uniList.append(uniElement)
                    # Indexing from 1 to 6 and adding to a temporary list (interimList).
                    interimList = capitalRow[1:6]
                    # Now we are adding the capitals found into the uniList.
                    for capital_found in interimList:
                        uniList.append(capital_found)
                    entireList.append(uniList)
                    uniList = []
        # Calling the return function to get the entire list with the appended data.
        return entireList
    # Creating an except function where if the file wasn't found then the following statement would pop up.
    except FileNotFoundError:
        print("File not found.")
        quit()


# Creating a function that sorts the list by international ranking.
def int_rank(international_rank):
    # Returning the international rank which is at index 0.
    return int(international_rank[0])


# Creating a function that sorts the list by national ranking.
def nat_rank(national_rank):
    # Returning the national rank which is at index 3
    return int(national_rank[3])


def getInformation(selectedCountry, rankingFileName, capitalsFileName):
    listCountries = []
    listContinents = []
    listCountryUnis = []
    continentalScore = []
    capitalNameInUnis = []
    score = 0

    # Creating a list (terminalList) that contains the entire data from the given 2 parameters.
    terminalList = file_total(rankingFileName, capitalsFileName)

    finalOutput = open("output.txt", "w")

    # Creating a for loop which is further nested so that the countries and continents can be added to their
    # respected lists.
    for eachRow in terminalList:
        if eachRow[2] not in listCountries and eachRow[2] != "Country":
            listCountries.append(eachRow[2])
            listContinents.append(eachRow[13])
        if eachRow[2].upper() == selectedCountry.upper():
            listCountryUnis.append(eachRow)

    # The highest international rank uni is added to the "listCountryUnis" list.
    listCountryUnis.sort(key=int_rank)
    internationalRank1 = listCountryUnis[0][0]
    internationalRank1Name = listCountryUnis[0][1]
    # The highest national rank uni is added to the "listCountryUnis" list.
    listCountryUnis.sort(key=nat_rank)
    nationalTopRank1 = listCountryUnis[0][3]
    nationalTopRank1Name = listCountryUnis[0][1]

    # We take the score from the text file and use it to calculate the average score.
    for everyUni in listCountryUnis:
        score += float(everyUni[8])
    # The average score is calculated using the sum of all the scores of the universities and
    # dividing it with the number of universities in that country.
    scoreAverage = score / len(listCountryUnis)

    selectedContinent = listCountryUnis[0][13]
    for continent in terminalList:
        if continent[13] == selectedContinent:
            continentalScore.append(float(continent[8]))

    # The continent relative score is calculated using the average score divided by the highest score of the uni
    # in that specific continent.
    finalRelativeScore = (scoreAverage / max(continentalScore)) * 100
    finalRelativeScore = round(finalRelativeScore, 2)

    capital = listCountryUnis[0][9]
    capitalCaps = capital.upper()

    for x in listCountryUnis:
        if capital.lower() in x[1].lower():
            capitalNameInUnis.append(x)

    continentMax = max(continentalScore)

    # Inserting required text into output text file.
    finalOutput.write("Total number of universities => %d\n" % len(terminalList))
    finalOutput.write("Available countries => ")
    # Creating a loop to print all the countries.
    for everyCountry in listCountries:
        if everyCountry != listCountries[-1]:
            finalOutput.write(everyCountry + ", ")
        else:
            finalOutput.write(everyCountry)
    # Creating a loop to print all the continents.
    finalOutput.write("\nAvailable continents => ")
    for everyContinent in listContinents:
        finalOutput.write(everyContinent + ", ")
    # Writing more things into the output.txt.
    finalOutput.write("\nAt international rank => %s the university name is => %s" % (internationalRank1, internationalRank1Name))
    finalOutput.write("\nAt national rank => %s the university name is => %s" % (nationalTopRank1, nationalTopRank1Name))
    finalOutput.write("\nThe average score => %.2f" % scoreAverage)
    finalOutput.write("\nThe relative score to the top university in %s is => (%.2f/%.2f)" % (selectedContinent.upper(), scoreAverage, continentMax))
    # Here we concatenate the strings to get a single sentence.
    finalOutput.write(" x 100% = " + str(finalRelativeScore) + "")
    finalOutput.write("\nThe capital is => {}".format(capitalCaps))
    finalOutput.write("\nThe universities that contain the capital name => \n")
    counter = 1
    for i in capitalNameInUnis:
        finalOutput.write("        #%d %s\n" % (counter, i[1]))
        counter += 1
