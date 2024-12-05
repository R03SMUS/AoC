file = open("C:\\Users\\pctos\\Desktop\\AoC\\Solution2016\\Day1\\input",'r')
data = file.read()
file.close()

# Part 1
x, y = 0, 0

facing = 0


for i in data.split(", "):
    r = i[0]
    a = int(i[1:])
    if r == "R":
        facing = facing + 1
    else:
        facing = facing - 1
    n = facing % 4
    if n == 0:
        x+=a
    elif n == 1:
        y+=a
    elif n == 2:
        x-=a
    elif n == 3:
        y-=a
print(abs(x)+abs(y))
