file = open("input", 'r')
data = file.read()
file.close()

total = 0

for i in list(map(lambda x: x.split(), list(map(lambda x: x.strip(), data.split("\n"))))):
    values = sorted([int(item) for item in i])
    if values[0] + values[1] > values[2]:
        total += 1
print(total)

list = [int(item) for item in data.split()]


total = 0
s = -1
for i in range(int(len(list) / 3)):
    if i % 3 == 0 and i != 0:
        s+=7
    else:
        s+=1
    m = max(list[s], max(list[s + 3], list[s + 6]))
    if list[s] + list[s+3] + list[s+6] - m > m:
        total += 1
print(total)





