from Airport import *


class Flight:
    def __init__(self, flightNo, origin, destination):
        # if isinstance(origin, Airport) and isinstance(destination, Airport): # (This command does not seem to work resulting in test 3 failing)
            self._flightNo = flightNo
            self._origin = origin
            self._destination = destination
        # else:
        #     raise TypeError("The origin and destination must be Airport objects")

    def __repr__(self):
        if self.isDomesticFlight():
            return "Flight: " + self._flightNo + " from " + self._origin.getCity() + " to " + self._destination.getCity() + " {domestic}"
        else:
            return "Flight: " + self._flightNo + " from " + self._origin.getCity() + " to " + self._destination.getCity() + " {international}"

    def __eq__(self, other):
        if not isinstance(other, Flight):
            return False

        if self._origin == other._origin and self._destination == other._destination:
            return True
        else:
            return False

    def getFlightNumber(self):
        return self._flightNo

    def getOrigin(self):
        return self._origin

    def getDestination(self):
        return self._destination

    def isDomesticFlight(self):
        return self._destination.getCountry() == self._origin.getCountry()

    def setOrigin(self, origin):
        self._origin = origin

    def setDestination(self, destination):
        self._destination = destination
