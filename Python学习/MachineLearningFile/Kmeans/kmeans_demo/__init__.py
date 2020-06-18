#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/10 11:04
# @Author : Kai
# @File : __init__.py.py
# @Software: PyCharm

import numpy as np
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
from sklearn import preprocessing
from scipy.spatial.distance import cdist
from sklearn import metrics
from sklearn.cluster import DBSCAN
# 读取数据
def loadData():
    data = []
    fr = open('KmeansDataset.data','r', encoding='UTF-8')
    # 选择竞争价值和估价两个属性
    for data_i in fr:
        data.append([float(data_i.split()[3]), float(data_i.split()[4])])

    data = np.array(data)

    # 数据规范化
    min_max_scaler = preprocessing.MinMaxScaler()
    data = min_max_scaler.fit_transform(data)
    # print(data)
    return data

# 聚类 并可视化聚类结果
def Kmeans():
    data = loadData()
    # 类簇的数量
    n_clusters = 4
    # 调用Kmeans聚类
    cls = KMeans(n_clusters).fit(data)
    # 输出X中每项所属分类的一个列表
    print("样本所属分类：",cls.labels_)

    # 可视化
    markers = ['*', 'o', '+', 's', 'v', '8']
    cl = ['b', 'g', 'r', 'c', 'm', 'y', 'k']
    centers = cls.cluster_centers_  # 各类别中心
    print("聚类中心：", centers)
    for i in range(n_clusters):
        members = cls.labels_ == i  # members是布尔数组 表示是否是此i类的
        plt.scatter(data[members, 0], data[members, 1], s=60, marker=markers[i], c=cl[i], alpha=0.5)  # 画与menbers数组中匹配的点
        plt.plot(centers[i][0], centers[i][1], '*', markerfacecolor=cl[i], markeredgecolor='k', markersize=6) # 画出聚类中心

    plt.title('Kmeans from Zth_Kai')
    plt.show()

# 肘方法选择最优的K值
def try_K():
    X = loadData()
    K = range(1, 10)
    meandistortions = []
    for k in K:
        kmeans = KMeans(n_clusters=k)
        kmeans.fit(X)
        meandistortions.append(sum(np.min(cdist(X, kmeans.cluster_centers_, 'euclidean'), axis=1)) / X.shape[0])
    plt.plot(K, meandistortions, 'bx-')
    plt.xlabel('k')
    plt.ylabel('meandistortions')
    plt.title('best K of the model');
    plt.show()

# 用平均轮廓系数分析聚类效果
def showClusteringEffect():
    X = loadData()
    cls = KMeans(4).fit(X)
    y_pre = cls.predict(X)
    silhouette_s = metrics.silhouette_score(X, y_pre, metric='euclidean')  # 平均轮廓系数
    print("平均轮廓系数", silhouette_s)


def myDbscan():
    X = loadData()
    print(X.shape)

    dbscan = DBSCAN(eps=0.05, min_samples=20)
    dbscan.fit(X)

    label_pred = dbscan.labels_
    print(label_pred)
    x0 = X[label_pred == 0]
    x1 = X[label_pred == -1]
    plt.scatter(x0[:, 0], x0[:, 1], c="red", marker='o', label='label0')
    plt.scatter(x1[:, 0], x1[:, 1], c="green", marker='o', label='label1')
    plt.show()

if __name__ == "__main__":
    # try_K()
    # Kmeans()
    # showClusteringEffect()
    myDbscan()
