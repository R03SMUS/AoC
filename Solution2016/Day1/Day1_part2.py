file = open("C:\\Users\\pctos\\Desktop\\AoC\\Solution2016\\Day1\\input",'r')
data = file.read()
file.close()

# Part 1
x, y = 0, 0
listxy = {}

facing = 0

found = False

for i in data.split(", "):
    r = i[0]
    a = int(i[1:])
    if r == "R":
        facing = facing + 1
    else:
        facing = facing - 1
    n = facing % 4

    for j in range(a):
        if n == 0:
            x+=1
        elif n == 1:
            y+=1
        elif n == 2:
            x-=1
        elif n == 3:
            y-=1

        if x in listxy and y in listxy[x]:
            print(abs(x)+abs(y))
            found = True

        if x not in listxy:
            listxy[x] = []
        listxy[x].append(y)
    if found:
        break
