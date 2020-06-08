# Python 机器学习

## 绪论

### 机器学习的定义

机器学习是从人工智能中产生的一个重要学科分支，是实现智能化的关键。

![image-20200528143835739](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200528143835739.png)

### 基本概念

> 算法分类

![image-20200528150751443](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200528150751443.png)

* 有监督学习

  * 样本带有标签值，称为监督信号

    训练样本为 (**x**, y), **x**为特征向量，y为标签值

  * 有学习过程，根据训练样本学习，得到模型，然后用于预测

    机器学习模型实现从特征向量到标签值得映射 y = f(x)

  * 按照标签值得类型可以进一步分为两类

    * **分类问题 —— 标签值为整数编号**

      例如手写数字的识别：`十分类问题`

    * **回归问题 —— 标签值为实数** （例如预测一个人的收入）

  * 可以分为`生成模型`与`判别模型`

    | **类别** | **算法**                                                     |
    | -------- | :----------------------------------------------------------- |
    | 生成模型 | 贝叶斯分类器；高斯混合模型；贝叶斯网络；隐马尔可夫模型；受限玻尔兹曼机；生成对抗网络；变分自动编码器 |
    | 判别模型 | 决策树 ； KNN算法； 人工神经网络； 支持向量机； logistic回归； softmax回归；随机森林；boosting算法；条件随机场 |

---



* 无监督学习

  样本没有标签值，没有训练过程，机器学习算法直接对样本进行处理，得到某种结果

  无监督学习算法分类：

  * **聚类问题** —— 无监督分类，将一组样本划分成多个子集

  * **数据降维问题** —— 将向量映射到更低维的空间

    将n维空间中的向量 **x** 通过某种映射函数映射到更低维的m维空间中
    $$
    \boldsymbol y = \phi(\boldsymbol x)  , m\ll n
    $$
    

---



* 半监督学习（介于有监督学习与无监督学习之间）

  有些训练样本有标签值，有些没有标签值，用这些样本进行训练得到模型，然后用于预测。



---

* 强化学习

  模拟人的行为，源自于行为主义心理学，确定在每种状态下要执行的动作，以达到某种目标。



> 过拟合与欠拟合

| 训练集上的表现 | 测试集上的表现 | 结论                                                         | 原因                                                        |
| -------------- | -------------- | ------------------------------------------------------------ | ----------------------------------------------------------- |
| 不好           | 不好           | 欠拟合：也称为欠学习，指模型在训练集上的精度差               | 模型简单 特征数太少                                         |
| 好             | 不好           | 过拟合：也称为过学习，指模型在训练集上表精度高，但在测试集上精度低，泛化性能差 | 模型过于复杂 ；训练样本太少，缺乏代表性；训练样本噪声的干扰 |
| 好             | 好             | 适度拟合                                                     |                                                             |



## 机器学习涉及到的数学基础

* 导数

* 向量与矩阵

  * 向量的范数：

  $$
  \left | \left | \boldsymbol x \right | \right|_p = (\sum_{i=1}^n\left|x_i\right|^p)^{\frac{1}{p}}
  $$

  L1范数：所有分量的绝对值之和
  $$
  \left | \left | \boldsymbol x \right | \right|_1 = \sum_{i=1}^n\left|x_i\right|
  $$
  L2范数也称为向量的模，即向量的长度
  $$
  \left | \left | \boldsymbol x \right | \right|_2 = \sqrt{\sum_{i=1}^n\left|x_i\right|^2}
  $$

* 偏导与梯度

* 雅克比矩阵

* Hessian矩阵

* 泰勒公式

* 行列式

* 特征值和特征向量

* 二次型

---

* 迭代法
* 梯度下降法
* 牛顿法
* 拉格朗日乘数法
* 凸优化问题
* 拉格朗日对偶

---

概率论：

* 随机事件
* 条件概率
* 随机变量 [离散型随机变量 连续型随机变量]
* 数学期望
* 方差与标准差
* 随机向量





## 贝叶斯

* 训练数据集：模拟学习问题的输入和输出
* 决策函数集：备选决策函数集合（可行域）
* 表现度量：目标函数
* 优化算法：计算优化问题最优解
* 超参数调整：目标函数与优化算法中的超参数调整

### 最大似然估计（MLE）和最大后验估计（MAP）

* 训练数据集：模拟学习问题的输入和输出
* 决策函数集：概率模型
* 表现度量：MLE/MAP
* 优化算法：?
* 超参数调整：?



### 最大似然估计 MLE

* 训练数据集：模拟学习问题的输入和输出
* 决策函数集：p(y|x;w)
* 表现度量：

$$
\max_w{p(Y|X;w)}
$$

* 优化算法：？
* 超参数调整：？



### 贝叶斯公式

链式法则：
$$
P(X,Y) = P(X|Y)P(Y) = P(Y|X)P(X)
$$
贝叶斯规则：
$$
P(X|Y) = \frac{P(X|Y)P(X)}{P(Y)}
$$


### 最大后验估计 MAP

* 训练数据集：模拟学习问题的输入和输出
* 决策函数集：p(y|x;w)p(w)
* 表现度量：

$$
\max_w{p(Y|X;w)}p(w)
$$

* 优化算法：概率推断
* 超参数调整：？



