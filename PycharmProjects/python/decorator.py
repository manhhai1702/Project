
def decor_func(func):
    def wrapper(infor):
        return ' chuyen ham decorator : {}'.format(func(infor))
    return wrapper


def show_text (infor):
    return 'thông tin truyền vào: {}'.format(infor)


x = decor_func(show_text)

print(x('hainm'))

#====================================================================
def decor_func(func):
    def wrapper(infor):
        return ' chuyen ham decorator : {}'.format(func(infor))
    return wrapper

@decor_func
def show_text (infor):
    return 'thông tin truyền vào: {}'.format(infor)

print(show_text ('hainm'))

#====================================================================
