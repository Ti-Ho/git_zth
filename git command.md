# Git Command

## 一、Git 工作区、暂存区和版本库

* **git add <file>**  暂存区的目录树被更新
* **git commit (-m "description") **  暂存区的目录树写到版本库（对象库）中
* **git reset HEAD** 暂存区的目录树会被重写，被 master 分支指向的目录树所替换，但是工作区不受影响
* **git checkout .	**或者 **git checkout -- <file>** 会用暂存区全部或指定的文件替换工作区的文件。这个操作很危险，会清除工作区中未添加到暂存区的改动。
* **git checkout HEAD . **   或者 **git checkout HAED <file> ** 会用 HEAD 指向的 master 分支中的全部或者部分文件替换暂存区和以及工作区中的文件。这个命令也是极具危险性的，因为不但会清除工作区中未提交的改动，也会清除暂存区中未提交的改动。

---

场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令

```
1、git checkout -- file（文件名）
```

场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令

    2、git reset HEAD file（文件名），

就回到了场景1，第二步按场景1操作。

---

## 二、 Git 创建仓库

* **git init**  初始化一个 Git 仓库

* **git clone <repo>** 从现有 Git 仓库中拷贝项目 (拷贝到当前文件夹)    

* **git clone <repo> <directory>** (克隆到指定的目录)         [repo:Git 仓库。 directory:本地目录。]

  ​	eg.		*git clone git://github.com/schacon/grit.git*
  ​	eg.		自己定义要新建的项目目录名称，可以在上面的命令末尾指定新的名字: 

  ​				*git clone git://github.com/schacon/grit.git mygrit*

---

## 三、GIT基本操作

* **git status** 查看项目的当前状态				 **git status -s**  简要查看  

* **git diff** : 

  工作区		[git diff]		暂存区		[git diff --cached]		版本库
  	|------------------------     [git diff HEAD]  ---------------------------------|

* 显示摘要而非整个 diff：**git diff --stat**



### 配置用户名和邮箱地址

**git config --global user.name 'runoob'**
**git config --global user.email test@runoob.com**



### 基本命令

* **git commit -a**		跳过git add提交缓存 直接commit
* **git reset HEAD <file>**	用于取消已缓存的内容。
* **git rm <file>**		从 Git 中移除某个文件，就必须要从已跟踪文件清单中移除，然后提交。
* **git rm -f <file>**	如果删除之前修改过并且已经放到暂存区域的话，则必须要用强制删除选项 -f
* **git rm --cached <file>**	如果把文件从暂存区域移除，但仍然希望保留在当前工作目录中，换句话说，仅是从跟踪清单中删除，使用 --cached 选项即可
* **git rm –r **  进入某个目录中，执行此语句，会删除该目录下的所有文件和子目录。 （-r 递归）
* **git mv**  命令用于移动或重命名一个文件、目录、软连接。 eg.	git mv README  README.md

---

## 四、GIT分支管理

* **git branch (branchname)**		创建分支命令
* **git checkout (branchname)**	切换分支命令
* **git branch (branchname)**		创建分支命令
* **git checkout (branchname)**	切换分支命令



* **git branch -d (branchname)**	删除分支命令



* **git merge	(branchname)**	合并分支命令	eg.	git merge newtestbanch
* **git merge (branchname) -m 'description'**



合并冲突:

```java
vim <conflict file>
modify it
git add <conflict file>	用 git add 要告诉 Git 文件冲突已经解决
```

---

## 五、Git 查看提交历史

* **git log**		 列出历史提交记录
* **git log --oneline**	查看历史记录的简洁的版本 
* **git log --graph**	查看历史中什么时候出现了分支、合并
* **git log --reverse --oneline**		你也可以用 --reverse 参数来逆向显示所有日志。



---

## 六、Git标签

**git tag -a <tagname>**			Git 会打开你的编辑器，让你写一句标签注解，就像你给提交写注解一样。
	eg.	git tag -a v1.0	
						-a 选项意为"创建一个带注解的标签"
**git log --decorate**			我们可以看到我们的标签了

忘了给某个提交打标签，又将它发布了,追加标签
eg.			git tag -a v0.1 85fc7e7		
**git tag**      查看所有标签命令
**git tag -a <tagname> -m "runoob.com标签"**       指定标签信息命令



---

## 七、Git 远程仓库(Github)

* 添加远程仓库

  **git remote add [shortname] [server_url]**  添加远程地址   

  ```java
  *eg. git remote add origin  git@github.com:upcorz/zth.git*
  进入.git的config中多出一个remote "origin"内容
  ```

* **git clone git@github.com:upcorz/zth.git** 检出仓库
  **git clone /path/to/repository <newname>** 会克隆下来并重命名为<newname>
  **git push origin <branchname>**  把本地仓库的内容推送到GitHub仓库。

* 第一次push :  **git push -u origin master**

  加了参数-u后，以后即可直接用**git push** 代替**git push origin master**

* 查看当前的远程库
  **git remote**		查看当前配置有哪些远程仓库
  **git remote -v**		加上 -v 参数，你还可以看到每个别名的实际链接地址。

* 提取远程仓库
  **git fetch**				从远程仓库下载新分支与数据
  **git merge**			从远端仓库提取数据并尝试合并到当前分支
  		

  		eg.	git fetch origin 
  			git merge origin/master
  你可以首先执行 git fetch [alias] 告诉 Git 去获取它有你没有的数据，
  然后你可以执行 git merge [alias]/[branch] 以将服务器上的任何更新
  （假设有人这时候推送到服务器了）合并到你的当前分支。

  git merge origin/<branchname>	从<branchname>中merge
