a = " HelloWorld!54321"
print(a)
print("get  character 1===================")
print(a[1])

print("get range character===================")
print(a[2:7])
print("get  character -1===================")
print(a[-1])
print("get range character -2 to -5 ===================")
print(a[-5:-2])

print("get lenght ===================")
print(len(a))

print("remote space = trim()===================")
print(a.strip())

print("lowcase ===================")
print(a.lower()) #   helloworld!54321
print(a.upper()) #   HELLOWORLD!54321

print(a.replace("H", "J"))

print(a.split("!")) # returns ['HelloWorld', '54321']


print("check 12345 in string")
x = "12345" in a
print(x) #true


d = "Hello"
b = "World"
c = d +"asfhoih"+ b
print(c)


print("string + number")
age = 36
txt = "My name is John, and I am {} "
print(txt.format(age))


quantity = 3
itemno = 567
price = 49.95
myorder = "I want {} pieces of item {} for {} dollars."
print(myorder.format(quantity, itemno, price))


quantity = 3
itemno = 567
price = 49.95
myorder = "I want to pay {2} dollars for {0} pieces of item {1}."
print(myorder.format(quantity, itemno, price))


txt = "We are the so-called \"Vikings\" from the north."
print(txt)