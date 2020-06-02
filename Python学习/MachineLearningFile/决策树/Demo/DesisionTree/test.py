#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/2 11:33
# @Author : Kai
# @File : test.py
# @Software: PyCharm

import pydot
from sklearn.tree import export_graphviz
from sklearn.tree import DecisionTreeClassifier
# 3：1拆分数据集
from sklearn.model_selection import train_test_split
from sklearn import datasets
from sklearn.datasets import load_iris
from sklearn.tree import DecisionTreeClassifier
import numpy as np

iris = load_iris()
X = iris.data  # petal length and width
y = iris.target  # 目标值

tree_clf = DecisionTreeClassifier(max_depth=2, random_state=42)  # 定义最大深度和确定随机种子
tree_clf.fit(X, y)  # 训练
print(tree_clf.predict_proba([[5, 1.5, 2, 3]]))  # 预测返回的是可能性

# 以上代码运行后将会产生如下输出 [[ 0.          0.90740741  0.09259259]]
# 分别代表属于每一种类别可能的概率
# 也可以用如下代码
print(tree_clf.predict([[5, 1.5, 2, 3]]))  # 直接输出属于哪一类


# 生成可视化图
export_graphviz(tree_clf, out_file="tree.dot", class_names=iris.target_names, feature_names=iris.feature_names,
                    impurity=False, filled=True)
# 展示可视化图
(graph,) = pydot.graph_from_dot_file('tree.dot')
graph.write_png('tree2.png')