---

## K-近邻分类 （KNN）

### 一、KNN 算法简介

* KNN（k-Nearest Neighbor），也称K-近邻分类算法。分类的目的是学会一个**分类器**。该分类器能把数据映射到事先给定类别中的某一个类别。分类属于一种**监督学习**方式，分类器的学习是在被告知每一个**训练样本**属于哪个类别后进行的。每个训练样本都有一个特定的标签，与之相对应。在学习过程中，从这些给定的训练数据集中**学习一个函数**。等新的数据到来时，可以根据这个函数判断结果。

* 监督学习的训练及要求，包括**输入**和**输出**。也可以说是既有有数据的特征，也要有对应的目标，训练集中的目标是由人们事先进行标注的。

* 通过测量不同特征值之间的距离进行分类的
* 基本思路：**如果一个样本在特征空间中的k个最邻近样本中的大多数属于某一个类别，则该样本也属于这个类别**，该算法在决定类别上只依据最近的一个或几个样本的类别来决定待分类样本所属的类别，KNN算法中所选择的**邻居**都**是已经正确分类的对象**



### 二、KNN算法大致步骤

1. 算距离：给定测试对象，计算它与训练集中的每个对象的距离；

2. 找邻居：圈定距离最近的k个训练对象，作为测试对象的近邻； 

3. 做分类：根据这k个近邻归属的**主要类别**，来对测试对象分类。



### 三、相似度度量方法

闵可夫斯基距离：
$$
假设数值点P和Q坐标为P(x_1,x_2,...,x_n)和Q(y_1,y_2,...,y_n)，则闵可夫斯基距离为：
$$

$$
(\sum_{i=1}^n|x_i-y_i|^p)^\frac{1}{p}
$$

* p = 1 曼哈顿距离
  $$
  \sum_{i=1}^n|x_i-y_i|
  $$

* p = 2 欧几里得距离
  $$
  \sqrt{\sum_{i=1}^n|x_i-y_i|^2}
  $$

* p = 趋向∞ 切比雪夫距离
  $$
  (\sum_{i=1}^n|x_i-y_i|^p)^\frac{1}{p} = \max_i|x_i-y_i|
  $$

### 四、KNN一般流程

1. 计算测试数据与各个训练数据之间的距离
2. 按照距离的递增关系进行排序
3. 选取距离最小的K个点
4. 确定最小k个点所在类别的出现频率
5. 返回前K个点中出现频率最高的类别，作为测试数据的预测分类



### 五、k的选取

k 小：分类结果容易因为噪声点的干扰而出现错误，此时方差较大

k 大：偏差过大

---

### 六、KNN算法举例

* 下方数据集中序号1-12为已知电影分类，分为喜剧片、动作片、爱情片三个种类，使用的特征值分别为搞笑镜头、打斗镜头、拥抱镜头数量。那么来了一部新电影（唐人街探案2），它属于上述电影分类中的那个类型？利用KNN是怎么做？

  ![image-20200530165605891](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200530165605891.png)

  1-12为**训练集**；13为**测试集**；喜剧片、动作片、爱情片为**标签**； 搞笑镜头、打斗镜头、拥抱镜头数量为**特征值**



* **代码：**

  ```python
  #!/usr/bin/env python
  # -*- coding: utf-8 -*-
  # @Time : 2020/5/30 22:33
  # @Author : Kai
  # @File : KnnMain.py
  # @Software: PyCharm
  
  from pandas import *
  import math
  
  # 1. 使用字典dict构造数据集
  movie_data = {
      "宝贝当家": [45, 2, 9, "喜剧片"],
      "美人鱼": [21, 17, 5, "喜剧片"],
      "澳门风云3": [54, 9, 11, "喜剧片"],
      "功夫熊猫3": [39, 0, 31, "喜剧片"],
      "谍影重重": [5, 2, 57, "动作片"],
      "叶问3": [3, 2, 57, "动作片"],
      "伦敦陷落": [2, 3, 55, "动作片"],
      "我的特工爷爷": [6, 4, 21, "动作片"],
      "奔爱": [7, 46, 4, "爱情片"],
      "夜孔雀": [9, 39, 8, "爱情片"],
      "代理情人": [9, 38, 2, "爱情片"],
      "新步步惊心": [8, 34, 17, "爱情片"]
  }
  
  # 2. 计算新样本与数据集中所有数据的距离
  # 新样本：唐人街探案[23,3,17,”?片”]
  # 欧式距离
  x = [23, 3, 17]
  KNN = []
  for key, v in movie_data.items():
      d = math.sqrt((x[0] - v[0]) ** 2 + (x[1] - v[1]) ** 2 + (x[2] - v[2]) ** 2)
      KNN.append([key, round(d, 2)])
  print(KNN)
  
  # 3. 按照距离大小进行递增排序
  KNN.sort(key = lambda dis: dis[1])
  
  # 4. 选取距离最小的k个样本, 这里k取5
  KNN = KNN[:5]
  print(KNN)
  
  # 5. 确定前k个样本所在类别出现的频率，并输出出现频率最高的类别
  labels = {"喜剧片": 0, "动作片": 0, "爱情片": 0}
  for s in KNN:
      label = movie_data[s[0]] # 按照电影名取出movie_data中的整个电影信息
      labels[label[3]] += 1
  labels = sorted(labels.items(), key = lambda l: l[1], reverse = True)
  print(labels, labels[0][0], sep='\n')
  ```
  

  
