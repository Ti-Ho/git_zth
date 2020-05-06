s = 'Hello World'
str(s)      # 'Hello World'
repr(s)     # "'Hello World'"
str(1/7)    # '0.14285714285714285'

x = 10 * 3.25
y = 200 * 200
s = 'x的值为: ' + repr(x) + ', y的值为:' + repr(y) + '...'
print(s)    # x的值为: 32.5, y的值为:40000...

#  repr() 函数可以转义字符串中的特殊字符
hello = 'hello, runoob\n'
hellos = repr(hello)
print(hellos)   # 'hello, runoob\n'

# repr() 的参数可以是 Python 的任何对象
repr((x, y, ('Google', 'Runoob'))) # "(32.5, 40000, ('Google', 'Runoob'))"
