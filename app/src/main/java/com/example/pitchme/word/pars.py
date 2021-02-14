fichier = open('source', 'r')

sortie = open('sortie', 'w')

def strip(s, start=None, end=None):
    if not start and not end:
        return s
     
    result = ''
    flag = False
    oneOnTwo = True
    for c in s:
        if c == start:
            oneOnTwo = not(oneOnTwo)
            if (oneOnTwo):
                result += "\" "
            flag = True
        elif c == end:
            oneOnTwo = not(oneOnTwo)
            if (oneOnTwo):
                result += "\", "
            flag = False
        elif flag:
            result += c 
    return result

for ligne in fichier:
    sortie.write(strip(ligne, '[', ']'))


