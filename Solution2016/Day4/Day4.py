file = open("input", 'r')
data = file.read()
file.close()

total = 0



d = data.split()

for i in d:
    mostCommonNumbers = {}


    codes = i.split("-")

    for i in range(len(codes)-1):
        for j in codes[i]:
            if j not in mostCommonNumbers:
                mostCommonNumbers[j] = 1
            else:
                mostCommonNumbers[j] += 1
    mostCommonNumbers = dict(sorted(mostCommonNumbers.items(), key=lambda item: (-item[1], item[0])))
    l = list(mostCommonNumbers.keys())[:5]

    o = codes[len(codes) - 1].split("[")
    n = int(o[0])
    mm = l[0] + l[1] + l[2] + l[3] + l[4]
    m = o[1].strip("]")
    #print(mm,m)
    if mm == m:
        total += n
print(total)







