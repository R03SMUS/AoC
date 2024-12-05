file = open("input", "r")
data = file.read()
file.close()

def check(items):
    prev = None
    safe = True
    increase = int(items[0]) < int(items[1])
    for i in items:
        if prev is not None:
            difference = prev - int(i)
            if not ((0 < difference <= 3 and not increase) or (-3 <= difference < 0 and increase)):
                safe = False
                break
        prev = int(i)
    return 1 if safe else 0

def check_two(items):
    safe = False
    for i in range(len(items)):
        new = items.copy()
        new.pop(i)
        if check(new) == 1:
            safe = True
    return 1 if safe else 0

total = 0
total2 = 0

for i in data.split("\n"):
    items = i.split()
    total += check(items)
    total2 += check_two(items)
print(total)
print(total2)



