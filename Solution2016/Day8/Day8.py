import time


def display_grid(grid):
    for i in grid:
        print(i)


file = open("input", "r")
data = file.read()
file.close()


grid = []

total = 0
MAX_WIDTH = 50  # 50
MAX_HEIGHT = 6  # 6

# build grid
for i in range(MAX_HEIGHT):
    grid.append(list())
    for j in range(MAX_WIDTH):
        grid[i].append(".")

for i in data.split("\n"):
    if "rect" in i:
        x, y = i.split(" ")[1].split("x")[0], i.split(" ")[1].split("x")[1]
        for j in range(int(y)):
            for l in range(int(x)):
                grid[j][l] = "#"
    elif "row" in i:
        x, y = int(i.split(" ")[2].split("=")[1]), int(i.split(" ")[4])
        for _ in range(y):
            grid[x].insert(0, grid[x].pop())
    elif "column" in i:
        x, y = int(i.split(" ")[2].split("=")[1]), int(i.split(" ")[4])
        newlist = []
        for line in grid:
            newlist.append(line[x])
        for index, line in enumerate(grid):
            line[x] = newlist[(index-y)%MAX_HEIGHT]

total = 0
for i in grid:
    total += i.count("#")
print(total)
display_grid(grid)
