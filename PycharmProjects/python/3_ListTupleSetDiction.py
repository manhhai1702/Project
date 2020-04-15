# ================= LIST =====================

thislist = ["apple", "banana", "cherry"]
print(thislist)

thislist = ["apple", "banana", "cherry"]
print(thislist[1])#banana

thislist = ["apple", "banana", "cherry"]
print(thislist[-1]) #cherry

thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thislist[2:5]) #['cherry', 'orange', 'kiwi']
print(thislist[-5:-2])

thislist = ["apple", "banana", "cherry"]
thislist[1] = "blackcurrant"
print(thislist) #['apple', 'blackcurrant', 'cherry']

thislist.append('addnew')
print(thislist) #['apple', 'blackcurrant', 'cherry','addnew']

#gộp mảng
any_lst = ['one', 'two', 'three']
thislist.extend(any_lst)
print(thislist) #['apple', 'blackcurrant', 'cherry', 'addnew', 'one', 'two', 'three']
#sort or đảo ngược
lst = [4,3,5,2,7,5,2]

lst.sort() #=> [2, 2, 3, 4, 5, 5, 7]
lst.sort(reverse = True) #=> [7, 5, 5, 4, 3, 2, 2]

# ================= Tuples=====================
print("tuple =========================================")
thistuple = ("apple", "banana", "cherry")
print(thistuple[1]) #banana

thistuple = ("apple", "banana", "cherry")
print(thistuple[-1]) #cherry

thistuple = ("apple", "banana", "cherry", "orange", "kiwi", "melon", "mango")
print(thistuple[2:5]) #('cherry', 'orange', 'kiwi')

thistuple = ("apple", "banana", "cherry", "orange", "kiwi", "melon", "mango")
print(thistuple[-4:-1]) #('orange', 'kiwi', 'melon')

# chưa nhiều kiểu giá trị
tup = (2, "ABC", 7, 3, [4,3,7], True, 3)

# add
day1 = ('monday', 'tuesday', 'wednesday')
day2 = ('thursday', 'friday', 'saturday' , 'sunday')

day = day1 + day2 # ('monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday')


# ================= set=====================
print("set =========================================")

#add 1 item
thisset = {"apple", "banana", "cherry"}
thisset.add("orange")
print(thisset)

# add multi item
thisset.update(["orange", "mango", "grapes"])
print(thisset)
#remove last item
thisset = {"apple", "banana", "cherry"}
x = thisset.pop()
print(x)
print(thisset)
#$join 2 set
set1 = {"a", "b" , "c"}
set2 = {1, 2, 3}
set3 = set1.union(set2)
print(set3)

thisset = {"apple", "banana", "cherry"}

for x in thisset:
 print(x)


# ================= Dictionaries=====================
print("Dictionaries =========================================")

thisdict = { #giống object, map
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
print(thisdict)


#get value by key
x = thisdict["model"]
print(x)
x = thisdict.get("model")
print(x)

#change value
thisdict["year"] = 2018
print(thisdict["year"])
#get all value
print('all value==============================================')
for x in thisdict.values():
  print(x)
#get all key
print('all key==============================================')
for x in thisdict:
  print(x)

#get key & value
print('all key & value==============================================')
for x, y in thisdict.items():
  print(x, y)

#check key exists
if "model" in thisdict:
  print("Yes, 'model' is one of the keys in the thisdict dictionary")