#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2020/6/19 16:54
# @Author : Kai
# @File : cnn_mnist_test.py
# @Software: PyCharm

import torch
from torch.utils import data
from torch.autograd import Variable
import torchvision
from torchvision.datasets import mnist
import matplotlib.pyplot as plt
import pylab
import matplotlib
# 超参数
EPOCH = 1  # 训练整批数据多少次
BATCH_SIZE = 128
LR = 0.001  # 学习率
DOWNLOAD_MNIST = False  # 是否需要下载数据

device = torch.device('cpu')  # 使用CPU
# 数据集的预处理
data_tf = torchvision.transforms.Compose(
    [
        torchvision.transforms.ToTensor(),  # 对原有数据转成Tensor类型
        torchvision.transforms.Normalize([0.5], [0.5])  # 用平均值和标准偏差归一化
    ]
)
# 获取测试数据集
test_data = mnist.MNIST('mnist', train=False, transform=data_tf, download=DOWNLOAD_MNIST)
test_loader = data.DataLoader(test_data, batch_size=BATCH_SIZE, shuffle=False)  # 总共有10000/128 = 79个批次, 测试集不需要打乱数据

# 预览128张手写数字图片
matplotlib.rcParams['font.family'] = 'SimHei'  # 支持中文
images, labels = next(iter(test_loader))
img = torchvision.utils.make_grid(images)
img = img.numpy().transpose(1, 2, 0)
std = [0.5, 0.5, 0.5]
mean = [0.5, 0.5, 0.5]
img = img * std + mean
plt.figure('预览128张图片')
plt.imshow(img)
pylab.show()

# 定义CNN网络结构
class CNNnet(torch.nn.Module):
    def __init__(self):
        super(CNNnet, self).__init__()
        self.conv1 = torch.nn.Sequential(
            torch.nn.Conv2d(in_channels=1, out_channels=16, kernel_size=3, stride=2, padding=1),
            torch.nn.BatchNorm2d(16),
            torch.nn.ReLU()
        )
        self.conv2 = torch.nn.Sequential(
            torch.nn.Conv2d(16, 32, 3, 2, 1),
            torch.nn.BatchNorm2d(32),
            torch.nn.ReLU()
        )
        self.conv3 = torch.nn.Sequential(
            torch.nn.Conv2d(32, 64, 3, 2, 1),
            torch.nn.BatchNorm2d(64),
            torch.nn.ReLU()
        )
        self.conv4 = torch.nn.Sequential(
            torch.nn.Conv2d(64, 64, 2, 2, 0),
            torch.nn.BatchNorm2d(64),
            torch.nn.ReLU()
        )
        self.mlp1 = torch.nn.Linear(2 * 2 * 64, 100)
        self.mlp2 = torch.nn.Linear(100, 10)

    def forward(self, x):
        x = self.conv1(x)
        x = self.conv2(x)
        x = self.conv3(x)
        x = self.conv4(x)
        x = self.mlp1(x.view(x.size(0), -1))
        x = self.mlp2(x)
        return x


# 加载模型
model = CNNnet()  # 实例化模型
model.load_state_dict(torch.load('./model/model_mnist.pth'))  # 加载权重参数

model.to(device)
# print(model) #　输出模型信息


# ------------在整个测试集上测试-------------------------------------------
correct = 0  # 测试机中测试正确的个数
total = 0  # 测试集总共的样本个数
count = 0  # 共进行了count个batch = total/batch_size

with torch.no_grad():
    for images, labels in test_loader:
        images = Variable(images).to(device)
        labels = Variable(labels).to(device)

        # forward
        pre_labels = model(images)

        _, pred = torch.max(pre_labels, 1)
        correct += (pred == labels).sum().item()  # 正确的个数
        total += labels.size(0)  # 计算测试集中总样本个数
        count += 1  # 记录测试集共分成了多少个batch
        print("在第{0}个batch中的Acc为：{1}".format(count, correct / total))

# 总体平均 Acc
accuracy = float(correct) / total
print("======================  Result  =============================")
print('测试集上平均Acc = {:.5f}'.format(accuracy))
print("测试集共样本{0}个，分为{1}个batch，预测正确{2}个".format(total, count, correct))