* **运行结果：**

  ```
  [['宝贝当家', 23.43], ['美人鱼', 18.55], ['澳门风云3', 32.14], ['功夫熊猫3', 21.47], ['谍影重重', 43.87], ['叶问3', 44.73], ['伦敦陷落', 43.42], ['我的特工爷爷', 17.49], ['奔爱', 47.69], ['夜孔雀', 39.66], ['代理情人', 40.57], ['新步步惊心', 34.44]]
  [['我的特工爷爷', 17.49], ['美人鱼', 18.55], ['功夫熊猫3', 21.47], ['宝贝当家', 23.43], ['澳门风云3', 32.14]]
  [('喜剧片', 4), ('动作片', 1), ('爱情片', 0)]
  喜剧片
  ```

* **运行截图：**

  ![image-20200531001828873](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200531001828873.png)



### 七、KNN经典实例 —— 约会网站

> 1. 背景

海伦女士一直使用在线约会网站寻找适合自己的约会对象。尽管约会网站会推荐不同的人选，但她并不是喜欢每一个人。经过一番总结，她发现自己交往过的人可以进行如下分类：

* 不喜欢的人

* 魅力一般的人

* 极具魅力的人

海伦收集的样本数据主要包含以下3种特征：

* 每年获得的飞行常客里程数

* 玩视频游戏所消耗时间百分比

* 每周消费的冰淇淋公升数

现在就通过这3中特征来对样本进行分类



> 2.数据预处理：规范化（归一化）

* 方法：

1. 最大-最小规范化
   $$
   假设min_A和max_A分别为属性A的最大值和最小值。最大-最小规范化通过计算：\\
   v_i^, = \frac{v_i - min_A}{max_A  - min_A}(newmax_A-newmin_A)+newmin_A\\
   把A的值v_i映射到区间newmin_A,newmax_A中的v_i'
   $$
   
