#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/8 18:23
# @Author : Kai
# @File : 二分类.py
# @Software: PyCharm

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn import metrics


def my_svm():
    #1. 数据预处理
    data = pd.read_table(r'./testSet.txt', header=None, delim_whitespace=True)

    X = np.array(data.loc[:][[0, 1]])  # 特征值
    Y = np.array(data[2]) # 标签
    Y = np.where(Y == 1, 1, -1) # 标签分为正例和负例

    #2. 预测
    x_train, x_test, y_train, y_test = train_test_split(X, Y, test_size=0.3)
    print("训练集样本大小：", x_train.shape)
    print("训练集标签大小：", y_train.shape)
    print("测试集样本大小：", x_test.shape)
    print("测试集标签大小：", y_test.shape)
    svm_model = SVC(kernel="linear", C = 5)
    svm_model.fit(X, Y)
    score = svm_model.score(x_test, y_test)
    print("\n模型测试集准确率为：", score)

    # 评价模型：准确率、召回率、f1-score、精度
    y_predict = svm_model.predict(x_test)
    result = metrics.classification_report(y_test, y_predict)
    # print(result)

    # 单个预测
    # pre_result = svm_model.predict([[1.25, 0.26]])
    # print(pre_result)

    #3. 选择三种不同的核方法训练SVM并进行可视化
    #   linear:线性核函数
    #   poly:多项式核函数
    #   rbf: 高斯核函数
    x_min = X[:, 0].min()
    x_max = X[:, 0].max()
    y_min = X[:, 1].min()
    y_max = X[:, 1].max()
    plt.figure(figsize=(15, 15))
    for fig_num, kernel in enumerate(('linear', 'poly', 'rbf')):
        # 训练SVM
        svm_ = SVC(kernel=kernel, C = 5)
        svm_.fit(X, Y)

        # # 输出支持向量
        # print("%s_SVM支持向量个数：%d" % (kernel, len(svm_.support_vectors_)))
        # print(svm_.support_vectors_)

        # 可视化
        plt.subplot(222 + fig_num)
        plt.scatter(x = X[Y == 1, 0], y = X[Y == 1, 1],
                    s = 30, marker = 'o', color = 'yellow', zorder = 10)
        plt.scatter(x = X[Y == -1, 0], y = X[Y == -1, 1],
                    s = 30, marker = 'x', color = 'blue', zorder = 10)
        plt.scatter(x = [x[0] for x in svm_.support_vectors_], y = [x[1] for x in svm_.support_vectors_], s = 80, facecolors='none', zorder = 10)
        plt.title(kernel)
        plt.xlabel('support vectors ' + str(len(svm_.support_vectors_)))
        print(len(svm_.support_vectors_))
        plt.xticks([])
        plt.yticks([])
        plt.xlim(x_min, x_max)
        plt.ylim(y_min, y_max)
        XX, YY = np.mgrid[x_min:x_max:200j, y_min:y_max:200j]
        Z = svm_.decision_function(np.c_[XX.ravel(), YY.ravel()])
        Z = Z.reshape(XX.shape)
        plt.pcolormesh(XX, YY, Z > 0, cmap=plt.cm.Paired)
        plt.contour(XX, YY, Z, colors=['black', 'k', 'white'], linestyles=['--', '-', '--'], levels=[-.5, 0, .5])

    # plot data
    plt.subplot(221)
    plt.title('data')
    plt.scatter(x=X[Y == 1, 0], y=X[Y == 1, 1],
                s=30, marker='o', color='red', zorder=10)
    plt.scatter(x=X[Y == -1, 0], y=X[Y == -1, 1],
                s=30, marker='x', color='blue', zorder=10)
    plt.xticks([])
    plt.yticks([])
    plt.xlim(x_min, x_max)
    plt.ylim(y_min, y_max)

    # plt.show()

if __name__ == '__main__':
    my_svm()