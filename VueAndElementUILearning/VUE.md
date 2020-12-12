## VUE

### 安装vue （Windows）

[参考安装网址](https://www.cnblogs.com/wyrlzy/p/12020922.html)

#### 1.安装node.js npm也随着安装

![image-20201210190039807](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210190039807.png)

####  **2.下载vue-cli**

![image-20201210190628425](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210190628425.png)

#### 3.在idea中下载vue.js插件

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210190803556.png" alt="image-20201210190803556" style="zoom: 50%;" />

#### **4.安装webpack工具**

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210191113091.png" alt="image-20201210191113091" style="zoom:200%;" />

#### 5.下载git，不然在搭建脚手架是会报找不到git

#### **6.基本工具安装完成后，开始创建项目**

`vue init webpack testvue`

![image-20201210192630835](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210192630835.png)

![image-20201210192809152](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210192809152.png)

**nodo_modules文件夹**:

<img src="C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210195549736.png" alt="image-20201210195549736" style="zoom:67%;" />

![image-20201210195648196](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210195648196.png)

#### 7. 配置并成功运行

![image-20201210200509451](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210200509451.png)

![image-20201210200420942](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210200420942.png)

![image-20201210211656950](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201210211656950.png)



### 学习

#### 第一部分

* `v-bind` 单向数据绑定

* `v-model` 双向数据绑定

* `v-on` 事件绑定

* `v-html` `v-show`

* `v-if-else` `v-for`

* 网络通讯（第三方模块） `Ajax的一个插件Axios`

  钩子函数

  ![image-20201211001058235](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201211001058235.png)

* 生命周期 钩子函数

* 计算属性 `computed`



#### IDEA问题


idea64.exe.moptions

```
-Xms128m
-Xmx1008m
-XX:ReservedCodeCacheSize=240m
-XX:+UseConcMarkSweepGC
-XX:SoftRefLRUPolicyMSPerMB=50
-ea
-XX:CICompilerCount=2
-Dsun.io.useCanonPrefixCache=false
-Djava.net.preferIPv4Stack=true
-Djdk.http.auth.tunneling.disabledSchemes=""
-XX:+HeapDumpOnOutOfMemoryError
-XX:-OmitStackTraceInFastThrow
-Djdk.attach.allowAttachSelf
-Dkotlinx.coroutines.debug=off
-Djdk.module.illegalAccess.silent=true
```



```
-Xms526m
-Xmx1024m
-XX:MaxMetaspaceSize=526m
-XX:ReservedCodeCacheSize=240m
-XX:+UseConcMarkSweepGC
-XX:SoftRefLRUPolicyMSPerMB=50
-ea
-XX:CICompilerCount=2
-Dsun.io.useCanonPrefixCache=false
-Djava.net.preferIPv4Stack=true
-Djdk.http.auth.tunneling.disabledSchemes=""
-XX:+HeapDumpOnOutOfMemoryError
-XX:-OmitStackTraceInFastThrow
-Djdk.attach.allowAttachSelf
-Dkotlinx.coroutines.debug=off
-Djdk.module.illegalAccess.silent=true
```



### Router

![image-20201212172844931](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20201212172844931.png)

