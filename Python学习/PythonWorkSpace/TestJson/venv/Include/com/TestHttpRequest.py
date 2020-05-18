import requests
import json

# get举例
ret = requests.get('http://localhost:8080/comment/2')
print(ret.url)
print(ret.text)

# post举例
data = {
    "petId": 2,
    "costContent": "testpost",
    "costValue": 50.0
}
response = requests.post("http://localhost:8080/cost", data=json.dumps(data), headers={'content-type': "application/json"})
print(response.text)