import requests
import sys
from datetime import date
from timeit import default_timer as timer

start = timer()

def getMatchesFromDate(date):
    url = f"https://cricket-live-data.p.rapidapi.com/fixtures-by-date/{date}"
    headers = {
        "X-RapidAPI-Key": "83b2390b4bmsh2f41ace782b0feap1455fdjsn45effac7b22f",
        "X-RapidAPI-Host": "cricket-live-data.p.rapidapi.com"
    }

    response = requests.request("GET", url, headers=headers)

    data = response.json()
    return data

def getMatchScore(match_id):
    url = f"https://cricket-live-data.p.rapidapi.com/match/{match_id}"
    headers = {
        "X-RapidAPI-Key": "83b2390b4bmsh2f41ace782b0feap1455fdjsn45effac7b22f",
        "X-RapidAPI-Host": "cricket-live-data.p.rapidapi.com"
    }
    response = requests.request("GET", url, headers=headers)
    data = response.json()
    return data


if len(sys.argv) == 2:
    command = sys.argv[1]
    if command == 'date':
        dayRequest = input('Enter relevant date to obtain list of matches (format: YYYY-MM-DD) : ')
        print('The matches for the given day are as follows: \n')
        data = getMatchesFromDate(dayRequest)
        print(data)
        for i in range(len(data['results'])):
            print(data['results'][i]['match_title'] + '\n')

    elif command == 'score':
        dataMatches = getMatchesFromDate(date.today())
        for i in range(len(dataMatches['results'])):
            dataMatch = getMatchScore(dataMatches['results'][i]['id'])
            if dataMatch['results']['live_details'] is None:
                print(f"Match: {dataMatch['results']['fixture']['match_title']}")
                print('Match data unavailable.')
            elif dataMatch['results']['live_details'] is not None and dataMatch['results']['live_details']['match_summary']['result'] == 'Yes':
                print(f"Match: {dataMatch['results']['fixture']['match_title']}")
                print(f"Match result: {dataMatch['results']['live_details']['match_summary']['status']}")
                print(f"Toss result: {dataMatch['results']['live_details']['match_summary']['toss']}" + '\n')
            elif dataMatch['results']['live_details']['match_summary']['result'] == 'No':
                print(f"Match: {dataMatch['results']['fixture']['match_title']}")
                print("Match has not started/concluded." + '\n')

else:
    print("please pass one command")

end = timer()
print('The time taken for the given computation is {} seconds.'.format(end - start))