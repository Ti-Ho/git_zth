## Echarts

### 快速上手

> 文档目录

![image-20201213092719688](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213092719688.png)

> EchartsQuickStart.js

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 步骤1：引入echarts.js文件 -->
   <script src="lib/echarts.min.js"></script>
</head>
<body>
    <!-- 步骤2：准备一个呈现图表的盒子 -->
    <div style="width: 600px; height: 400px"></div>
    <script>
        // 步骤3：初始化echarts实例对象
        // 参数 dom 决定图表最终呈现的位置
        var mcharts = echarts.init(document.querySelector('div'))
        // 步骤4：准备配置项
        var option = {
            xAxis: {
                type: 'category',
                data: ['小明', '小红', '小王']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '语文',
                    type: 'bar',
                    data: [70, 92, 87]
                }
            ]
        }
        //步骤5： 将配置项设置给echarts实例对象
        mcharts.setOption(option)
    </script>
</body>
</html>
```

> 运行

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213092946091.png" alt="image-20201213092946091" style="zoom:50%;" />

### 基本使用

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213093254799.png" alt="image-20201213093254799" style="zoom:50%;" />

---

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213093626020.png" alt="image-20201213093626020" style="zoom:50%;" />

#### 柱状图

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094833529.png" alt="image-20201213094833529" style="zoom:50%;" />

> 最值

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094018167.png" alt="image-20201213094018167" style="zoom:50%;" />

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094036593.png" alt="image-20201213094036593" style="zoom:50%;" />

> 均值

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094236385.png" alt="image-20201213094236385" style="zoom:50%;" />

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094247789.png" alt="image-20201213094247789" style="zoom: 67%;" />

---

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094310550.png" alt="image-20201213094310550" style="zoom:50%;" />

![image-20201213094422756](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094422756.png)

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094508207.png" alt="image-20201213094508207" style="zoom:50%;" />

![image-20201213094540768](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094540768.png)

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213094612198.png" alt="image-20201213094612198" style="zoom:50%;" />



![image-20201213233255621](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201213233255621.png)



#### 各种表格的一系列配置

![image-20201218202652162](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201218202652162.png)