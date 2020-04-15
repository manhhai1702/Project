class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def myfunc(self):
        print("Hello my name is " + self.name)

    def printAge(self):
        print("I am : {} year old".format(self.age))



class studen(Person):
    pass

p1 = studen("John", 22)
p1.myfunc()
p1.printAge()