clesses = {}
palin = dict()
print(type(clesses))
print(type(palin))
clesses['Name'] = 'John Clesses'
clesses['Occupations'] = ['actor', 'comedian', 'writer', 'film producer']
palin = {'Name': 'Michael Palin', 'Occuption':['comedian', 'actor', 'writer', 'tv']}
print(palin['Occuption'])
palin['Birthplace'] = "Weston-super-Mare, North Somerset, English"
res = {'name': {'first': 'Bob', 'last':'Smith'}, 'job':['div', 'mgr'], 'age': 40.5}
print(res)
D = {'a': 1, 'b': 2, 'c': 3}
Ks = list(D.keys())
Ks.sort()
for key in Ks:
    print(key, '=>', D[key])
""""不会维持既有的顺序"""
print(palin)

"""class"""
def sanitize(time_string):
    if '-' in time_string:
        splitter = '-'
    elif ':' in time_string:
        splitter = ':'
    else:
        return(time_string)
    (mine, secs) = time_string.split(splitter)
    return(mine + '.' + secs) 

class Athlete:
    def _init_(self, a_namw, a_dob = None, a_time = []):
        self.name = a_namw
        self.dob = a_dob
        self.times = a_time
    def top3(self):
        return (sorted(set([sanitize(t) for t in self.times]))[0:3])
    def add_time(self, time_value):
        self.times.append(time_value)
    def add_times(self, list_of_times):
        self.times.extend(list_of_times)

def get_coach_data(filename):
    try:
        with open(filename) as f:
            data = f.readline()
        temp1 = data.strip().split(',')
        return (Athlete(temp1.pop(0), temp1.pop(0), temp1))
    except IOError as ioerr:
        print('File error:' + str(ioerr))
        return(None)
class NameList(list):
    def _init_(self, a_name):
        list._init_([])
        self.name = a_name
johnny = NameList("John Paul Jones")
print(dir(johnny))
johnny.append("Bass Player")
johnny.extend(["Composer", "Arranger", "Musician"])
print(johnny)
print(johnny.name)
