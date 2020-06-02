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