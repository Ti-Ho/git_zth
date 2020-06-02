from sklearn.datasets import load_iris
from sklearn import tree

iris = load_iris()
clf = tree.DecisionTreeClassifier()
clf = clf.fit(iris.data, iris.target)

# # export the tree in Graphviz format using the export_graphviz exporter
with open("iris.dot", 'w') as f:
    f = tree.export_graphviz(clf, out_file=f)

# predict the class of samples
result = clf.predict(iris.data[:1, :])
# the probability of each class
result_prob = clf.predict_proba(iris.data[:1, :])
print('预测类别为：', result)
print('预测类别对应的概率为：', result_prob)

import pydotplus
dot_data = tree.export_graphviz(clf, out_file=None)
graph = pydotplus.graph_from_dot_data(dot_data)
graph.write_pdf("iris.pdf")