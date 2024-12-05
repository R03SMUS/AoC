file = open("input", "r")
data = file.read()
file.close()


def total_mult(inputlist):
    total = 1
    for tal in inputlist:
        total *= int(tal)
    return total


def decrement_length(inputlist, mult, amount):
    newlist = []
    newmult = []
    for index, tal in enumerate(inputlist):
        if tal - amount > 0:
            newlist.append(tal-amount)
            newmult.append(mult[index])
    return newlist, newmult

def decompress(s):
    c = list(s)
    n = []
    while len(c) != 0:
        if c[0] == "(":
            ns = ""
            c.pop(0)  # START "("
            x = int(c.pop(0))
            while c[0].isdigit():  # 1 Tal should continue until 'x' is found ::: hvor lang ud skal vi kigge
                x *= 10
                x += int(c.pop(0))
            c.pop(0)  # "x"
            y = int(c.pop(0))
            while c[0].isdigit():  # 1 Tal should continue until 'x' is found ::: hvor lang ud skal vi kigge
                y *= 10
                y += int(c.pop(0))  # 2 Tal should continue until ')' is found ::: hvor mange gange skal vi gentage
            c.pop(0)  # SLUT ")"
            for i in range(int(x)):
                ns += c.pop(0)

            for i in range(int(y)):
                n.append(ns)
        else:
            n.append(c.pop(0))
    return "".join(n)


l = decompress(data)
print(len(l))



part2 = data

length = []
mult = []
total = 0
i = 0



while i < len(part2):

    if part2[i] == "(":
        i+=1
        length, mult = decrement_length(length, mult, 1)

        x = int(part2[i])

        i+=1
        length, mult = decrement_length(length, mult, 1)

        while part2[i].isdigit():
            x *= 10
            x += int(part2[i])
            i += 1
            length, mult = decrement_length(length, mult, 1)

        i += 1
        length, mult = decrement_length(length, mult, 1)

        y = int(part2[i])
        i += 1
        length, mult = decrement_length(length, mult, 1)

        while part2[i].isdigit():
            y *= 10
            y += int(part2[i])
            i += 1
            length, mult = decrement_length(length, mult, 1)

        i += 1
        length, mult = decrement_length(length, mult, 1)

        length.append(x)
        mult.append(y)

    else:
        total += 1 * total_mult(mult)
        length, mult = decrement_length(length, mult, 1)
        i += 1
    #print(total, length, mult, i)

print(total)
