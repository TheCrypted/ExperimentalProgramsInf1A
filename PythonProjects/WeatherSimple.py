import requests

API_KEY = 'c65caccc99b9f953bb1916fd904618df'
API_URL = 'http://api.openweathermap.org/data/2.5/weather'

city_id = input('Enter city to retrieve weather information for: ')
weather_request = f'{API_URL}?appid={API_KEY}&q={city_id}'
response = requests.get(weather_request)

if response.status_code == 200:
    data = response.json()
    print('Weather forecast: ')
    print('__________________________________')
    print(f"Average Temperature: {round(data['main']['temp']-273)}*C")
    print(f"Wind speed: {data['wind']['speed']}mph")
    print(f"Weather description: {data['weather'][0]['description']}" )
else:
    print('Error: %s' % response.status_code)