2. z分数(z - score)规范化(或零均值规范化)
   $$
   属性 A的值基于 A的均值（即平均值）和标准差规范化。A的值v_{i}被规范化为v_{i}^{'}，由下式计算：\\
   v_i' = \frac{v_i - \bar{A}}{\sigma_A}\\
   其中\bar{A}和\sigma_A分别为A的均值和方差
   $$
   

* 代码

```python
#-*- coding: utf-8 -*-
#数据规范化
import pandas as pd
import numpy as np
 
datafile = '../data/normalization_data.xls' #参数初始化
data = pd.read_excel(datafile, header = None) #读取数据
 
(data - data.min())/(data.max() - data.min()) #最小-最大规范化
(data - data.mean())/data.std() #零-均值规范化
```



> 3. “约会网站”代码

```python
#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/5/31 11:25
# @Author : Kai
# @File : KnnAppointmentWebsite.py
# @Software: PyCharm

from numpy import *
import operator

# 1. 读取数据 处理数据 返回特征值列表和结果列表
# returnMat 返回特征值列表
# classLabelVector 返回的结果(标签)列表
def file2matrix(filename):
    fr = open(filename)
    content = fr.readlines()
    numberOfLines = len(content)
    returnMat = zeros((numberOfLines, 3))
    classLabelVector = []
    index = 0
    for line in content:
        line = line.strip()
        listFromLine = line.split('\t')
        returnMat[index, :] = listFromLine[0:3]
        classLabelVector.append(int(listFromLine[-1]))
        index += 1
    return returnMat, classLabelVector

# 2. 归一化数值 使用了最大-最小规范化
def autoNorm(dataSet):
    minVals = dataSet.min(0) #返回dataSet矩阵中所有列中元素的最小值[0.,0.,0.001156]
    maxVals = dataSet.max(0)
    ranges = maxVals - minVals
    m = dataSet.shape[0] # 读取矩阵的长度
    normDataSet = dataSet - tile(minVals, (m, 1))
    normDataSet = normDataSet / tile(ranges, (m, 1))
    return normDataSet, ranges, minVals


# 3. KNN分类器
# now 测试数据
# dataSet 训练集
# labels 训练集的标签（结果）
# k KNN参数k
def KNN_classify(now, dataSet, labels, k):
    dataSetSize = dataSet.shape[0]
    n = tile(now, (dataSetSize, 1))
    DiffMat = n - dataSet
    sqDiffMat = DiffMat ** 2
    sqDistances = sqDiffMat.sum(axis=1)
    distances = sqDistances ** 0.5  # 到这里求解了欧式距离(并构成了一个ndarray)

    sortedDistances = distances.argsort()  # 根据排名作为索引 Index
    classCount = {}
    for i in range(k):
        voteIlabel = labels[sortedDistances[i]]
        classCount[voteIlabel] = classCount.get(voteIlabel, 0) + 1
    # 选出了距离最小的k个点，并且做了一个简单的统计

    sortedClassCount = sorted(classCount.items(), key=operator.itemgetter(1), reverse=True)  # 按照第一个(从0开始数)进行排序
    return sortedClassCount[0][0]  # 返回的出现次数最多的那个标签

# 4. 验证分类器，使用10%的数据作为测试集  后90%作为训练集
def datingClassTest():
    # 测试集的比例10%
    hoRatio = 0.1
    datingDataMat, datingLabels = file2matrix("datingTestSet2.txt")
    normMat, ranges, minVals = autoNorm(datingDataMat)
    m = normMat.shape[0]
    numTestVecs = int(m * hoRatio)
    errorCount = 0.0
    for i in range(numTestVecs):
        now = normMat[i, :]
        dataSet = normMat[numTestVecs:m, :]
        labels = datingLabels[numTestVecs:m]
        k = 3
        classifierResult = KNN_classify(now, dataSet, labels, k)
        print("分类器预测结果:%d，正确结果是:%d" % (classifierResult, datingLabels[i]))
        if (classifierResult != datingLabels[i]): errorCount += 1.0
    print("错误率%f" % (errorCount / float(numTestVecs)))

# 5. 给出一个人的三种特征信息并进行预测
def classifyPerson(x1, x2, x3):
    resultList = ['不喜欢的人', '魅力一般的人', '极具魅力的人']
    datingDataMat, datingLabels = file2matrix("datingTestSet2.txt")
    normMat, ranges, minVals = autoNorm(datingDataMat)
    now = array([x1, x2, x3])
    # 将预测值归一化
    now = (now - minVals) / ranges
    k = 3
    classifierResult = KNN_classify(now, normMat, datingLabels, k)
    print("结果:", resultList[classifierResult - 1])

# 测试
# print("--------验证分类器--------")
# datingClassTest()

# 预测
print("--------按照特征预测--------")
classifyPerson(33338, 10, 0.5)

# 可视化
# datingDataMat, datingLabels = file2matrix("datingTestSet2.txt")
# fig = plt.figure()
# plt.rcParams['font.family']=['STFangsong']
# plt.figure(figsize=(8, 5), dpi=80)
# ax = plt.subplot(111)
#
# datingLabels = array(datingLabels)
# idx_1 = where(datingLabels==1)
# p1 = ax.scatter(datingDataMat[idx_1,0],datingDataMat[idx_1,1],marker = '*',color = 'r',label='1',s=10)
# idx_2 = where(datingLabels==2)
# p2 = ax.scatter(datingDataMat[idx_2,0],datingDataMat[idx_2,1],marker = 'o',color ='g',label='2',s=20)
# idx_3 = where(datingLabels==3)
# p3 = ax.scatter(datingDataMat[idx_3,0],datingDataMat[idx_3,1],marker = '+',color ='b',label='3',s=30)
#
# plt.xlabel(u'每年获取的飞行里程数')
# plt.ylabel(u'玩视频游戏所消耗的事件百分比')
# ax.legend((p1, p2, p3), ('不喜欢', '魅力一般', '极具魅力'), loc=2)
# plt.show()
```



> 4.分类结果可视化	

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601093719702.png" alt="image-20200601093719702" style="zoom:67%;" />

* 根据数据中的分类进行可视化 (数据中第四列为标签)

  选择属性`每年获取的飞行里程数`和`玩视频游戏所消耗的事件百分比`进行可视化

代码：

```python
# 可视化
datingDataMat, datingLabels = file2matrix("datingTestSet2.txt")
fig = plt.figure()
plt.rcParams['font.family']=['STFangsong']
plt.figure(figsize=(8, 5), dpi=80)
ax = plt.subplot(111)

datingLabels = array(datingLabels)
idx_1 = where(datingLabels==1)
p1 = ax.scatter(datingDataMat[idx_1,0],datingDataMat[idx_1,1],marker = '*',color = 'r',label='1',s=10)
idx_2 = where(datingLabels==2)
p2 = ax.scatter(datingDataMat[idx_2,0],datingDataMat[idx_2,1],marker = 'o',color ='g',label='2',s=20)
idx_3 = where(datingLabels==3)
p3 = ax.scatter(datingDataMat[idx_3,0],datingDataMat[idx_3,1],marker = '+',color ='b',label='3',s=30)

plt.xlabel(u'每年获取的飞行里程数')
plt.ylabel(u'玩视频游戏所消耗的事件百分比')
ax.legend((p1, p2, p3), ('不喜欢', '魅力一般', '极具魅力'), loc=2)
plt.show()
```

* 运行截图

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601101950334.png" alt="image-20200601101950334" style="zoom:67%;" />



> 5.“预测”运行截图

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601092747272.png" alt="image-20200601092747272" style="zoom:67%;" />



> 6.“测试”运行截图

使用了“**留出法(hold-out)**”将数据集D划分为两个集合

前10%为**测试集**

后90%为**训练集**

```python
# 测试
print("--------验证分类器--------")
datingClassTest()
```

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601092845478.png" alt="image-20200601092845478" style="zoom: 67%;" />![image-20200601092951980](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601092951980.png)



> 7.以上`测试运行截图`中的k值为3 按照测试集10% 训练集90%的比例进行测试错误率
>
> ​	现选择不同的k测试错误率

| k值  | 错误率 |
| :--: | :----: |
|  3   |  0.05  |
|  4   |  0.04  |
|  5   |  0.05  |
|  10  |  0.06  |
|  15  |  0.06  |
|  20  |  0.06  |
|  50  |  0.07  |
| 100  |  0.07  |



> 8.以上测试均为规范化后的测试，现去除规范化的步骤，再次进行测试

* 修改验证分类器代码：

```python
# 4. 验证分类器，使用10%的数据作为测试集  后90%作为训练集
def datingClassTest():
    # 测试集的比例10%
    hoRatio = 0.1
    datingDataMat, datingLabels = file2matrix("datingTestSet2.txt")
    m = datingDataMat.shape[0]
    numTestVecs = int(m * hoRatio)
    errorCount = 0.0
    for i in range(numTestVecs):
        now = datingDataMat[i, :]
        dataSet = datingDataMat[numTestVecs:m, :]
        labels = datingLabels[numTestVecs:m]
        k = 3
        classifierResult = KNN_classify(now, dataSet, labels, k)
        print("分类器预测结果:%d，正确结果是:%d" % (classifierResult, datingLabels[i]))
        if (classifierResult != datingLabels[i]): errorCount += 1.0
    print("错误率%f" % (errorCount / float(numTestVecs)))
```

* 运行截图：

![image-20200601094558201](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601094558201.png)

* 现选择不同的k对**未规范化的KNN分类器**测试错误率

  | k值  | 错误率 |
  | :--: | :----: |
  |  3   |  0.24  |
  |  4   |  0.20  |
  |  5   |  0.27  |
  |  10  |  0.24  |
  |  15  |  0.23  |
  |  20  |  0.22  |
  |  50  |  0.24  |
  | 100  |  0.24  |

  可以明显看出，未进行数据规范化的分类器的错误率明显大于数据规范化后的错误率。



## 决策树

​	决策树是一种有监督的分类方法，它是用已有的数据构造出一棵树，用这棵树，对新的数据进行预测



### 树形决策过程

> 举例

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601185628888.png" alt="image-20200601185628888" style="zoom:67%;" />

1. 决策之前，先获取客户的两个指标-**年收入**，**是否有房产**，形成**特征向量**
2. 从树的根节点开始，在内部节点处需要做判断，直到到达一个**叶子节点**处，得到**决策结果**



* 特征：有`数值型特征`和`类别型特征`
* 节点：
  * 内部节点-对应判定规则
  * 叶子节点-对应预测结果



### 决策树构造过程

1. 特征选择：特征选择是指从训练数据中众多的特征中选择一个特征作为当前节点的**分裂标准**
2. 决策树生成：根据选择的特征评估标准，从上至下递归地生成子节点，**直到数据集不可分则决策树停止生长。**
3. 剪枝：决策树容易**过拟合**，一般来需要剪枝，缩小树结构规模、缓解过拟合。剪枝技术有**预剪枝**和**后剪枝**两种。



根据**特征选择的准则**可将决策树分类：

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200601191149896.png" alt="image-20200601191149896" style="zoom:67%;" />

> 1. 树节点属性的选取

* 信息增益

  **信息熵**：是度量样本集合“纯度”最常用的一种指标
  $$
  假设当前样本集合D中第k类样本所占的比例为p_i,则D的信息熵为:\\
  Ent(D)=-\sum_{k=1}^n{p_ilnp_i} = -\sum_{k=1}^n\frac{|C_k|}{|D|}log_2\frac{|C_k|}{|D|}\\
  n表示样本标签值的取值状态数\\
  C_k表示D中所标注值为k的训练样本组成的集合\\
  |D|和|C_k|分别表示集合D和C_k的基数
  $$
  H(D)值越大，D中包含样本标签的取值越杂乱，越小则越纯净

  **信息增益**：（ID3）
  $$
  离散属性\boldsymbol{a}的取值：\{a^1, a^2, ...,a^V\},D^v是D中在a上取值a^v的样本集合\\
  以属性a对数据集D进行划分所获得的信息增益为：\\
  Gain(D,a)=Ent(D) - \sum_{v=1}^V{\frac{|D^v|}{|D|}Ent(D^v)}\\
  $$

  ---

  $$
  Ent(D)为划分前的信息熵\\
  \sum_{v=1}^V{\frac{|D^v|}{|D|}Ent(D^v)}为划分后的信息熵
  $$

  

>2. 决策树构造过程

* 策略：分而治之； 自根至叶的过程； 在每个中间节点找一个“划分”的属性

* 三种停止条件：

  当前结点包含的样本全属于同一类别，无需划分;
  当前属性集为空, 或是所有样本在所有属性上取值相同，无法划分;
  当前结点包含的样本集合为空，不能划分.

  

>3. 不同的树节点选择标准

* **增益率**（C4.5）
  $$
  Gain\_ratio(D,a) = \frac{Gain(D,a)}{IV(a)}
  $$

  ---

  $$
  其中惩罚参数：IV(a)=-\sum_{v=1}^V{\frac{|D^v|}{|D|}}log_2\frac{|D^v|}{|D|}\\
  属性a的可能取值数目越多(V的值越大)，IV(a)的值越大
  $$

  

* **]基尼指数**（CART）
  $$
  对于任意给定的一个m分类问题，假设样本点属于第k类的概率为p_k，\\
  则关于这个概率分布p的基尼指数定义为：\\
  Gini(p)=\sum_{k=1}^m{p_k(1-p_k)}=1-\sum_{k=1}^m{p_k^2}
  $$
  

