# NumPy学习

## MatPlotlib

`MatPlotlib`是`Python`的绘图库。

### 实例

```python
import numpy as np
from matplotlib import pyplot as plt

x = np.arange(1, 11)
y = 2 * x + 5
plt.title('Matplotlib demo')
plt.xlabel('x axis caption')
plt.ylabel("y axis caption")
plt.plot(x,y)
plt.show()
```

np.arange() 函数创建 x 轴上的值。y 轴上的对应值存储在另一个数组对象 y 中。

这些值使用 matplotlib 软件包的 pyplot 子模块的 plot() 函数绘制。

图形由 show() 函数显示。

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601084730149.png" alt="image-20200601084730149" style="zoom: 67%;" />



### 图形中文显示

Matplotlib 默认情况不支持中文，我们可以使用以下简单的方法来解决：

添加以下代码：

```python
plt.rcParams['font.family']=['STFangsong']
```

```python
import numpy as np
from matplotlib import pyplot as plt

x = np.arange(1, 11)
y = 2 * x + 5

plt.rcParams['font.family']=['STFangsong']  

plt.title('Matplotlib 小样')
plt.xlabel('x axis caption')
plt.ylabel("y axis caption")
plt.plot(x,y)
plt.show()
```

运行截图

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601090725071.png" alt="image-20200601090725071" style="zoom:67%;" />

格式化字符：

| 字符   | 描述         |
| :----- | :----------- |
| `'-'`  | 实线样式     |
| `'--'` | 短横线样式   |
| `'-.'` | 点划线样式   |
| `':'`  | 虚线样式     |
| `'.'`  | 点标记       |
| `','`  | 像素标记     |
| `'o'`  | 圆标记       |
| `'v'`  | 倒三角标记   |
| `'^'`  | 正三角标记   |
| `'<'`  | 左三角标记   |
| `'>'`  | 右三角标记   |
| `'1'`  | 下箭头标记   |
| `'2'`  | 上箭头标记   |
| `'3'`  | 左箭头标记   |
| `'4'`  | 右箭头标记   |
| `'s'`  | 正方形标记   |
| `'p'`  | 五边形标记   |
| `'*'`  | 星形标记     |
| `'h'`  | 六边形标记 1 |
| `'H'`  | 六边形标记 2 |
| `'+'`  | 加号标记     |
| `'x'`  | X 标记       |
| `'D'`  | 菱形标记     |
| `'d'`  | 窄菱形标记   |
| `'|'`  | 竖直线标记   |
| `'_'`  | 水平线标记   |

以下是颜色的缩写：

| 字符  | 颜色   |
| :---- | :----- |
| `'b'` | 蓝色   |
| `'g'` | 绿色   |
| `'r'` | 红色   |
| `'c'` | 青色   |
| `'m'` | 品红色 |
| `'y'` | 黄色   |
| `'k'` | 黑色   |
| `'w'` | 白色   |

```python
import numpy as np
from matplotlib import pyplot as plt

x = np.arange(1, 11)
y = 2 * x + 5
plt.title("Matplotlib demo")
plt.xlabel("x axis caption")
plt.ylabel("y axis caption")
plt.plot(x, y, "xc")
plt.show()
```

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601091111218.png" alt="image-20200601091111218" style="zoom:67%;" />

### 绘制正弦波

```python
import numpy as np
import matplotlib.pyplot as plt
# 计算正弦曲线上点的 x 和 y 坐标
x = np.arange(0,  3  * np.pi,  0.1)
y = np.sin(x)
plt.title("sine wave form")
# 使用 matplotlib 来绘制点
plt.plot(x, y)
plt.show()
```

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601091345423.png" alt="image-20200601091345423" style="zoom:67%;" />

### subplot()

subplot() 函数允许你在同一图中绘制不同的东西。

```python
import numpy as np
import matplotlib.pyplot as plt
# 计算正弦和余弦曲线上的点的 x 和 y 坐标
x = np.arange(0,  3  * np.pi,  0.1)
y_sin = np.sin(x)
y_cos = np.cos(x)
# 建立 subplot 网格，高为 2，宽为 1
# 激活第一个 subplot
plt.subplot(2,  1,  1)
# 绘制第一个图像
plt.plot(x, y_sin)
plt.title('Sine')
# 将第二个 subplot 激活，并绘制第二个图像
plt.subplot(2,  1,  2)
plt.plot(x, y_cos)
plt.title('Cosine')
# 展示图像
plt.show()
```

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601091527609.png" alt="image-20200601091527609" style="zoom:67%;" />



### bar()

pyplot 子模块提供 bar() 函数来生成条形图。

```python
from matplotlib import pyplot as plt
x = [5, 8, 10]
y =  [12,16,6]
x2 =  [6,9,11]
y2 =  [6,15,7]
plt.bar(x, y, align =  'center')
plt.bar(x2, y2, color =  'g', align =  'center')
plt.title('Bar graph')
plt.ylabel('Y axis')
plt.xlabel('X axis')
plt.show()
```

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601091851428.png" alt="image-20200601091851428" style="zoom:67%;" />

### numpy.histogram()

numpy.histogram() 函数是数据的频率分布的图形表示。 水平尺寸相等的矩形对应于类间隔，称为 bin，变量 height 对应于频率。

numpy.histogram()函数将输入数组和 bin 作为两个参数。 bin 数组中的连续元素用作每个 bin 的边界。

```python
import numpy as np 
 
a = np.array([22,87,5,43,56,73,55,54,11,20,51,5,79,31,27])
np.histogram(a,bins =  [0,20,40,60,80,100]) 
hist,bins = np.histogram(a,bins =  [0,20,40,60,80,100])  
print (hist) 
print (bins)

-------------输出---------------
[3 4 5 2 1]
[  0  20  40  60  80 100]
```



pyplot 子模块的 plt() 函数将包含数据和 bin 数组的数组作为参数，并转换为直方图。

```python
from matplotlib import pyplot as plt 
import numpy as np  
 
a = np.array([22,87,5,43,56,73,55,54,11,20,51,5,79,31,27]) 
plt.hist(a, bins =  [0,20,40,60,80,100]) 
plt.title("histogram") 
plt.show()
```

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601092343607.png" alt="image-20200601092343607" style="zoom:67%;" />

