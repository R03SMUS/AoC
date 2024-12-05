file = open("input", "r")
data = file.read()
file.close()


commands = data.split("\n")
bots = dict()
output = dict()

def add_empty_bot(n):
    if n not in bots:
        bots[n] = []

done = 0


for i,str in enumerate(commands):
    if "value" in str:
        list = str.split()
        value = list[1]
        botn = list[5]
        add_empty_bot(botn)
        bots[botn].append(int(value))
        done += 1
    else:
        list = str.split()
        if list[0] == "bot":
            add_empty_bot(list[1])
        if list[5] == "bot":
            add_empty_bot(list[6])
        if list[10] == "bot":
            add_empty_bot(list[11])



while len(commands) != done:
    for i in commands:
        if "value" in i:
            continue
        command = i.split()
        n = command[1]
        low = command[6]
        high = command[11]
        if len(bots[n]) == 2:
            #print(command)

            lowvalue = min(bots[n][0], bots[n][1])
            maxvalue = max(bots[n][0], bots[n][1])


            if lowvalue == 17 and maxvalue == 61:
                print("part 1:", n)

            if command[5] == "bot":
                bots[low].append(lowvalue)
            else:
                output[low] = lowvalue

            if command[10] == "bot":
                bots[high].append(maxvalue)
            else:
                output[high] = maxvalue

            bots[n].clear()
            done += 1

print("part 2:",output['0']*output['1']*output['2'])