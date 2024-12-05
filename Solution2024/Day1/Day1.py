file = open("input", "r")
data = file.read()
file.close()

rlist = []
llist = []

total = 0

for i in data.split("\n"):
    j = i.split()
    rlist.append(int(j[0]))
    llist.append(int(j[1]))
zipped = zip(sorted(rlist), sorted(llist))
for i, j in zipped:
    total += (j - i)
print(total)

total = 0
ldict = {}
for i in llist:
    if i in ldict:
        ldict[i] += 1
    else:
        ldict[i] = 1
for i in rlist:
    if i in ldict:
        total += i*ldict[i]
print(total)

