file = open("input", 'r')
data = file.read()
file.close()

total = 0



d = data.split()

for i in d:
    code = i.split("-")[:-1]
    shift = int(i.split("-")[len(i.split("-")) - 1].split("[")[0])
    string = ""
    for s in code:
        for k in s:
            t = (shift % 26 + ord(k) - 97) % 26
            string += chr(t+97)
        string += " "
    if string == "northpole object storage ":
        print(string, shift)









