data = [6, 3, 1, 2, 4, 5]
"""原地排序"""
data.sort()
print(data)
data = [6, 3, 1, 2, 4, 5]
data2 = sorted(data)
print(data2)
print(sorted(data))
print(data)

mins = [1, 2, 3]
secs = [m*60 for m in mins]
print(secs)

lower = ["i", "don't", "like", "spam"]
upper = [s.upper() for s in lower]
print(upper)

def sanitize(time_string):
    if '-' in time_string:
        splitter = '-'
    elif ':' in time_string:
        splitter = ':'
    else:
        return(time_string)
    (mine, secs) = time_string.split(splitter)
    return(mine + '.' + secs) 

dirty = ['2-22', '2:22', '2.22']
clean = [sanitize(t) for t in dirty]
print(clean)

def get_coach_data(filename):
    try:
        with open(filename) as f:
            data = f.readline()
        return(data.strip().split(','))
    except IOError as ioerr:
        print('File error:' + str(ioerr))
        return(None)

nums = [1, 1, 4, 5, 6, 4, 7]
setnums = set(nums)
print(setnums)