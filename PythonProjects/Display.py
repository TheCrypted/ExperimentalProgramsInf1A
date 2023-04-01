import requests

url = "https://vehicle-damage-assessment.p.rapidapi.com/run"

payload = {
	"draw_result": False,
	"remove_background": False,
	"image": "https://jixjiastorage.blob.core.windows.net/public/sensor-ai/vehicle_damage/sample.jpg"
}
headers = {
	"content-type": "application/json",
	"X-RapidAPI-Key": "3fdab1549dmsh23dd5f556a66dd4p10a8e7jsn57e7822f9753",
	"X-RapidAPI-Host": "vehicle-damage-assessment.p.rapidapi.com"
}

response = requests.request("POST", url, json=payload, headers=headers)

print(response.text)
