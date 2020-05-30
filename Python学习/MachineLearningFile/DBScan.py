import matplotlib.pyplot as plt
import numpy as np
from sklearn.cluster import DBSCAN


data=np.array([[2,1],[5,1],[1,2],[2,2],[3,2],[4,2],[5,2],[6,2],[1,3],[2,3],[5,3],[2,4]])
#取特征的2个维度
X = data[:, :2]
print(X.shape)
# 绘制数据图
plt.scatter(X[:, 0], X[:, 1], c="red", marker='o', label='see')
plt.show()

dbscan = DBSCAN(eps=1, min_samples=4)
dbscan.fit(X)
label_pred = dbscan.labels_


x0 = X[label_pred == 0]
x1 = X[label_pred == 1]
plt.scatter(x0[:, 0], x0[:, 1], c="red", marker='o', label='label0')
plt.scatter(x1[:, 0], x1[:, 1], c="green", marker='o', label='label1')
plt.show()
