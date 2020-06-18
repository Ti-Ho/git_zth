#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/10 11:13
# @Author : Kai
# @File : __init__.py.py
# @Software: PyCharm


import matplotlib.pyplot as plt
from sklearn.cluster import KMeans
import pandas as pd

beer = pd.read_csv("./beer_data.txt", sep=" ")
beer.head()

X = beer.iloc[:, 1:]  # ["calories","sodium","alcohol","cost"]
# K-Means聚类
km2 = KMeans(n_clusters=2).fit(X)  # 取值k=2
km3 = KMeans(n_clusters=3).fit(X)  # 取值k=3

print("当k=2时聚类结果:", km2.labels_)
print("当k=3时聚类结果:", km3.labels_)

# 当k=2时聚类结果: [0 0 0 0 0 0 0 0 1 1 0 1 0 0 0 1 0 0 1 1]
# 当k=3时聚类结果: [0 0 0 0 0 0 0 0 2 2 0 2 0 0 0 1 0 0 1 2]

beer["cluster2"] = km2.labels_
beer["cluster3"] = km3.labels_
beer.sort_values("cluster3")  # 按某一列排序，默认升序  axis =0


centers = beer.groupby("cluster3").mean().reset_index()
print(centers)

# 图形化展示聚类效果(k=3)
from pandas import scatter_matrix
import matplotlib.pyplot as plt
import numpy as np

plt.rcParams['font.size'] = 14
colors = np.array(['red', 'green', 'blue', 'yellow'])
plt.scatter(beer["calories"], beer["alcohol"], c=colors[beer["cluster3"]])

plt.scatter(centers.calories, centers.alcohol, linewidths=3, marker='+', s=300, c='black')

plt.xlabel("Calories")
plt.ylabel("Alcohol")
plt.show()

scatter_matrix(beer[["calories","sodium","alcohol","cost"]],
               s=100,
               alpha=1,
               c=colors[beer["cluster3"]],
               figsize=(10,10))
plt.suptitle("With 3 centroids initialized")
plt.show()