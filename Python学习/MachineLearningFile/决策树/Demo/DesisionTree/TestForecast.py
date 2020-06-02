#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/2 10:46
# @Author : Kai
# @File : TestForecast.py
# @Software: PyCharm

import numpy as np
from sklearn import tree
from sklearn import metrics
from sklearn import datasets

iris = datasets.load_iris()
X = iris.data
y = iris.target
idx = np.arange(X.shape[0])
np.random.seed(13)
np.random.shuffle(idx)  #将idx打乱
X=X[idx]
y=y[idx]


#划分训练集与测试集
X_train = X[:int(X.shape[0]*0.75)]
X_test = X[int(X.shape[0]*0.75):]
y_train = y[:int(X.shape[0]*0.75)]
y_test = y[int(X.shape[0]*0.75):]


#搭建决策树模型
clf = tree.DecisionTreeClassifier()
#模型拟合
clf.fit(X_train,y_train)

#对测试集做出预测
y_predict = clf.predict(X_test)
result = metrics.classification_report(y_test,y_predict,target_names=iris.target_names)
print(result)

'''
              precision    recall  f1-score   support

      setosa       1.00      1.00      1.00        13
  versicolor       0.93      1.00      0.97        14
   virginica       1.00      0.91      0.95        11

    accuracy                           0.97        38
   macro avg       0.98      0.97      0.97        38
weighted avg       0.98      0.97      0.97        38
'''