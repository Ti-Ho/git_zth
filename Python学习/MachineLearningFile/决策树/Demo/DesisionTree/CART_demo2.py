#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/2 9:39
# @Author : Kai
# @File : CART.py
# @Software: PyCharm

from sklearn import datasets
from sklearn import tree
from sklearn.model_selection import train_test_split
import graphviz
from sklearn import metrics

# 自定义导入数据集函数
def get_data(total_data):
    x_true = total_data.data
    y_true = total_data.target
    feature_names = total_data.feature_names
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