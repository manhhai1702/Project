mytuple = ("apple", "banana", "cherry")
myit = iter(mytuple)

print(next(myit))
print(next(myit))
print(next(myit))

# iter_obj là một iterator object tạo từ iterable
iterable=[1,2,3,4,5,6]
iter_obj = iter(iterable)

# vòng lặp
while True:
    try:
        # sử dụng next
        element = next(iter_obj)
        print(element)
    except StopIteration:
        # nếu xảy ra lỗi StopIteration thì vòng lặp sẽ được break ra ngoài
        break


 # xây dựng vong lặp
class MyNumbers:
  def __iter__(self):
    self.a = 1
    return self

  def __next__(self):
    if self.a <= 5:
      x = self.a
      self.a += 1
      return x
    else:
      raise StopIteration

myclass = MyNumbers()
print("in myclass:",myclass)

myiter = iter(myclass)

for x in myiter:
  print(x)


# START viet ham sho so nguyen to den 1 so max =========================
#ham check so nguyen to
def check_prime(number):
    for divisor in range(2, int(number ** 0.5)+1):
        if number % divisor == 0:
            return False
    return True

#class so nguyen to có phuong thuc iterator và next
class Primes:
    def __init__(self, max):
        self.max = max
        self.number = 1

    def __iter__(self):
        return self

    def __next__(self):
        self.number += 1
        if self.number >= self.max:
            raise StopIteration
        elif check_prime(self.number):
            return self.number
        else:
            return self.__next__()

primes = Primes(100)
for m in primes:
    print(m)
# End viet ham sho so nguyen to den 1 so max =========================
#==========================Gennerator==================================

print("=================Generator=========================")
def Primes(max):
    number = 1
    while number < max:
        number += 1
        if check_prime(number):
            yield number
primes = Primes(100)

for r in primes:
    print(r)
print("=================Generator Expressions=========================")

primes = (i for i in range(2, 100) if check_prime(i))
print(primes)
for x in primes:
    print(x)