> 4. 树模型简化

剪枝可去掉一些分支来降低过拟合的风险

* 基本策略

  | 剪枝策略      | 预剪枝                             | 后剪枝                             |
  | ------------- | ---------------------------------- | ---------------------------------- |
  | 方式          | 提前终止某些分支的生长             | 生成一棵完全树，再“回头”剪枝       |
  | 时间开销      | 训练时间开销降低，测试时间开销降低 | 训练时间开销增加，测试时间开销降低 |
  | 过/欠拟合风险 | 过拟合风险降低，欠拟合风险增加     | 过拟合风险降低，欠拟合风险增加     |



### 使用决策树完成对iris数据的分类

> 1. iris数据集描述

* 特征数据：

  ```python
  [[5.1 3.5 1.4 0.2]
   [4.9 3.  1.4 0.2]
   [4.7 3.2 1.3 0.2]
   [4.6 3.1 1.5 0.2]
   [5.  3.6 1.4 0.2]
   [5.4 3.9 1.7 0.4]
   [4.6 3.4 1.4 0.3]
   [5.  3.4 1.5 0.2]
   [4.4 2.9 1.4 0.2]
   [4.9 3.1 1.5 0.1]
   ...
   [5.9 3.  5.1 1.8]]
  ```

  4个特征名称：

  ```python
  ['sepal length (cm)', 'sepal width (cm)', 'petal length (cm)', 'petal width (cm)']
  ```

