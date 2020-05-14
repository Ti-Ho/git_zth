# Latex 学习

## 简单Latex例子及效果截图

[^注]: 截图无法显示请查看pdf

### (1). 第一个文档

```latex
\documentclass{article}
\begin{document}
hello, world
\end{document}
```

![image-20200514232539285](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514232539285.png)

### (2). 标题、作者和注释

```latex
\documentclass{article}
\author{My Name}
\title{The Title}
\begin{document}
\maketitle
hello, world % This is comment
\end{document}
```

![image-20200514232611464](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514232611464.png)

### (3).章节和段落

```latex
\documentclass{article}
\title{Hello World}
\begin{document}
\maketitle
\section{Hello China} China is in East Asia.
\subsection{Hello Beijing} Beijing is the capital of China.
\subsubsection{Hello Dongcheng District}
\paragraph{Tian'anmen Square}is in the center of Beijing
\subparagraph{Chairman Mao} is in the center of Tian'anmen Square
\subsection{Hello Guangzhou}
\paragraph{Sun Yat-sen University} is the best university in Guangzhou.
\end{document}
```

![image-20200514232738806](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514232738806.png)

### (4).加入目录

```latex
\documentclass{article}
\begin{document}
\tableofcontents	%目录
\section{Hello China} China is in East Asia.
\subsection{Hello Beijing} Beijing is the capital of China.
\subsubsection{Hello Dongcheng District}
\paragraph{Hello Tian'anmen Square}is in the center of Beijing
\subparagraph{Hello Chairman Mao} is in the center of Tian'anmen Square
\end{document}
```

![image-20200514232827832](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514232827832.png)

### (5).换行

```latex
\documentclass{article}
\begin{document}
Beijing is
the capital
of China.

New York is  %换行需要空一行

the capital

of America.

Amsterdam is \\ the capital \\
of Netherlands.
\end{document}
```

![image-20200514233008549](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514233008549.png)

### (6).数学公式

```latex
\documentclass{article}
\usepackage{amsmath}
\usepackage{amssymb}
\begin{document}
	The Newton's second law is F=ma.
	
	The Newton's second law is $F=ma$.
	
	The Newton's second law is
	$$F=ma$$
	
	The Newton's second law is
	\[F=ma\]
	
	Greek Letters $\eta$ and $\mu$
	
	Fraction $\frac{a}{b}$
	
	Power $a^b$
	
	Subscript $a_b$
	
	Derivate $\frac{\partial y}{\partial t} $
	
	Vector $\vec{n}$
	
	Bold $\mathbf{n}$
	
	To time differential $\dot{F}$
	
	Matrix (lcr here means left, center or right for each column)
	\[
	\left[
	\begin{array}{lcr}
	a1 & b22 & c333 \\
	d444 & e555555 & f6
	\end{array}
	\right]
	\]
	
	Equations(here \& is the symbol for aligning different rows)
	\begin{align}
		a+b&=c\\ 
		d&=e+f+g  % &符号加在等号前使得等号对齐
	\end{align}
	
	\[
	\left\{
	\begin{aligned}
	&a+b=c\\
	&d=e+f+g
	\end{aligned}
	\right.
	\]
	
\end{document}
```

![image-20200514233124600](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514233124600.png)

### (7).插入图片

先搜索到一个将图片转成eps文件的软件，很容易找的，然后将图片保存为一个名字如figure1.eps。 建立一个新文档，将以下内容复制进入文档中，保存，保存类型选择为UTF-8，放在和图片文件同一个文件夹里，编译并观察现象。

```
\documentclass{article}
\usepackage{graphicx}
\begin{document}
\includegraphics[width=4.00in,height=3.00in]{figure1.eps}
\end{document}
```

### (8).简单表格

```latex
\documentclass{article}
\begin{document}
\begin{tabular}{|c|c|}
a & b \\
c & d\\
\end{tabular}

\begin{tabular}{|c|c|}
\hline
a & b \\
\hline
c & d\\
\hline
\end{tabular}

\begin{center}
\begin{tabular}{|c|c|}
\hline
a & b \\ \hline
c & d\\
\hline
\end{tabular}
\end{center}
\end{document}
```

![image-20200514233326215](C:\Users\38004\AppData\Roaming\Typora\typora-user-images\image-20200514233326215.png)



