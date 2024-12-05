class node:

    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.is_open = True if len(
            str(bin((x * x) + (3 * x) + (2 * x * y) + (y) + (y * y) + 1350))[2:].replace("0", "")) % 2 == 0 else False
        self.neighbors = []

    def __str__(self):
        return str(self.x) + " " + str(self.y) + " " + str(self.is_open)


def func(x, y, magic):
    return (x * x) + (3 * x) + (2 * x * y) + (y) + (y * y) + magic


print(node(1,1).is_open)
n = node(1,0)




for i in range(10):
    for j in range(10):
        print("." if len(str(bin(func(j, i, n)))[2:].replace("0", "")) % 2 == 0 else "#", end="")
    print()
