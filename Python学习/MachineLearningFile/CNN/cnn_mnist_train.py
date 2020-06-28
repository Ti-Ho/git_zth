#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/19 15:49
# @Author : Kai
# @File : cnn_mnist_train.py
# @Software: PyCharm

import torch
from torch.utils import data  # 获取迭代数据
from torch.autograd import Variable  # 获取变量
import torchvision  # 数据库模块
from torchvision.datasets import mnist  # 获取数据集
import matplotlib.pyplot as plt
import matplotlib

# 数据集的预处理
data_tf = torchvision.transforms.Compose(
    [
        torchvision.transforms.ToTensor(),  # 对原有数据转成Tensor类型
        torchvision.transforms.Normalize([0.5], [0.5])  # 用平均值和标准偏差归一化
    ]
)

# 超参数
EPOCH = 10  # 训练整批数据多少次
BATCH_SIZE = 128
LR = 0.001  # 学习率
DOWNLOAD_MNIST = False  # 是否需要下载数据

# 获取数据集
data_path = r'./mnist'
train_data = mnist.MNIST(
    data_path,
    train=True,
    transform=data_tf,
    download=DOWNLOAD_MNIST
)
test_data = mnist.MNIST(data_path, train=False, transform=data_tf, download=DOWNLOAD_MNIST)

# 对数据进行装载
train_loader = data.DataLoader(train_data, batch_size=BATCH_SIZE, shuffle=True)  # 总共有60000/128 = 469个批次
test_loader = data.DataLoader(test_data, batch_size=BATCH_SIZE, shuffle=False)  # 总共有10000/128 = 79个批次, 测试集不需要打乱数据


# 定义CNN网络结构
class CNNnet(torch.nn.Module):
    def __init__(self):
        super(CNNnet, self).__init__()
        self.conv1 = torch.nn.Sequential(  # (1, 28, 28)
            torch.nn.Conv2d(in_channels=1, out_channels=16, kernel_size=3, stride=2, padding=1),
            torch.nn.BatchNorm2d(16),  # 归一化
            torch.nn.ReLU()  # 激活层
        )  # 卷积层 归一化 激活层-> (16, 14, 14)
        self.conv2 = torch.nn.Sequential(
            torch.nn.Conv2d(16, 32, 3, 2, 1),
            torch.nn.BatchNorm2d(32),
            torch.nn.ReLU()
        )  # 卷积层 归一化 激活层-> (32, 7, 7)
        self.conv3 = torch.nn.Sequential(
            torch.nn.Conv2d(32, 64, 3, 2, 1),
            torch.nn.BatchNorm2d(64),
            torch.nn.ReLU()
        )  # 卷积层 归一化 激活层-> (64, 4, 4)
        self.conv4 = torch.nn.Sequential(
            torch.nn.Conv2d(64, 64, 2, 2, 0),
            torch.nn.BatchNorm2d(64),
            torch.nn.ReLU()
        )  # 卷积层 归一化 激活层-> (64, 2, 2)
        self.mlp1 = torch.nn.Linear(2 * 2 * 64, 100)
        self.mlp2 = torch.nn.Linear(100, 10)

    def forward(self, param_x):
        param_x = self.conv1(param_x)
        param_x = self.conv2(param_x)
        param_x = self.conv3(param_x)
        param_x = self.conv4(param_x)
        param_x = self.mlp1(param_x.view(param_x.size(0), -1))
        param_x = self.mlp2(param_x)
        return param_x


device = torch.device("cpu")
model = CNNnet()  # 实例化模型
model = model.to("cpu")

# 输出CNN模型信息
    # print(model)

# 定义损失和优化器
loss_func = torch.nn.CrossEntropyLoss()  # 使用交叉熵损失
optimizer = torch.optim.Adam(model.parameters(), lr=LR)  # 使用Adam优化器

loss_count = []
# 训练网络 , 迭代epoch
for epoch in range(EPOCH):
    running_loss = 0.0
    for step, (x, y) in enumerate(train_loader, 0):  # 60000/128 = 469个batch(其中batch_size=128)
        # get the input
        inputs = Variable(x).to(device)  # torch.Size([128, 1, 28, 28])
        labels = Variable(y).to(device)  # torch.Size([128])

        # CNN output
        outputs = model(inputs)

        loss = loss_func(outputs, labels)  # 计算loss
        optimizer.zero_grad()  # 清空上一步残余更新参数值
        loss.backward()  # loss 求导, 误差反向传播，计算参数更新值
        optimizer.step()  # 更新参数：将参数更新值施加到net的parmeters上

        loss_count.append(loss)
        running_loss += loss.item()  # tensor.item()  获取tensor的数值

        # 每100个batch，输出loss的平均值
        if step % 100 == 99:
            print('[迭代轮数：%d  | batch_cnt：%5d] #### 交叉熵损失平均值: %.3f' % (epoch + 1, step + 1, running_loss / 100))
            running_loss = 0.0

# --------保存模型----------- 保存模型权重参数 供测试使用
torch.save(model.state_dict(), './model/model_mnist.pth')

# 损失函数图
matplotlib.rcParams['font.family'] = 'SimHei'  # 支持中文
plt.figure('PyTorch_CNN_MNIST_Loss')
plt.plot(loss_count, label='交叉熵损失')
plt.legend()
plt.show()
print('------------训练完成------------')
