import json

# 对数据编码 json.dumps()：python -> JSON
def testdumps():
    data = {
        'no': 1,
        'name': 'Zth',
        'age': 21
    }
    json_str = json.dumps(data)
    print("Python 原始数据：", repr(data))
    print("JSON 对象：", json_str)
    return json_str


#  对数据解码 json.loads(): JSON -> python
def testloads(json_str):
    python_data = json.loads(json_str)
    print("转换后的Python数据: ", python_data)
    print("python_data['name']: ", python_data['name'])
    print("python_data['age']: ", python_data['age'])

# 调用
json_str = testdumps()
testloads(json_str)