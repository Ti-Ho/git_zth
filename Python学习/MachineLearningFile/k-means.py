import pandas as pd
import numpy as np
from sklearn.cluster import KMeans
from sklearn import preprocessing
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

data= pd.read_csv('cluster.csv',encoding="gbk",index_col=False)
print(data)
#输出原数据

train_x = data[[" 赛事1"," 赛事2"," 赛事3"]]
#归一化
min_max_scaler=preprocessing.MinMaxScaler()
train_x=min_max_scaler.fit_transform(train_x)
print(train_x)
#输出归一化后的结果

a = np.array([[0.3,0,0.19],[0.7,0.76,0.5],[1,1,0.5]],dtype=float)
print(a)
kmeans = KMeans(n_clusters=3,init=a)
kmeans.fit(train_x)
predict_y = kmeans.predict(train_x)


result = pd.concat((data,pd.DataFrame(predict_y)),axis = 1)
result.rename({0:'分类'},axis = 1,inplace = True)
print(result)
#输出结果



