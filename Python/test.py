movies = ["The Holy Grail", 1975, "The Life of Brian", 1979, 
"The Meaning of Life", 1983]
print(movies)

count = 0
while count  < len(movies):
      print(movies[count])
      count = count + 1

for each_flick in movies:
      print(each_flick)

movies.extend(["Graham Chapman", 
                  ["Michael Palin", "Jhon Cleese", "Terry Gilliam","Eric Idle", "Terry Jones"]])

for each_item in movies:
      if isinstance(each_item, list):
            for nested_item in each_item:
                if isinstance(nested_item, list):
                    for deeper_item in nested_item:
                        print(deeper_item)
                else:
                    print(nested_item)
      else:
            print(each_item)

def print_lol(the_list):
    """这个函数获取一个位置参数，名为"the_list"，这可以是任何Python
    列表（也可以是包含嵌套列表的列表）。所指定的列表中的每一个数据项会
    （递归地）输出到屏幕上，各数据项各占一片"""
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item)
        else:
            print(each_item)

print_lol(movies)