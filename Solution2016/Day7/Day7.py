file = open("input", "r")
data = file.read()
file.close()

total = 0

for i in data.split():
    reallist = []
    fakelist = []
    for j, l in enumerate(i.replace("[", "|").replace("]", "|").split("|")):
        if j % 2 == 0:
            reallist.append(l)
        else:
            fakelist.append(l)
    #fakelist
    fakebool = False
    realbool = False
    for j in fakelist:
        for l in range(len(j) - 3):
            if (j[l] == j[l + 3] and j[l + 1] == j[l + 2] and j[l] != j[l + 1]):
                fakebool = True
                break
    for j in reallist:
        for l in range(len(j) - 3):
            if (j[l] == j[l + 3] and j[l + 1] == j[l + 2] and j[l] != j[l + 1]):
                realbool = True
                break
    if realbool and not fakebool:
        total += 1
print(total)

total = 0
for i in data.split():
    abalist = []
    bablist = []
    aba = []


    for j, l in enumerate(i.replace("[", "|").replace("]", "|").split("|")):
        if j % 2 == 0:
            abalist.append(l)
        else:
            bablist.append(l)

    for j in abalist:
        for l in range(len(j) - 2):
            if (j[l] == j[l + 2] and j[l] != j[l+1]):
                aba.append(j[l] + j[l+1])
    found = False
    for j in bablist:
        for l in range(len(j) - 2):
            for a in aba:
                if j[l] == a[1] and j[l+2] == a[1] and j[l+1] == a[0]:
                    found = True
    if found:
        total += 1
print(total)







