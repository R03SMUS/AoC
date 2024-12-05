file = open("input", "r")
data = file.read()
file.close()

def print_floors(floor):
    for i, s in enumerate(reversed(floor)):
        print("F"+str(len(floor) - i), s)

floors = []

print_floors(floors)

for i in data.split("\n"):
    print(i.split())