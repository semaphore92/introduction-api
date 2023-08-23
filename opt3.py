import requests
import json

API_URL = "https://api.openai.com/v1/engines/davinci/completions"
HEADERS = {
    "Authorization": f"Bearer {YOUR_API_KEY}",
    "Content-Type": "application/json",
    "User-Agent": "OpenAI Python"
}

data = {
    "prompt": "Translate the following English text to French: 'Hello, how are you?'",
    "max_tokens": 50
}

response = requests.post(API_URL, headers=HEADERS, data=json.dumps(data))
response_data = response.json()

print(response_data['choices'][0]['text'].strip())