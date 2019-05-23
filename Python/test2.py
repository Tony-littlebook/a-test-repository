with open('F:/Python/julie.txt') as jaf:
    data = jaf.readline()
james = data.strip().split(',')
print(james)
print(sorted(james))