* 类数据：

  [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
   0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
   1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2
   2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
   2 2]

  3个类的名称：

  ```python
  ['setosa' 'versicolor' 'virginica']
  ```

* 可视化数据集

  代码：

  ```python
  #!/usr/bin/env python
  # -*- coding: utf-8 -*-
  # @Time : 2020/6/2 11:13
  # @Author : Kai
  # @File : 可视化数据集.py
  # @Software: PyCharm
  
  from matplotlib import pyplot as plt
  from sklearn.datasets import load_iris
  
  if __name__ == '__main__':
      # show data info
      data = load_iris() # 加载 IRIS 数据集
      feature_names = data.get('feature_names')
      x = data.get('data') # 获取样本矩阵
      y = data.get('target') # 获取与样本对应的 label 向量
  
      f = []
      f.append(y == 0)  # 类别为第一类的样本的逻辑索引 若为第一类则为true,否则false
      f.append(y == 1)  # 类别为第二类的样本的逻辑索引
      f.append(y == 2)  # 类别为第三类的样本的逻辑索引
  
      color = ['red', 'blue', 'green']
      fig, axes = plt.subplots(4, 4)  # 绘制四个属性两辆之间的散点图
      for i, ax in enumerate(axes.flat):
          row = i // 4
          col = i % 4
          if row == col:
              ax.text(.1, .5, feature_names[row])
              ax.set_xticks([])
              ax.set_yticks([])
              continue
          for k in range(3):
              ax.scatter(x[f[k], row], x[f[k], col], c=color[k], s=3)
      fig.subplots_adjust(hspace=0.3, wspace=0.3)  # 设置间距
      plt.show()
  ```

  运行截图：

  ![image-20200602131704098](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602131704098.png)



> 2. 使用ID3的特征选择策略

* 整体代码：

```python
#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/2 9:39
# @Author : Kai
# @File : ID3.py
# @Software: PyCharm

# 数据集
from sklearn import datasets
# 分类器
from sklearn import tree
# 训练集测试集分割模块
from sklearn.model_selection import train_test_split
# 绘制决策树
import graphviz
from sklearn import metrics

# 自定义导入数据集函数
def get_data(total_data):
    # 显示total_data包含的内容
    # print("传入数据集包含内容有：", [x for x in total_data.keys()])

    # 样本
    x_true = total_data.data
    # 标签
    y_true = total_data.target
    # 特征名称 -> ['sepal length (cm)', 'sepal width (cm)', 'petal length (cm)', 'petal width (cm)']
    feature_names = total_data.feature_names
    # 类名 -> ['setosa' 'versicolor' 'virginica']
    target_names = total_data.target_names
    return x_true, y_true, feature_names, target_names

# 定义主函数
def main():
    # 利用自定义函数导入Iris数据集
    total_iris = datasets.load_iris()
    x_true, y_true, feature_names, target_names = get_data(total_iris)

    # 分割数据集 “留出法”测试
    rate_test = 0.2  # 训练集比例
    x_train, x_test, y_train, y_test = train_test_split(x_true,y_true,test_size=rate_test)
    print("训练集样本大小：", x_train.shape)
    print("训练集标签大小：", y_train.shape)
    print("测试集样本大小：", x_test.shape)
    print("测试集标签大小：", y_test.shape)

    # 设置决策树分类器 ID3
    clf = tree.DecisionTreeClassifier(criterion="entropy")
    # 训练模型
    clf.fit(x_train, y_train)

    #1. 预测 输出属于哪一类
    print("\n给定提供的属性值根据训练模型预测结果：")
    category = clf.predict([[5, 1.5, 2, 3]])
    category_name = target_names[category]
    print("类别%d, 类名%s" % (category, category_name))


    #2. 评价模型：准确率、召回率、f1-score、精度
    score = clf.score(x_test, y_test)
    print("\n模型测试集准确率为：", score)

    y_predict = clf.predict(x_test)
    result = metrics.classification_report(y_test, y_predict, target_names=target_names)
    print(result)


    #3. 绘制决策树模型
    clf_dot = tree.export_graphviz(clf,
                                   out_file=None,
                                   feature_names=feature_names,
                                   class_names=target_names,
                                   filled=True,
                                   rounded=True)
    # 显示绘制的模型，在当前目录下，保存为png模式
    graph = graphviz.Source(clf_dot,
                            filename="iris_decisionTree.gv",
                            format="png")
    graph.view()

    # 显示特征重要程度
    print("\n特征重要程度为：")
    info = [*zip(feature_names, clf.feature_importances_)]
    for cell in info:
        print(cell)


# 调用主函数
if __name__ == "__main__":
    main()
```

