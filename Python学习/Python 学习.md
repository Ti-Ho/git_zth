```
import pprint, pickle

#使用pickle模块从文件中重构python对象
pkl_file = open('data.pkl', 'rb')

data1 = pickle.load(pkl_file)
pprint.pprint(data1)

data2 = pickle.load(pkl_file)
pprint.pprint(data2)

pkl_file.close()
```

# Python3 基础

## 1. 基础语法

> 注释

```python
# 单行注释

'''
多行注释
'''

"""
多行注释
"""
```

> 缩进

```python
if True:
    print ("True")
else:
    print ("False")
```

> 多行语句

如果语句很长，可以使用(\\)来实现多行语句

```python
total = item_ont + \
    otem_two + \
    item_three
```

> 数字类型

python中数字有四种类型：整数、布尔型、浮点数和复数。

```python
int 	 # 表示为长整型
bool 	 # True False
float
complex  # 复数 如1 + 2j、 1.1 + 2.2j
```

> 字符串(String)

* 单引号和双引号使用完全相同
* '''(或""")三引号可以指定一个多行字符串
* 转义符'\\' 
* 使用r可以让反斜杠不转义 如： r"this is a line with \n"
* +连接 *重复
* 两种索引 从左往右以0开始 从右往左以-1开始

![img](https://www.runoob.com/wp-content/uploads/2013/11/o99aU.png)

* 字符串截取语法格式：**变量[头下标:尾下标:步长]**

```python
word = '字符串'
sentence = "这是一个句子。"
paragraph="""这是一个段落，
可以由多行组成"""

str = 'zthkai'

print(str)                 # 输出字符串
print(str[0:-1])           # 输出第一个到倒数第二个的所有字符
print(str[0])              # 输出字符串第一个字符
print(str[2:5])            # 输出从第三个开始到第五个的字符
print(str[2:])             # 输出从第三个开始后的所有字符
print(str * 2)             # 输出字符串两次
print(str + '你好')        # 连接字符串

print('------------------------------')

print('hello\nrunoob')      # 使用反斜杠(\)+n转义特殊字符
print(r'hello\nrunoob')     # 在字符串前面添加一个 r，表示原始字符串，不会发生转义
```

```xml
输出:
Runoob
Runoo
R
noo
noob
RunoobRunoob
Runoob你好
------------------------------
hello
runoob
hello\nrunoob
```

* 字符串格式化

```python
print("我叫 %s 今年 %d 岁!" % ('小明', 10))
# 输出： 我叫 小明 今年 10 岁!
```



> 等待用户输入

```python
input("按下 enter 键后退出。")
```

> 同一行显示多条语句

语句之间用(;)分割

```python
import sys; x = 'runoob'; sys.stdout.write(x + '\n')
```

> 多个语句构成代码组

缩进相同的一组语句构成一个代码块，称为代码组

```python
if expression : 
   suite
elif expression : 
   suite 
else : 
   suite
```

> Print输出

print默认输出换行， 不换行在变量末加上end=""

```python
print( x )
print( x, end=" " )
```

> import 与 from...import

在python用`import`或者`from...import`来导入相应的模块

在某个模块(somemodule)导入 `import somemodule`

从某个模块中导入某个函数	`from somemodule import somefunction`

从某个模块中导入多个函数 `from somemodule import firstfunc, secondfunc, thirdfunc`

将某个模块中的全部函数导入 `from somemodule import *`

```python
# 导入sys模块
import sys
print('================Python import mode==========================')
print('命令行参数为:')
for i in sys.argv:
    print(i)
print('\n python路径为',sys.path)
```

```python
# 导入sys模块中的argv,path成员
from sys import argv,path

print('================python from import===================================')
print('path:',path) # 因为已经导入path成员，所以此处引用时不需要加sys.path
```

----

## 2. 基本数据类型

变量不需要声明 使用前必须赋值 赋值后变量才会被创建

变量没有类型 类型是变量所指的内存中对象的类型

> 多个变量赋值

```python
a = b = c = 1
a, b, c = 1, 2, "zth"
```



> 标准数据类型（6个）

**不可变数据**：Number、String、Tuple(元组)

**可变数据**”：List、Dictionary(字典)、Set

内置的`type()`可以用来查询变量所指的对象类型

还可以用`isinstance`来判断 （返回True False）**eg. isinstance(a, int)**



* 当指定一个值时，Number对象就会被创建   `var1 = 1`
* 可以使用del语句删除一些对象的引用

```python
del var
del var_a, var_b
```



> 数值运算

```python
2 / 4  # 浮点数除法
2 // 4 # 整数除法
17 % 3 # 取余
2 ** 5 # 乘方
```



> List（列表）

列表中的元素类型可以不相同，它支持数字，字符串甚至包含列表

列表截取方式与字符串相同

```python
list = ['abcd', 7892, 2.23, 'zth', [1, 2, 'abc']]
tinylist = ['kai', 1]
```



> Tuple(元组)

tuple与列表类似，不同之处在于元组的元素不能修改，元素写在`()`里

```python
tuple = ( 'abcd', 786 , 2.23, 'zth', 70.2  )
tinytuple = (123, 'zth')
tup1 = ()    # 空元组
tup2 = (20,) # 一个元素，需要在元素后添加逗号
```



> Set

可以使用`{  }`或者`set()`函数创建Set， 创建一个空的Set必须用`set()`而不是`{}`，因为`{}`是用来创建一个空字典

```python
student = {'Tom', 'Jim', 'Mary', 'Tom', 'Jack', 'Rose'}
print(student) # 重复元素 自动去掉

if 'Rose' in student :
    print('yes')
else :
    print('no')

# set可以进行集合运算
a = set('abracadabra')
b = set('alacazam')

print(a)
print(a - b)  # a 和 b 的差集
print(a | b)  # a 和 b 的并集
print(a & b)  # a 和 b 的交集
print(a ^ b)  # a 和 b 中不同时存在的元素
```



> Dictionary

字典用`{}`标识， 它是一个无序的 **键(key) : 值(value)** 的集合。

```python
dict = {}
dict['one'] = "1 - kai"
dict[2] = '2 - zth'

tinydict = {'name': 'zth', 'code': 1, 'site': 'asdasd.com'}

print (dict['one'])       # 输出键为 'one' 的值
print (dict[2])           # 输出键为 2 的值
print (tinydict)          # 输出完整的字典
print (tinydict.keys())   # 输出所有键
print (tinydict.values()) # 输出所有值
```

> Python数据类型转换

| 函数                 | 描述                  |
| -------------------- | --------------------- |
| int(x)               | 将x转换为一个整数     |
| float(x)             | 将x转换到一个浮点数   |
| complex(real[,imag]) | 创建一个复数          |
| str(x)               | 将对象 x 转换为字符串 |

## 3. Python运算符

* 算数运算符  `+ - *  /   %   //(取整除)   ** （幂）`

* 比较运算符  `==   !=   >   <   >=   <=`
* 赋值运算符 `= += -=  *=  /=  %=  **=  //=  :=`
  * `:=` 海象运算符，可在表达式内部为变量赋值 python 3.8新增

* 位运算符 `& | ^ ~ << >> `
* 逻辑运算符 `and   or  not`
* 成员运算符 `in	not in` 

```python
a = 10
b = 20
list = [1, 2, 3, 4, 5 ];
if ( a in list ):
   print ("1 - 变量 a 在给定的列表中 list 中")
else:
   print ("1 - 变量 a 不在给定的列表中 list 中")
```

* 身份运算符 `is		is not`  用于判断两个变量引用对象是否为同一个

## 4. 数学函数

> 一般数学函数

| 函数             | 返回值（描述）                                               |
| ---------------- | ------------------------------------------------------------ |
| abs(x)           | 返回绝对值                                                   |
| ceil(x)          | 返回数字的上入整数                                           |
| cmp(x,y)         | x < y 返回 -1 ;x == y 返回 0; x > y 返回 1           **Python 3 已废弃，使用 (x>y)-(x<y)**替换 |
| exp(x)           | 返回e的x次幂                                                 |
| fabs(x)          | 返回数字的绝对值                                             |
| floor(x)         | 返回数字的下舍整数                                           |
| log(x)           | 如math.log(math.e)返回1.0,math.log(100,10)返回2.0            |
| log10(x)         | 返回以10为基数的x的对数                                      |
| max(x1, x2,...)  | 返回给定参数的最大值，参数可以为**序列**                     |
| min(x1, x2, ...) | 返回给定参数的最小值，参数可以为**序列**                     |
| modf(x)          | 返回x的整数部分与小数部分，两部分的数值符号与x相同，整数部分以浮点型表示。 `print(math.modf(123.456))` 结果：`(0.45600000000000307, 123.0)` |
| pow(x, y)        | x**y后的值（x的y次幂）                                       |
| round(x [,n])    | 返回浮点数 x 的四舍五入值，如给出 n 值，则代表舍入到小数点后的位数。 |
| sqrt(x)          | x的平方根                                                    |

> 随机数函数

| 函数                           | 描述                                                         |
| ------------------------------ | ------------------------------------------------------------ |
| choice(seq)                    | 从序列的元素中随机挑选一个元素，比如`random.choice(range(10))`,从0到9中随机挑选一个整数 |
| randrange([start,]stop[,step]) | 从指定范围内，按指定基数递增的集合中获取一个随机数           |
| random()                       | 随机生成下一个实数，它在[0,1)范围内                          |
| seed([x])                      | 改变随机数生成器的种子seed。                                 |
| shuffle(lst)                   | 将序列所有元素随机排序                                       |
| uniform(x, y)                  | 随机生成下一个实数，它在[x,y]范围内。                        |

> 三角函数

`acos(x) asin(x) atan(x) atan2(y,x) cos(x) sin(x) tan(x)`

`hypot(x,y)`: 返回欧几里德范数 sqrt(x\*x + y*y)。

`degree(x)`:  将弧度转换为角度,如degrees(math.pi/2) ， 返回90.0

`radians(x)`:将角度转换为弧度

常量：`圆周率:pi 自然常数:e`

 

## 5. 列表

* 删除列表元素

```python
list = ['zth', 'kai', 1997, 2000]
del list[2]
print(list)  # ['zth', 'kai', 2000]
```

* 列表函数&方法 

  * 函数

  ```python
  len(list) # 列表元素个数
  max(list) # 返回列表元素最大值
  min(list) # 返回列表元素最小值
  list(seq) # 将元组转换为列表
  ```

  * 方法

  ```python
  list.append(obj)	# 在列表末尾添加新的对象
  list.count(obj)		# 统计某个元素在列表中出现的次数
  list.extend(seq) 	# 在列表末尾一次性追加另一个序列中的多个值（用新列表扩展原来的列表）
  list.index(obj) 	# 从列表中找出某个值第一个匹配项的索引位置
  list.insert(index,object) # 将对象插入列表
  list.pop([index = -1])	  # 移除列表中的一个元素（默认最后一个元素），并且返回该元素的值
  list.remove(obj) 	# 移除列表中某个值的第一个匹配项
  list.reverse() 		# 反向列表中元素
  list.sort(key = None, reverse = False) # 对原列表进行排序
  list.clear() 		# 清空列表
  list.copy() 		# 复制列表
  ```



##　6. 集合

集合的基本操作

* 添加元素 

  `s.add(x)`:

  ```python
  thisset = set(("Google", "Runoob", "Taobao"))
  # thisset = {"Google", "Runoob", "Taobao"}
  thisset.add("zth")
  print(thisset)
  ```

  `s.update(x)` 参数可以是列表，元组，字典等

* 移除元素

   `s.remove(x)` 如果元素不存在会发生错误

  `s.discard(x)`如果元素不存在，不会发生错误



# 开始Python3编程

## 1. 写一个斐波那契数列

```python
# Fibonacci series
a, b = 0, 1
while b < 10: 
    print(b, end=',')
    a, b = b, a + b   # 这句应该这样看 (a,b) = (b,a+b) 即分别将b赋值给a,a+b赋值给b
```

 [^输出：1,1,2,3,5,8,]

## 2. 条件控制

```python
if condition_1:
    statement_block_1
elif condition_2:  # elif 代替else if
    statement_block_2
else:
    statement_block_3
```

`if-elif-else`



## 3. 循环语句

```python
while 判断条件(condition)：
    执行语句(statements)……
    
# 简单语句组
while (flag): print ('abcabc')
```

* while循环使用else语句

```python
while <expr>:
    <statement(s)>
else:
    <additional_statement(s)>
```

* for语句

```python
for <variable> in <sequence>:
    <statements>
else:  # 没有循环数据执行
    <statements>

sites = ["Baidu", "Google","Runoob","Taobao"]
for site in sites:
    if site == "Runoob":
        print("菜鸟教程!")
        break
    print("循环数据 " + site)
else:
    print("没有循环数据!")
print("完成循环!")
```

* range()函数

```python
for i in range(5):
	print(i)
# 输出 0 1 2 3 4

for i in range(5, 9):
    print(i)
# 输出 5, 6, 7, 8


# 结合range()和len()函数以遍历一个序列的索引
list = ["kai", "apple", "zth", "c"]
for i in range(len(list)):
    print(i, list[i])
''' 输出:
0 kai
1 apple
2 zth
3 c
'''
```



## 4. 迭代器与生成器

迭代器有两个基本的方法：**iter()** 和 **next()**。

```python
list = [1, 2, 3, 4]
it = iter(list)  # 创建迭代器对象
for x in it:
    print(x, end=" ")
```



使用`next()`函数：

```python
import sys

list = [1, 2, 3, 4]
it = iter(list)

while True:
    try:
        print(next(it))
    except StopAsyncIteration:
        sys.exit()
```



>  创建一个迭代器

把一个类作为一个迭代器需要在类中实现两个方法` __iter__()`和`__next__()`。

* `__iter__()`: 返回一个特殊的迭代器对象，这个迭代器对象实现了`__next__()`方法并通过StopIteration异常标识迭代的完成。

* `__next__()`: 方法会返回下一个迭代器对象。创建一个返回数字的迭代器，初始值为1，逐步递增1
* `StopIteration异常`： 用于标识迭代的完成，防止五先循环的情况

```python
class MyNumbers:
    def __iter__(self):
        self.a = 1
        return self

    def __next__(self):
        if self.a <= 20:
            x = self.a
            self.a += 1
            return x
        else:
            raise StopIteration

myclass = MyNumbers()
myiter = iter(myclass)

for x in myiter:
    print(x)
```

输出：

```xml
1
2
3
4
```



> 生成器

在Python中，使用了`yield`类型的函数被称为生成器(generator).

跟普通函数不同的是,生成器是一个返回迭代器的函数,只能用于迭代操作.

在调用生成器运行的过程中,每次遇到`yield`时函数会暂停并保存当前所有的运行信息,返回的是一个迭代器对象.

```python
# 使用yield实现斐波那契数列

import sys

def fibonacci(n):   # 生成器函数 - 斐波那契
    a, b, counter = 0, 1, 0
    while True:
        if (counter > n):
            return
        yield a
        a, b = b, a + b
        counter += 1

f = fibonacci(10)   # f 是一个迭代器，由生成器返回生成

while True:
    try:
        print(next(f), end = " ")
    except StopIteration:
        sys.exit()
```



## 5. 函数

> 定义函数

* 语法

```python
def 函数名(参数列表):
    函数体
```

* 实例

```python
def hello():
    print("hello world")
hello()

def area(width, height):
    return width * height
```



> python函数的参数传递

* **不可变类型:** 类似 c++ 的值传递，如 整数、字符串、元组。如fun（a），传递的只是a的值，没有影响a对象本身。比如在 fun（a）内部修改 a 的值，只是修改另一个复制的对象，不会影响 a 本身。[^a=5]

```python
def ChangeInt(a):
    a = 10

b = 2
ChangeInt(b)
print(b) # 结果是2
```



* **可变类型**: 类似 c++ 的引用传递，如 列表，字典。如 fun（la）[^la=[1,2,3,4\]]，则是将 la 真正的传过去，修改后fun外部的la也会受影响

```python
def changeme(mylist):
    "修改传入的列表"
    mylist.append([1,2,3,4])
    print("函数内取值：", mylist)
    return

# 调用changeme函数
mylist = [10,20,30]
changeme(mylist)
print("函数外取值：",mylist)
```

输出:

```
函数内取值： [10, 20, 30, [1, 2, 3, 4]]
函数外取值： [10, 20, 30, [1, 2, 3, 4]]
```



> 参数

* **必须参数**

* **关键字参数**

  函数调用使用关键字参数来确定传入的参数值.

  使用关键字参数允许**函数调用参数的顺序**与**声明时**不一致,因为Python解释器能够用参数名匹配参数值.

  ```python
  def printinfo(name, age):
      print("名字：",name)
      print("年龄：",age)
      return
  
  printinfo(age = 21, name = "kai")
  ```

* **默认参数**

  调用函数时,如果没有传递参数,则会使用默认参数.

  ```python
  def printinfo( name, age = 35 ):
     print ("名字: ", name)
     print ("年龄: ", age)
     return
  
  printinfo( age=21, name="kai" )
  print ("------------------------")
  printinfo( name="kai" )
  ```

* **不定长参数**

可能需要一个函数能处理比当初声明时更多的参数.

```python
def functionname([formal_args,] *var_args_tuple)
	"函数_文档字符串"
    function_suite
    return [expression]
```



加`*`的参数会以元组(tuple)的形式导入,存放所有未命名的变量参数

```python
def printinfo( arg1, *vartuple ):
   "打印任何传入的参数"
   print ("输出: ")
   print (arg1)
   print (vartuple)
 
# 调用printinfo 函数
printinfo( 70, 60, 50 )
```

```
输出: 
70
(60, 50)
```



加`**`的参数会以字典的形式导入

```python
def printinfo(arg1, **vardict):
    print("输出：")
    print(arg1)
    print(vardict)

printinfo(1, a = 2, b = 3)
```

```
输出：
1
{'a': 2, 'b': 3}
```



> 匿名函数

```python
# 使用 lambda 来创建匿名函数
sum = lambda arg1, arg2: arg1 + arg2

# 调用sum函数
print ("相加后的值为 : ", sum( 10, 20 ))
```



## 6. 数据结构

> 列表List的方法

在Python3基础--列表



> 将列表当作堆栈使用

```python
from collections import deque
queue = deque(["Eric", "John", "Michael"])
queue.append("Kai")
queue.append("Zth")
queue.popleft()
queue.popleft()
print(queue)
```



>列表推导式

提供了从序列创建列表的简单途径。

```python
#将列表中的每个数值乘3
vec = [2, 4, 6]
print([3 * x for x in vec])

''' 输出：
[6, 12, 18]
'''
```

```python
vec = [2, 4, 6]
l = [[x, x**2] for x in vec]
print(l)
'''
输出：
[[2, 4], [4, 16], [6, 36]]
'''
```

```python
# 对序列里每一个元素逐个调用某方法
freshfruit = ['  banana', '  loganberry ', 'passion fruit  ']
l = [x.strip() for x in freshfruit]
print(l)

'''输出:
['banana', 'loganberry', 'passion fruit']
'''
```

```python
#用if语句做过滤器
vec = [2, 4, 6]
l1 = [3 * x for x in vec if x > 3]
print(l1)
l2 = [3 * x for x in vec if x < 2]
print(l2)

'''输出
[12, 18]
[]
'''
```

```python
# 一些关于循环和其它技巧的演示
vec1 = [2, 4, 6]
vec2 = [4, 3, -9]
l = [x * y for x in vec1 for y in vec2]
print(l)

'''输出
[8, 6, -18, 16, 12, -36, 24, 18, -54]
'''
```

```python
# 一些关于循环和其它技巧的演示
vec1 = [2, 4, 6]
vec2 = [4, 3, -9]
l = [x * y for x in vec1 for y in vec2]
print(l)   # 输出: [8, 6, -18, 16, 12, -36, 24, 18, -54]

l2 = [x + y for x in vec1 for y in vec2] 
print(l2)   # 输出:[6, 5, -7, 8, 7, -5, 10, 9, -3]
```

```python
# 列表推导式可以使用复杂表达式或嵌套函数
l = [str(round(355/113, i)) for i in range(1, 6)]
print(l) 
#输出:['3.1', '3.14', '3.142', '3.1416', '3.14159']
```



>  嵌套列表解析

```python
matrix = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
]

# 3 * 4 矩阵转换为4 * 3
mat = [[row[i] for row in matrix] for i in range(4)]
print(mat)

# 方法2
mat2 = []
for i in range(4):
    mat2.append([row[i] for row in matrix])

# 方法3
mat3 = []
for i in range(4):
    mat_row = []
    for row in matrix:
        mat_row.append(row[i])
    mat3.append(mat_row)
```



> 字典

```python
tel = {'jack': 4098, 'sape': 4139}
tel['zth'] = 21
print(tel)

del tel['sape']
print(tel)

print(list(tel.keys()))
print(list(tel.values()))
```

```
输出:
{'jack': 4098, 'sape': 4139, 'zth': 21}
{'jack': 4098, 'zth': 21}
['jack', 'zth']
[4098, 21]
```



> 遍历技巧

* 字典中遍历,关键字和对应的值可以使用items()方法同时解读

```python
knights = {'gallahad': 'the pure', 'robin': 'the brave'}
for k, v in knights.items():
    print(k, v)

'''
gallahad the pure
robin the brave
'''
```

* 序列中遍历时, 索引位置和对应值可以使用enumerate()函数同时得到:

```python
for i, v in enumerate(['tic', 'tac', 'toe']):
    print(i, v)

'''
0 tic
1 tac
2 toe
'''
```

* 同时遍历两个或更多的序列,可使用zip()组合

```python
questions = ['name', 'quest', 'favorite color']
answers = ['lancelot', 'the holy grail', 'blue']

for q, a in zip(questions, answers):
    print('What is your {0}? It is {1}.'.format(q, a))

'''
What is your name? It is lancelot.
What is your quest? It is the holy grail.
What is your favorite color? It is blue.
'''
```

* 反向遍历

```python
for i in reversed(range(1, 10, 2)):
    print(i)
```

* 排序

```python
basket = ['apple', 'orange', 'apple', 'pear', 'orange', 'banana']
for f in sorted(basket):
    print(f)
```



## 7. 模块

模块是一个包含所有你定义的函数和变量的文件,其后缀名是`.py`模块可以被别的程序引入,以使用该模块中的函数等功能.

```python
# Filename: fibo.py
# 斐波那契(fibonacci)数列模块
def fib(n):  # 定义到 n 的斐波那契数列
    a, b = 0, 1
    while b < n:
        print(b, end=' ')
        a, b = b, a + b
    print()


def fib2(n):  # 返回到 n 的斐波那契数列
    result = []
    a, b = 0, 1
    while b < n:
        result.append(b)
        a, b = b, a + b
    return result
```

```python
# 导入模块
import fibo

# 现在可以调用模块里包含的函数了
fibo.fib(1000)
fib_func = fibo.fib
fib_func(100)
```



> `__name__`属性

一个模块被另一个程序第一次引入时,其主程序将运行. 如果我们想在模块中被引入时, 模块中的某一程序块不执行,我们可以用`__name__`属性来使该程序块仅在自身运行时执行.

```python
# Filename: using_name.py

if __name__ == '__main__':
    print('程序自身在运行')
else:
    print('我来自另一个模块')
```

自身运行:

```
程序自身在运行
```

外部引入using_name:

```python
import using_name

输出:
程序自身在运行
```



* 每个模块都有一个`__name__`属性, 当其值是`'__main__'`时,表明该模块自身在运行,否则时被引入



##　8.输入和输出

> 将输出的值转成字符串,使用`repr()`或`str()`函数实现

* `str()`:函数返回一个用户易懂的表达形式
* `repr()`:产生一个解释器易读的表达形式

```python
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
```

* `str.format()`的基本使用 :

  * ```python
    print('{}的英文名字为{}.'.format('张天昊', 'Kai'))
    # 输出: 张天昊的英文名字为Kai.
    ```

    括号里的字符会被format()中的参数替换.

  * 在括号中的数字用于指向对象在`format()`中的位置

  ```python
  print('{1}的中文名字为{0}.'.format('张天昊', 'Kai'))
  # Kai的中文名字为张天昊.
  ```

  * 在`format()`中使用了关键字参数,那它们的值会指向使用该名字的参数

  ```python
  print('{name}网址： {site}'.format(name='百度', site = 'www.baidu.com'))
  ```

  位置及关键字参数可以任意的结合:
  
  ```python
  print('站点列表 {0}, {1}, 和 {other}。'.format('Google', 'Runoob', other='Taobao'))
  ```

* 保留小数后三位

```python
import math
print('常量PI 的值近似为{0:.3f}'.format(math.pi))
```

* 在`:`后传入一个整数,保证该域至少有这么多的宽度

```python
table = {'Google': 1, 'Runoob': 2, 'Taobao': 3}
for name, number in table.items():
    print('{0:10} ==> {1:10d}'.format(name, number))
```

```
输出:
Google     ==>          1
Runoob     ==>          2
Taobao     ==>          3
```

* 传入一个字典, 然后使用方括号 **[]** 来访问键值 :

```python
table = {'Google': 1, 'Runoob': 2, 'Taobao': 3}
print('Runoob: {0[Runoob]:d}; Google: {0[Google]:d}; Taobao: {0[Taobao]:d}'.format(table))
```



> 读取键盘输入

```python
str = input("请输入：");
print ("你输入的内容是: ", str)
```



> 读和写文件

`open()`会返回一个file对象

```python
open(filename, mode)
```

* `filename`: 包含了访问的文件名称的字符串值
* `mode`: 决定了打开文件的模式: 只读、写入、追加等，默认文件访问模式为只读(r)

|    模式    |  r   |  r+  |  w   |  w+  |  a   |  a+  |
| :--------: | :--: | :--: | :--: | :--: | :--: | :--: |
|     读     |  +   |  +   |      |  +   |      |  +   |
|     写     |      |  +   |  +   |  +   |  +   |  +   |
|    创建    |      |      |  +   |  +   |  +   |  +   |
|    覆盖    |      |      |  +   |  +   |      |      |
| 指针在开始 |  +   |  +   |  +   |  +   |      |      |
| 指针在结尾 |      |      |      |      |  +   |  +   |

```python
# 打开一个文件
f = open("./1.txt", "w")
f.write("Python 是一个非常好的语言。\n是的，的确非常好!!\n")
f.close()
```



> 文件对象的方法

* `f.read(size)`为读取一个文件的内容，调用该函数将读取一定数目的数据，若`size`被忽略或为负，那么该文件的**所有内容**都将被读取并返回。

* `f.raedline()`会从文件中读取单独的一行。换行符为'\n'

  若返回一个空字符串，说明已经读取到最后一行。

* `f.readlines()`将返回该文件中包含的所有行。

  如果设置可选参数 sizehint, 则读取指定长度的字节, 并且将这些字节按行分割。

* `f.write(string)`将 string 写入到文件中, 然后返回写入的字符数。

* `f.close()`



> pickle模块

python的pickle模块实现了基本的数据序列和反序列化。

通过pickle模块的序列化操作能够将程序中运行的对象信息保存到文件中去，永久存储。

通过pickle模块的反序列化操作，我们能够从文件中创建上一次程序保存的对象。

基本接口：

```python
pickle.dump(obj, file, [,protocol])
```

有了 pickle 这个对象, 就能对 file 以读取的形式打开:

```python
x = pickle.load(file)
```



```python
import pickle
# 使用pickle模块将数据对象保存到文件
data1 = {'a': [1, 2.0, 3, 4+6j],
         'b': ('string', u'Unicode string'),
         'c': None}

selfref_list = [1, 2, 3]
selfref_list.append(selfref_list)

output = open('data.pkl','wb')

pickle.dump(data1, output)
pickle.dump(selfref_list, output, -1)
output.close()
```

```python
import pprint, pickle

#使用pickle模块从文件中重构python对象
pkl_file = open('data.pkl', 'rb')

data1 = pickle.load(pkl_file)
pprint.pprint(data1)

data2 = pickle.load(pkl_file)
pprint.pprint(data2)

pkl_file.close()
```



## 9. 错误和异常

> 异常处理

* `try/except`异常捕捉可以使用`try/except`语句。

```python
try:
   	执行代码
except:
    发生异常时执行的代码
```

```python
while True:
    try:
        x = int(input("请输入一个数字: "))
        break
    except ValueError:
        print("您输入的不是数字，请再次尝试输入！")
```

一个except子句可以同时处理多个异常，这些异常将被放在一个括号里成为一个元组，例如:

```python
except (RuntimeError, TypeError, NameError):
    pass
```

最后一个except子句可以忽略异常的名称，它将被当作通配符使用。你可以使用这种方法打印一个错误信息，然后再次把异常抛出。

```python
import sys
 
try:
    f = open('myfile.txt')
    s = f.readline()
    i = int(s.strip())
except OSError as err:
    print("OS error: {0}".format(err))
except ValueError:
    print("Could not convert data to an integer.")
except:
    print("Unexpected error:", sys.exc_info()[0])
    raise
```



* try/except...else

**try/except** 语句还有一个可选的 **else** 子句，如果使用这个子句，那么必须放在所有的 except 子句之后。

else 子句将在 try 子句没有发生任何异常的时候执行。

```python
try:
   	执行代码
except:
    发生异常时执行的代码
else:
    没有异常时执行的代码
```



* try-finally

```python
try:
   	执行代码
except:
    发生异常时执行的代码
else:
    没有异常时执行的代码
finally:
    不管有没有异常都会执行的代码
```



> 抛出异常 `raise`

raise语法格式如下：

```python
raise [Exception [, args [, traceback]]]
```

以下实例如果 x 大于 5 就触发异常:

```python
x = 10
if x > 5:
    raise Exception('x 不能大于 5。x 的值为: {}'.format(x))
```



> 用户自定义异常

可以通过创建一个新的异常类来拥有自己的异常。异常类继承自 Exception 类，可以直接继承，或者间接继承，例如:

```python
class MyError(Exception):
    def __init__(self, value):
        self.value = value
    def __str__(self):
        return repr(self.value)

try:
    raise  MyError(2*2)
except MyError as e:
    print('My exception occurred, value:', e.value)
```

```
输出：
My exception occurred, value: 4
```



## 10.python3面向对象

> 类定义

```python
class ClassName:
    <statement-1>
    .
    .
    .
    <statement-N>
```



> 类对象

类对象支持两种操作：属性引用和实例化

属性引用使用和 Python 中所有的属性引用一样的标准语法：**obj.name**。

```python
class MyClass:
    """一个简单的类实例"""
    i = 12345
    def f():
        return 'hello world'

# 实例化类
x = MyClass

# 访问类属性和方法
print("MyClass 类的属性 i 为：", x.i)
print("MyClass 类的方法 f 输出为：", x.f())
```

```
输出：
MyClass 类的属性 i 为： 12345
MyClass 类的方法 f 输出为： hello world
```



* 类有一个名为`__init--()`的特殊方法（构造方法），该方法在类实例化时会自动调用

```python
def __init__(self):
    self.data = []
```

类定义了 __init__() 方法，类的实例化操作会自动调用 __init__() 方法。如下实例化类 MyClass，对应的 __init__() 方法就会被调用:

```
x = MyClass()
```

```python
# 带参数的构造函数
class Complex:
    def __init__(self, realpart, imagpart):
        self.r = realpart
        self.i = imagpart
x = Complex(3.0, -4.5)
print(x.r, x.i)   # 输出结果：3.0 -4.5
```

**self代表类的实例，而非类**

类的方法与普通函数的区别：必须有一个额外的**第一个参数名称**, 按照惯例它的名称是 self。



> 继承

派生类的定义：

```python
class DerivedClassName(BaseClassName1):
    <statement-1>
    .
    .
    .
    <statement-N>
```

```python
#类定义
class people:
    #定义基本属性
    name = ''
    age = 0
    #定义私有属性,私有属性在类外部无法直接进行访问
    __weight = 0
    #定义构造方法
    def __init__(self,n,a,w):
        self.name = n
        self.age = a
        self.__weight = w
    def speak(self):
        print("%s 说: 我 %d 岁。" %(self.name,self.age))

#单继承示例
class student(people):
    grade = ''
    def __init__(self,n,a,w,g):
        #调用父类的构函
        people.__init__(self,n,a,w)
        self.grade = g
    #覆写父类的方法
    def speak(self):
        print("%s 说: 我 %d 岁了，我在读 %d 年级"%(self.name,self.age,self.grade))

s = student('ken',10,60,3)
s.speak()
```



> 多继承

```python
class DerivedClassName(Base1, Base2, Base3):
    <statement-1>
    .
    .
    .
    <statement-N>
```



> 方法重写

```python
class Parent:        # 定义父类
   def myMethod(self):
      print ('调用父类方法')
 
class Child(Parent): # 定义子类
   def myMethod(self):
      print ('调用子类方法')
 
c = Child()          # 子类实例
c.myMethod()         # 子类调用重写方法
super(Child,c).myMethod() #用子类对象调用父类已被覆盖的方法
```

`super() 函数`是用于调用父类(超类)的一个方法。



> 类属性与方法

* **类的私有属性**

`private_attrs`: 两个下划线开头，声明该属性为私有，不能在类的外部被使用或直接访问。在类内部的方法中使用时 `self.__private_attrs`。

> 类的方法

在类的内部，使用 def 关键字来定义一个方法，与一般函数定义不同，类方法必须包含参数 **self**，且为第一个参数，**self** 代表的是类的实例。

**self** 的名字并不是规定死的，也可以使用 **this**，但是最好还是按照约定是用 **self**。

> 类的私有方法

**__private_method**：两个下划线开头，声明该方法为私有方法，只能在类的内部调用 ，不能在类的外部调用。**self.__private_methods**。



```python
# 类的私有属性实例如下：
class JustCounter:
    __secretCount = 0  # 私有变量
    publicCount = 0    # 公开变量
 
    def count(self):
        self.__secretCount += 1
        self.publicCount += 1
        print (self.__secretCount)
 
counter = JustCounter()
counter.count()
counter.count()
print (counter.publicCount)
print (counter.__secretCount)  # 报错，实例不能访问私有变量
```

> 类的专有方法：

- **__init__ :** 构造函数，在生成对象时调用
- **__del__ :** 析构函数，释放对象时使用
- **__repr__ :** 打印，转换
- **__setitem__ :** 按照索引赋值
- **__getitem__:** 按照索引获取值
- **__len__:** 获得长度
- **__cmp__:** 比较运算
- **__call__:** 函数调用
- **__add__:** 加运算
- **__sub__:** 减运算
- **__mul__:** 乘运算
- **__truediv__:** 除运算
- **__mod__:** 求余运算
- **__pow__:** 乘方

> 运算符重载

重载加号：

```python
class Vector:
   def __init__(self, a, b):
      self.a = a
      self.b = b
 
   def __str__(self):
      return 'Vector (%d, %d)' % (self.a, self.b)
   
   def __add__(self,other):
      return Vector(self.a + other.a, self.b + other.b)
 
v1 = Vector(2,10)
v2 = Vector(5,-2)
print (v1 + v2)
```



# Python3 JSON 数据解析

Python3 中可以使用JSON数据进行编解码，它包含了两个函数：
`json.dumps()`:对数据进行编码

`json.loads()`:对数据进行解码

## 1. Python编码为JSON类型转换对应表

| Python                                 | JSON   |
| :------------------------------------- | :----- |
| dict                                   | object |
| list, tuple                            | array  |
| str                                    | string |
| int, float, int- & float-derived Enums | number |
| True                                   | true   |
| False                                  | false  |
| None                                   | null   |

## 2. JSON 解码为 Python 类型转换对应表

| JSON          | Python |
| :------------ | :----- |
| object        | dict   |
| array         | list   |
| string        | str    |
| number (int)  | int    |
| number (real) | float  |
| true          | True   |
| false         | False  |
| null          | None   |

## 3. json.dumps 与 json.loads 实例

 对数据编码 `json.dumps()：python -> JSON`

对数据解码 `json.loads(): JSON -> python`

```python
import json

# 对数据编码 json.dumps()：python -> JSON
def testdumps():
    data = {
        'no': 1,
        'name': 'Zth',
        'age': 21
    }
    json_str = json.dumps(data)
    print("Python 原始数据：", repr(data))
    print("JSON 对象：", json_str)
    return json_str


#  对数据解码 json.loads(): JSON -> python
def testloads(json_str):
    python_data = json.loads(json_str)
    print("转换后的Python数据: ", python_data)
    print("python_data['name']: ", python_data['name'])
    print("python_data['age']: ", python_data['age'])

# 调用
json_str = testdumps()
testloads(json_str)
```

输出：

```
Python 原始数据： {'no': 1, 'name': 'Zth', 'age': 21}
JSON 对象： {"no": 1, "name": "Zth", "age": 21}
转换后的Python数据:  {'no': 1, 'name': 'Zth', 'age': 21}
python_data['name']:  Zth
python_data['age']:  21
```



## 4. 处理文件

```python
# 写入 JSON 数据
with open('data.json', 'w') as f:
    json.dump(data, f)
 
# 读取数据
with open('data.json', 'r') as f:
    data = json.load(f)
```



# Pythonget和post请求

```python
import requests
import json

# get举例
ret = requests.get('http://localhost:8080/comment/2')
print(ret.url)
print(ret.text)

# post举例
data = {
    "petId": 2,
    "costContent": "testpost",
    "costValue": 50.0
}
response = requests.post("http://localhost:8080/cost", data=json.dumps(data), headers={'content-type': "application/json"})
print(response.text)
```

# Python 数据库连接

```python
import pymysql
import random

# The configuration of connection
connectConfiguration = {
    "host": "scotty.ink",
    "port": 3306,
    "user": "root",
    "passwd": "123456",
    "db": "test",
    "charset": "utf8"
}

# Create Connection Class
class ConnDB():

    def __init__(self, dic):
        self.__conn_dict = dic
        self.conn = None
        self.cursor = None

    def connect(self, cursor=pymysql.cursors.DictCursor):
        self.conn = pymysql.connect(**self.__conn_dict)
        self.cursor = self.conn.cursor(cursor=cursor)
        return self.cursor

    def close(self):
        self.conn.commit()
        self.cursor.close()
        self.conn.close()

# Load data from "t_browse" in order to use them
def loadData():
    connection = ConnDB(connectConfiguration)
    sql = "SELECT * FROM t_browse"
    cursor = connection.connect()
    cursor.execute(sql)
    result = cursor.fetchall()
    print(result)
    connection.close()


# Mock function: insert random data into "t_browse"
# This function can be ignored
def initData():
    connection = ConnDB(connectConfiguration)
    cursor = connection.connect()
    sql = "INSERT INTO t_browse (user_id, article_id, browse_value) VALUES(%s, %s, %s)"
    for i in range(100):
        cursor.execute(sql, (random.randint(1, 20), random.randint(1, 30), random.randint(1, 12)))
    connection.close()

# Clear "t_recommend" in order to keep the newest data
def clearTable():
    connection = ConnDB(connectConfiguration)
    cursor = connection.connect()
    cursor.execute("DROP TABLE IF EXISTS t_recommend")
    sql = """CREATE TABLE t_recommend (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `user_id` bigint NOT NULL,
    `article_id` bigint NOT NULL,
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci"""
    cursor.execute(sql)
    connection.close()

# Insert data that get from algorithm into "t_recommend"
def outputData():
    connection = ConnDB(connectConfiguration)
    cursor = connection.connect()
    sql = "INSERT INTO t_recommend (user_id, article_id) VALUES(%s, %s)"
    # For test, need to change
    for i in range(10):
        cursor.execute(sql, (random.randint(1, 20), random.randint(1, 30)))
    connection.close()
        
    
#initData()
loadData()
print('*'*40)
clearTable()
outputData()
```

