from Flight import *
from Airport import *
# from timeit import default_timer as timer
# start = timer()

allAirports = []
allFlights = {}
listFlights = []


def refine(word):
    test = ''.join(letter for letter in word.split() if letter != ' ')
    return test


def listFlight(origin, listTuple):
    listFlightsLocal = []
    for flight in listTuple:
        if origin == flight.getOrigin():
            listFlightsLocal.append(flight)
    return listFlightsLocal


def loadData(airportFile, flightFile):
    try:
        with open(airportFile, 'r') as f:
            a = [refine(line) for line in f.readlines()]
        b = [tuple(line.split(',')) for line in a]

        for (code, country, city) in b:
            allAirports.append(Airport(code, city, country))

        with open(flightFile, 'r') as g:
            p = [refine(line) for line in g.readlines()]
        q = [tuple(line.split(',')) for line in p]

        # print(q)

        for (flightNo, origin, destination) in q:
            # print(flightNo, origin, destination)
            listFlights.append(Flight(flightNo, origin, destination))

        for flights in range(len(listFlights)):
            allFlights[listFlights[flights].getOrigin()] = listFlight(listFlights[flights].getOrigin(), listFlights)
        return True

    except OSError:
        return False


def getAirportByCode(code):
    for i in allAirports:
        if i.getCode() == code:
            return i
    return -1


def findAllCityFlights(city):
    listRel = []
    for i in allAirports:
        if i.getCity() == city:
            a = i.getCode()
    for i in listFlights:
        if i.getOrigin() == a or i.getDestination() == a:
            listRel.append(i)
    return listRel


def findAllCountryFlights(country):
    listRel = []
    a = []
    for i in allAirports:
        if i.getCountry() == country:
            a.append(i.getCode())
    for j in a:
        for i in listFlights:
            if i.getDestination() == j or i.getOrigin() == j:
                listRel.append(i)
    return listRel


def findFlightBetween(origAirport, destAirport):
    p = findAllCityFlights(origAirport.getCity())
    q = findAllCityFlights(destAirport.getCity())
    l = set()
    iAlpha = []
    for i in p:
        if i in q and i.getOrigin() == origAirport.getCode():
            return 'Direct Flight: {0} to {1}'.format(i.getOrigin(), i.getDestination())
    for i in p:
        if i.getDestination() in [j.getOrigin() for j in q]:
            for jAlpha in q:
                if i.getDestination() == jAlpha.getOrigin():
                    l.add(jAlpha.getOrigin())
                    iAlpha.append(i)
    if len(l) != 0:
        return l
    else:
        return -1


def findReturnFlight(firstFlight):
    l = getAirportByCode(firstFlight.getDestination())
    a = findAllCityFlights(l.getCity())
    for flight in a:
        if flight.getDestination() == firstFlight.getOrigin():
            return flight
    return -1

# end = timer()
# print('The time taken for the given computation is {} seconds.'.format(end - start))
