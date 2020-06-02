#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/5/31 11:25
# @Author : Kai
# @File : KnnAppointmentWebsite.py
# @Software: PyCharm

from numpy import *
import operator
from matplotlib import pyplot as plt
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