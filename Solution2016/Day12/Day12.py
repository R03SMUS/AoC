import time

file = open("input", "r")
data = file.read()
file.close()

reg = {"a":0,"b":0,"c":0,"d":0}

command = data.split("\n")

i = 0
while i < len(command):
    commands = command[i].split()
    #print(i, commands, reg)
    if commands[0] == "cpy":
        if commands[1].isdigit():
            reg[commands[2]] = int(commands[1])
        else:
            reg[commands[2]] = int(reg[commands[1]])
        i += 1
    elif commands[0] == "inc":
        reg[commands[1]] += 1
        i += 1
    elif commands[0] == "dec":
        reg[commands[1]] -= 1
        i += 1
    elif commands[0] == "jnz":
        b = 0
        if commands[1].isdigit():
            b = int(commands[1])
        else:
            b = reg[commands[1]]
        if b != 0:
            i += int(commands[2])
        else:
            i += 1


print(reg["a"])

reg = {"a":0,"b":0,"c":1,"d":0}

command = data.split("\n")

i = 0
while i < len(command):
    commands = command[i].split()
    #print(i, commands, reg)
    if commands[0] == "cpy":
        if commands[1].isdigit():
            reg[commands[2]] = int(commands[1])
        else:
            reg[commands[2]] = int(reg[commands[1]])
        i += 1
    elif commands[0] == "inc":
        reg[commands[1]] += 1
        i += 1
    elif commands[0] == "dec":
        reg[commands[1]] -= 1
        i += 1
    elif commands[0] == "jnz":
        b = 0
        if commands[1].isdigit():
            b = int(commands[1])
        else:
            b = reg[commands[1]]
        if b != 0:
            i += int(commands[2])
        else:
            i += 1

print(reg["a"])