* 运行截图：

  因使用“**留出法**”对数据进行测试时训练集和测试集的数据是随机分的，所以运行数据每次不同

![image-20200602135101711](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602135101711.png)

![image-20200602135146768](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602135146768.png)

* ID3决策树可视化：

  数据集中有120条数据用于构造此决策树

  <img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602135508571.png" alt="image-20200602135508571" style="zoom:67%;" />

* 关键代码：

```python
#1. 预测 输出属于哪一类
print("\n给定提供的属性值根据训练模型预测结果：")
category = clf.predict([[5, 1.5, 2, 3]])
category_name = target_names[category]
print("类别%d, 类名%s" % (category, category_name))

-------输出结果------
给定提供的属性值根据训练模型预测结果：
类别0, 类名['setosa']
```

```python
#2. 评价模型：准确率、召回率、f1-score、精度
score = clf.score(x_test, y_test)
print("\n模型测试集准确率为：", score)

y_predict = clf.predict(x_test)
result = metrics.classification_report(y_test, y_predict, target_names=target_names)
print(result)

------输出结果------
模型测试集准确率为： 0.8666666666666667
              precision    recall  f1-score   support

      setosa       1.00      1.00      1.00        12
  versicolor       1.00      0.71      0.83        14
   virginica       0.50      1.00      0.67         4

    accuracy                           0.87        30
   macro avg       0.83      0.90      0.83        30
weighted avg       0.93      0.87      0.88        30
```

```python
#3. 绘制决策树模型
clf_dot = tree.export_graphviz(clf,
                               out_file=None,
                               feature_names=feature_names,
                               class_names=target_names,
                               filled=True,
                               rounded=True)
# 显示绘制的模型，在当前目录下，保存为png模式
graph = graphviz.Source(clf_dot,
                        filename="iris_decisionTree.gv",
                        format="png")
graph.view()

# 输出：决策树可视化png图片
```



> 3. 使用CART的特征选择策略

* 修改`DecisionTreeClassifier`的参数

使用ID3的特征选择策略为：`clf = tree.DecisionTreeClassifier(criterion="entropy")`

使用CART的特征选择策略改为：`clf = tree.DecisionTreeClassifier(criterion='gini')`

* 改动后的代码截图

  ![image-20200602144551317](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602144551317.png)

* 运行截图

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602145215343.png" alt="image-20200602145215343" style="zoom:80%;" />

* 生成的决策树可视化

  因使用“**留出法**”对数据进行测试时训练集和测试集的数据是随机分的，所以生成的决策树会有不同

  * 决策树1

    <img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602144858402.png" alt="image-20200602144858402" style="zoom:67%;" />

  * 决策树2

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200602145001587.png" alt="image-20200602145001587" style="zoom:67%;" />

### 随机森林

* BootStrap采样
* 集成学习
  * Bagging
  * Boosting（Bagging改进） 更专注被分类错误的样本

---

## SVM支持向量机（support vector machine）

2012年以前SVM占主流、占统治地位，2012年之后Deep Learning主流，效果好于SVM

Machine Learning 最难的一块 —— SVM

### 一、线性可分支持向量机

> (1). 基本概念

* `输入`：假设特征空间上的训练数据集
$$
T=\{(x_1,y_1),(x_2,y_2),···,(x_N,y_N)\} \\
  x_i \in \boldsymbol{X} = \boldsymbol R^n, y_i \in \boldsymbol{Y}={+1, -1}, i = 1,2,3,4,...,N \\
$$

* 正例和负例

* 学习的目标：找到分类超平面和决策函数

* `输出1`：线性可分支持向量机：给定线性可分训练数据集，通过间隔最大化或等价地求解相应的凸二次规划问题学习得到的分离超平面为
  $$
  w^* \boldsymbol·x + b^* = 0
  $$

* `输出2`：决策函数：
  $$
  f(x) = sign(w^* \boldsymbol·x + b^* )
  $$

* `求解`：构造并求解约束最优化问题
  $$
  min_{w,b} = \frac{1}{2}||w||^2 \\
  s.t. y_i(w·x + b) - 1 \geq 0 , i = 1,2,..., N \\
  求得w^*和b^*
  $$
  

**硬间隔最大化**：分类直线离支持向量的距离是最远的

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200607154159749.png" alt="image-20200607154159749" style="zoom:67%;" />

