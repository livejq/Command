<h1 align="center">Command</h1>
<br>

<p align="center">
  	<a href="http://hits.dwyl.io/livejq/Command" title="HitCount"><img alt="HitCount" src="http://hits.dwyl.io/livejq/Command.svg"></a>
  	<a href="https://github.com/livejq/Command/releases/latest" title="Releases"><img alt="releases" src="https://img.shields.io/github/v/release/livejq/Command.svg"></a>
  	<a href="https://github.com/livejq/Command/issues" title="Issues"><img alt="GitHub issues" src="https://img.shields.io/github/issues/livejq/Command.svg"></a>  	
	<a href="https://github.com/livejq/Command/blob/master/LICENSE" title="LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/livejq/Command.svg"></a>
</p>

<br>

<p align="center">
<span>给刚入门Linux的👉小白做的一个命令记录工具🙌</span>
</p>

<hr>

上了大二之后，开始有了Linux这门课程。面对眼花缭乱的命令，死记不是办法，常用才是关键。因此，在Java案例开发的课设上就顺手做了这用来记录的小工具。特别做了个单机版的放在U盘，去机房上Linux课的时候就打开来记录，个人觉得学习效果还是不错的 😆




## 简单介绍



常规的流程，登录验证后进入主面板操作。功能上简单实现了对命令的CURD。另外，为了使用方便，除了在本地电脑上运行的SQL Server版本外，增加了SQLite的单机版本，如此可以很方便的在别处电脑上运行。



## 实现效果



### 主面板



![主面板界面](https://raw.githubusercontent.com/livejq/blog-comment-repo/master/Command/mainPane.jpg "主面板")



输入命令点击搜索后（只能完全匹配搜索），若存在则直接显示在表格中；没有则给出弹窗提示。后面的增删改的功能都是在另外弹出的面板上进行的操作，流程基本一致。唯一的难点是如何重写SWING自带的Table表格，使得可以自定义表格的头信息，让表格可以竖向显示，另外还可以自定义间距和文字效果等。



### 不足之处



![内存占用](https://raw.githubusercontent.com/livejq/blog-comment-repo/master/Command/highRAM.jpg "内存占用过高")



👆如你所见，早就听说Java不是很适合开发桌面应用了。原来，除了UI界面外，还有内存占用这一茬呢😕。不过，对于个人使用来说，也没关系啦，能用就行~



## 安装配置

<br>

> 我的环境

- Java8
- Eclipse Java EE IDE for Web Developers. Oxygen.3a
- SQLite 3.18.0
- SQL Server 2008 R2

<br>

> 导入到Eclipse

新建Java Project，将相应的内容复制到对应的目录下即可。

<br>

> 导入数据库

将database目录下的sql文件导入到SQL Server即可，单机版的SQLite可放在项目中直接使用。



##  注意事项



### SQLite 死锁机制

![SQLite 死锁](https://raw.githubusercontent.com/livejq/blog-comment-repo/master/Command/SQLiteLocked.png "SQLite 死锁")



### 解决打包SQL JDBC Jar的安全机制




![sqljdbc打包的安全机制](https://raw.githubusercontent.com/livejq/blog-comment-repo/master/Command/sqljdbc.png "sqljdbc打包的安全机制")




## 参与贡献方式

<br>

欢迎[issuess](https://github.com/livejq/Command/issues)



## 许可证

<br>

@[MIT](https://github.com/livejq/Command/blob/master/LICENSE) License