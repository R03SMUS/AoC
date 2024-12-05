import re
file = open("input", "r")
data = file.read()
file.close()

regex = "mul\([0-9]{1,3},[0-9]{1,3}\)"
def mult(m):
    total = 0
    for i in m:
        left = int(i.split(",")[0].strip("mul("))
        right = int(i.split(",")[1].strip(")"))
        total += right*left
    return total

 ### Part 1: 
print(mult(re.findall(regex,data)))

total = 0
do = True
for i in range(len(data)):
    if data[i] == "d":
        dos = re.findall("do\(\)", data[i:i+5])
        if len(dos) > 0:
            do = True
            continue
        donts = re.findall("don't\(\)", data[i:i+8])
        if len(donts) > 0:
            do = False
            continue
    if data[i] == "m":
        match = re.findall(regex, data[i:i+12])
        if len(match) > 0 and do:
            total += mult(match)
### Part 2:
print(total)
