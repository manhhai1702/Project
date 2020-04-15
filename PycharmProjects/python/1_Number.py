
print("show value and type ======================")

x = 1
y = 2.10
z = 1j
print(x)
print(y)
print(z)
print(type(x))
print(type(y))
print(type(z))

print("convert number =========================")
#convert from int to float:
a = float(x)
#convert from float to int:
b = int(y)
#convert from int to complex:
c = complex(x)

print(a)
print(b)
print(c)

print(type(a))
print(type(b))
print(type(c))

print("Casting number =========================")
x = float(1)     # x will be 1.0
y = float(2.8)   # y will be 2.8
z = float("3")   # z will be 3.0
z = str(3.0)  # z will be '3.0'