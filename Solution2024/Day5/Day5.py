file = open("input", "r")
data = file.read()
file.close()

instructions = data.split()

before = dict()
page = list()

for i in instructions:
    if "," in i:
        page.append(list(i.split(",")))
        continue
    xy = i.split("|")
    if xy[0] not in before:
        before[xy[0]] = []
    before[xy[0]].append(xy[1])

print(before)
print(page)

res = 0
res2 = 0

def get_notallowed(i):
    notallowed = []
    for j in i:
        if j in before:
            for k in before[j]:
                notallowed.append(k)
    return notallowed

def check_page(i, notallowed):
    for tal in i:
        if tal in notallowed:
            return False
        if tal in before:
            remove = before[tal]
            for r in remove:
                if r in notallowed:
                    notallowed.pop(notallowed.index(r))
    return int(i[int(len(i)/2)])

def part2(i, notallowed):
    newlist = []

    while len(i) > 0:
        for j in i:
            if j in notallowed:
                continue
            newlist.append(i.pop(i.index(j)))
            if j in before:
                remove = before[j]
                for r in remove:
                    if r in notallowed:
                        notallowed.pop(notallowed.index(r))
    return int(newlist[int(len(newlist)/2)])

for i in page:
    n = check_page(i, get_notallowed(i))
    if not n:
        res2 += part2(i, get_notallowed(i))
    else:
        res += n
print(res)
print(res2)