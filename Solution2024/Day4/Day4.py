file = open("input", "r")
data = file.read()
file.close()

grid = data.split()

def check(x, y):
    total = 0

    for i in {-1,0,1}:
        for j in {-1, 0, 1}:
            total += is_XMAS(x, y, i, j)
    return total

def is_XMAS(x, y, xval, yval):
    try:
        if grid[x + xval][y + yval] == "M" and grid[x + (xval * 2)][y + (yval * 2)] == "A" and grid[x + (xval * 3)][y + (yval * 3)] == "S" and (x + (xval*3) >= 0 and y + (yval*3) >= 0):
            return 1
    except:
        pass
    return 0

def check2(x,y):

    if x <= 0 or x == len(grid)-1 or y <= 0 or y == len(grid[x])-1:
        return 0
    l = [grid[x - 1][y - 1], grid[x - 1][y + 1], grid[x + 1][y - 1], grid[x + 1][y + 1]]
    if "X" in l or "A" in l:
        return 0

    if l[1] == l[2]:
        return 0

    if l.count("M") != 2 and l.count("S") != 2:
        return 0

    return 1

# ↖ ↑ ↗
# ← X →
# ↙ ↓ ↘

res = 0
res2 = 0

for i in range(len(grid)):
    for j in range(len(grid[i])):
        if grid[i][j] == "X":
            res += check(i, j)
        if grid[i][j] == "A":
            res2 += check2(i, j)
print(res)
print(res2)
