file = open("input", 'r')
data = file.read()
file.close()
columns = []
for i in data.split()[0]:
    columns.append(dict())
for i in data.split():
    for index, char in enumerate(i):
        if i[int(index):int(index)+1] not in columns[int(index)]:
            columns[int(index)][i[int(index):int(index)+1]] = 0
        columns[int(index)][i[int(index):int(index)+1]] = columns[int(index)][i[int(index):int(index)+1]] + 1
for i in columns:
    print(sorted(i.items(), key=lambda item: item[1], reverse=True)[0][0], end="")
print()
for i in columns:
    print(sorted(i.items(), key=lambda item: item[1], reverse=False)[0][0], end="")







