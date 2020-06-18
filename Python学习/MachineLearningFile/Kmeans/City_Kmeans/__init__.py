#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/10 11:08
# @Author : Kai
# @File : __init__.py.py
# @Software: PyCharm
# 以下是根据中国城市的经纬度进行聚类分析案列：
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

# 读取原始数据
X = []
f = open('City.txt','r', encoding='UTF-8')

for v in f:
    X.append([float(v.split()[2][2:6]), float(v.split()[3][2:8])])

# 转化为numpy array
X = np.array(X)
print(X)

# 类簇的数量
n_clusters = 5

# 开始调用函数聚类
cls = KMeans(n_clusters).fit(X)

# 输出X中每项所属分类的一个列表
print(cls.labels_)

# 画图
markers = ['*', 'o', '+', 's', 'v']
cl = ['b', 'g', 'r', 'c', 'm', 'y', 'k']

for i in range(n_clusters):
    members = cls.labels_ == i  # members是布尔数组
    # array([False, False, False, False, False, False, False, False, False,
    #    False, False, False, False, False, False, False, False, False,
    #    False, False,  True, False, False, False, False, False, False,
    #    False,  True,  True,  True,  True, False, False,  True,  True,
    #     True, False,  True, False,  True,  True,  True,  True,  True,
    #     True, False, False, False, False,  True,  True,  True, False,
    #    False, False, False,  True,  True,  True,  True,  True,  True,
    #    ...])
    plt.scatter(X[members, 0], X[members, 1], s=60, marker=markers[i], c=cl[i], alpha=0.5)  # 画与menbers数组中匹配的点

plt.title('China')
plt.show()
print(X)