> (2). 点到超平面的距离

$$
点\boldsymbol{x}_0到超平面S:\boldsymbol{w}·\boldsymbol{x} + b = 0 的距离d为：\\
d = \frac{1}{||\boldsymbol{w}||}|\boldsymbol{w}·\boldsymbol{x}_0 + b|\\
$$



> (3). 函数间隔和几何间隔

$$
点到分离超平面的距离 |\boldsymbol{w}·\boldsymbol{x}_0 + b|表示分类预测的确信程度\\
\boldsymbol{w}·\boldsymbol{x}_0 + b的符号与类标记y的符号是否一致表示分类是否正确\\
y(\boldsymbol{w}·\boldsymbol{x}_0 + b)表示分类的正确性和确信度
$$

* 函数间隔

  * 样本点的函数间隔

  $$
  \hat{r_i} = y_i(w·x_i + b)
  $$

  * 训练数据集的函数间隔
    $$
    \hat{r} = \min_{i=1,2,...,N}\hat{r_i}
    $$

* 几何间隔

  * 样本点的几何距离
    $$
    r_i = y_i(\frac{w}{||w||}·x + \frac{b}{||w||})
    $$

  * 训练数据集的几何间隔
    $$
    r = \min_{i=1,2,...,N}{r_i}
    $$

* 函数间隔和几何间隔的关系
  $$
  r_i  = \frac{\hat{r_i}}{||w||}
  $$

> (4). 支持向量和Margins(边界)

**支持向量**：在线性可分情况下，训练数据集的样本点中与分离超平面距离最近的样本点的实例称为支持向量(support vector)



> (5). 线性可分支持向量机学习算法

输入：线性可分训练数据集
$$
T=\{(x_1,y_1),(x_2,y_2),···,(x_N,y_N)\} \\
  x_i \in \boldsymbol{X} = \boldsymbol R^n, y_i \in \boldsymbol{Y}={+1, -1}, i = 1,2,3,4,...,N \\
$$
输出：最大间隔分离超平面和分类决策函数

1. 构造并求解约束最优化问题
   $$
   \min_{\alpha} \ \ \frac{1}{2}\sum_{i = 1}^N\sum_{j = 1}^N\alpha_i\alpha_jy_iy_j(x_i·x_j) - \sum_{i = 1}^N\alpha_i \\
   s.t. \ \ \sum_{i = 1}^N\alpha_iy_i = 0 \\
   \alpha_i \ge 0, i = 1,2,3,...,N\\
   求得最优解: \alpha^* = (\alpha_1^*, \alpha_2^*, ...,\alpha_N^*)^T
   $$

2. 计算
   $$
   w^*  = \sum_{i = 1}^N \alpha_i^*y_ix_i \\
   并选择\alpha^*的一个正分量\alpha_j^* > 0, 计算 \\
   b^* = y_j - \sum_{i = 1}^N\alpha_i^*y_i(x_i·x_j)
   $$

3. 求得分离超平面
   $$
   w^*·x + b ^*  = 0 \\
   $$
   分类决策函数
   $$
   f(x) = sign(w^*·x + b ^*)
   $$

### 二、线性不可分支持向量机

> 线性支持向量机与软间隔最大化

* 训练数据中有一些特异点（outlier），不能满足函数间隔大于等于1的约束条件。

* 解决方法：
  $$
  对每个样本点(X_i,y_i), \xi_i \ge0引进一个松弛变量
  $$

* 使得函数间隔加上松弛变量大于等于1，约束条件变为：
  $$
  y_i(w^*·x + b ^*) \ge 1-\xi_i
  $$
  目标函数变为：
  $$
  \frac{1}{2}||w||^2 + C\sum_{j = 1}^N\xi_i \\
  C>0 为惩罚函数
  $$



### 三、非线性支持向量机与核函数

* 如果如果能用Rn中的一个**超曲面**将正负例正确分开，则称这个问题为**非线性可分问题**.
* **非线性变换**，将非线性问题变换为线性问题，通过变换后的线性问题的方法求解原来的非线性问题。

* 用线性分类方法求解非线性分类问题分为两步:
  首先使用一个变换将**原空间**的数据映射到**新空间**;
  然后在新空间里用**线性分类学习方法**从训练数据中学习分类模型。
  $$
  原空间：\chi \subset R^2, x = (x^{(1)}, x^{(2)})^T \in \chi \ \ \ \ \ \ \ \ z = \phi(x)= (x^{(1)}, x^{(2)})^T\\
  新空间：w_1(x^{(1)})^2 + w_2(x^{(2)})^2 + b = 0 \ \ \ \ w_1z^{(1)} + w_2z^{(2)} + b = 0
  $$
  

> 核函数

设X是输入空间(欧氏空间Rn的子集或离散集合)，又设H为特征空间(希尔伯特空间)，如果存在一个从X到H的映射
$$
\phi(x): \chi -> H \\
使得对所有x,z \in \chi \\
函数K(x,z)满足条件 K(x,z) = \phi(x)·\phi(z) \\
K(x,z)为核函数 \ \ \ \ \phi(x)为映射函数  \ \ \  \phi(x)·\phi(z)为\phi(x)和\phi(z)的内积
$$
