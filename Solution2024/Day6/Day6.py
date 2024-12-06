file = open("input", "r")
data = file.read()
file.close()


def print_grid(grid):
    for i in grid:
        print(i)


grid = data.split()
visitedgrid = [list(s) for s in grid]

x = 0
y = 0

facing = [[-1, 0], [0,1], [1,0], [0,-1]]
fn = 0

for i in range(len(grid)):
    if "^" in grid[i]:
        y = grid[i].index("^")
        x = i;
        break

while 0 < x < len(grid) and 0 < y < len(grid[0]):

    visitedgrid[x][y] = "X"
    try:
        if visitedgrid[x + facing[fn][0]][y + facing[fn][1]] == "#":
            fn = (fn + 1) % 4
    except:
        break
    x += facing[fn][0]
    y += facing[fn][1]
#print_grid(visitedgrid)

res = 0

for i in visitedgrid:
    res += i.count("X")
print(res)

print_grid(grid)