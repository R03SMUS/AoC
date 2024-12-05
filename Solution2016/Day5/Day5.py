import hashlib

text = "ffykfhsq"
n = 0

list = []

while len(list) != 8:
    encrypt = text + str(n)
    result = hashlib.md5(encrypt.encode())
    encrypted = result.hexdigest()
    if encrypted[:5] == "00000":
        list.append(encrypted[5:6])
    n += 1
print(list)

n = 0
total = 0
list = ["_", "_", "_", "_", "_", "_", "_", "_",]

while total != 8:
    encrypt = text + str(n)
    result = hashlib.md5(encrypt.encode())
    encrypted = result.hexdigest()
    if encrypted[:5] == "00000":
        pos = encrypted[5:6]
        char = encrypted[6:7]
        if pos.isdigit() and int(pos) < 8 and list[int(pos)] == "_":
            list[int(pos)] = char
            total += 1
    n += 1
print(list)
