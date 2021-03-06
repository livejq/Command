USE [master]
GO
/****** Object:  Login [##MS_PolicyEventProcessingLogin##]    Script Date: 10/31/2018 07:41:04 ******/
/* For security reasons the login is created disabled and with a random password. */
CREATE LOGIN [##MS_PolicyEventProcessingLogin##] WITH PASSWORD=N'8d&?íÔ{ö¯½%Qõg 5uÅB@ùÉI', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=ON
GO
ALTER LOGIN [##MS_PolicyEventProcessingLogin##] DISABLE
GO
/****** Object:  Login [##MS_PolicyTsqlExecutionLogin##]    Script Date: 10/31/2018 07:41:04 ******/
/* For security reasons the login is created disabled and with a random password. */
CREATE LOGIN [##MS_PolicyTsqlExecutionLogin##] WITH PASSWORD=N'ÅM©bzt"kÎ¬lø}GïPÅ9TM6÷', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=ON
GO
ALTER LOGIN [##MS_PolicyTsqlExecutionLogin##] DISABLE
GO
/****** Object:  Login [NT AUTHORITY\LOCAL SERVICE]    Script Date: 10/31/2018 07:41:04 ******/
CREATE LOGIN [NT AUTHORITY\LOCAL SERVICE] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[简体中文]
GO
/****** Object:  Login [NT AUTHORITY\SYSTEM]    Script Date: 10/31/2018 07:41:04 ******/
CREATE LOGIN [NT AUTHORITY\SYSTEM] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[简体中文]
GO
/****** Object:  Login [NT SERVICE\MSSQLSERVER]    Script Date: 10/31/2018 07:41:04 ******/
CREATE LOGIN [NT SERVICE\MSSQLSERVER] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[简体中文]
GO
/****** Object:  Login [NT SERVICE\SQLSERVERAGENT]    Script Date: 10/31/2018 07:41:04 ******/
CREATE LOGIN [NT SERVICE\SQLSERVERAGENT] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[简体中文]
GO
/****** Object:  Login [PC-15767232209\mayn]    Script Date: 10/31/2018 07:41:04 ******/
CREATE LOGIN [PC-15767232209\mayn] FROM WINDOWS WITH DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[简体中文]
GO
USE [db_LinuxCompleteCommand]
GO
/****** Object:  Table [dbo].[tb_users]    Script Date: 10/31/2018 07:41:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_users](
	[id] [int] NOT NULL,
	[userName] [varchar](50) NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_tb_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tb_users] ([id], [userName], [password]) VALUES (1, N'zhl', N'zhlsoft')
INSERT [dbo].[tb_users] ([id], [userName], [password]) VALUES (2, N'朱洪龙', N'zhl')
/****** Object:  Table [dbo].[tb_study]    Script Date: 10/31/2018 07:41:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_study](
	[id] [int] NOT NULL,
	[command] [varchar](50) NOT NULL,
	[fullname] [varchar](50) NULL,
	[upower] [varchar](100) NULL,
	[syntax] [varchar](100) NULL,
	[funcexplain] [varchar](100) NULL,
	[addexplain] [text] NULL,
	[param] [text] NULL,
	[example] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (1, N'cat', NULL, N'所有使用者', N'cat [-参数] [- - help] [- -version] fileName ', N'把档案串联接后传到基本输出（荧幕或加>fileName 到另一个档案）', NULL, N'-n或- -number<br>由1开始对所有输出的行数编号<br> --b或 - -number-nonblank<br> 和-n相似，只不过对于空白行不编号<br> - s或- -squeeze-blank<br>当遇到有两行以上的空白行，就代换为一行的空白行<br> -v或 - -show-nonprinting', N'* cat -n textfile1 > textfiel2 把textfile1的档案内容加上行号后输入textfile2这个档案里<br> *  cat -b textfile1 textfiel2 > > textfile3 把textfile1和textfile2加上行号（空白行不加）之后将内容附加到  textfiel3 里')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (1, N'touch', N'', N'', N'', N'建立文件或更新文件时间', N'', N'', N'touch  a.txt <br> touch -t 201710311359 <br> touch -t "2 days ago" bash')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (1, N'which', N'', N'', N'', N'查看命令所在位置', N'', N'', N'which ssh <br> which useradd')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'man', N'', N'', N'', N'帮助命令', N'', N'', N'man rpm')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (1, N'whereis', N'', N'', N'', N'查看命令所在位置', N'', N'', N'whereis fdisk')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'shutdown', N'', N'需要root用户', N'shutdown [option] ... TIME [message]', N'关机（选项较多，是功能较丰富的一条关机命令）', N'此命令可安全的将系统关机。若通过关掉电源的方式则有可能导致数据丢失，甚至是损坏硬件设备（因为后台正运行着许多进程）。当执行shutdown时，系统管理员会通知所有登录的用户，系统将要关闭；login指令被冻结，新用户不能再登录。所有进程都会收到系统所送达的信号（signal）；这让向vi之类的程序有时间存储正在编辑的文档，而向处理邮件（mail）和新闻（news）的程序则可以正常离开。', N'options: -r                               关机后自启 <br> -h                              关机后切断电源 <br> -H 或 -P                                   关机后关掉电源（暗指-h指令) <br> -c                                 取消即将关机的指令 <br> -k                                仅仅向所有进程发出即将关机的警告，并不关机 <br> -q,- -quiet                            仅仅减少错误输出 <br> - - version                             输出shutdown新贵版本信息', N'shutdown -k +1(1分钟后,也可指定具体时间)  “Hello!! Everyone I gona to leave" <br> ')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'halt', N'', N'普通用户都可以', N'halt  [option]', N'中止系统', N'wtmp、utmp、lastlog、messages为Linux的日志文件，有关当前登录用户的信息记录在文件utmp中；==who命令；登录和退出记录在文件wtmp中==w命令；最后一次登录文件可以用lastlog命令查看；', N'options : -n , - - no - sync                       在中止或重启之前不要同步 <br> -f , - - force                        强制重启或中止，不要下令停下。<br> - p, - -poweroff                        当下令中止的时候关掉电源。<br> -w, - -wtmp-only                    不要真正的重启或中止，而仅仅是记录下日志。<br> -q , - - quiet                      只是减少错误的直接输出 <br> -v  - -verbose                          增加输出来包含一些信息。', N'halt -f')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (7, N'toe', N'', N'', N'toe [-ahuYV]  [-v n]  [file...]', N'列出系统所支持的终端类型', N'', N'', N'toe -a')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'poweroff', N'', N'', N'poweroff  [option]', N'关闭计算机，比halt好用', N'参数使用情况跟halt命令没差', N'', N'poweroff')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'reboot', N'', N'', N'', N'引发主机重启', N'参数用法与halt无差', N'', N'reboot')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (7, N'w', N'', N'', N'', N'输出登录时间、距登录已过去多少分钟、有多少已登录用户等信息', N'', N'', N'w')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (13, N'pts', N'伪终端/虚拟终端', N'', N'', N'英文是pseudo terminal slave。pts是point的缩写', N'', N'', N'w、who')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'init', N'', N'需要root用户', N'init  [option]', N'关闭计算机', N'这个是运行级别关机', N'-q, - -quiet                           只是减少错误的直接输入 <br> -v  - -verbose                       增加一些输出来包含一些信息', N'init 0 (关机）/6（重启）/1（单用户模式，用户可以进行系统管理任务）/2 （启动多用户模式，通常不启动NFS) /5(有Gnome或KDE等桌面环境时，启动进入图形界面)。')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'login', N'', N'', N'', N'登录某一用户', N'', N'[option] - p (protected受保护的)                 被getty用来告诉登录者不要破坏本地环境。<br> - f                      用来切换到另一个登录验证，这条参数唯一不对root生效，且在linux下并不见得可以用得很好。- h  用在其它服务端来使远程主机名字可以登录以至于其在utmp或wtmp等日志文件里可能留有登录记录，只有超级用户才可以使用这一选项。', N'login root  、login -p、login -f name、login -h hostname（远程登录）')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (10, N'infocmp', N'', N'', N'infocmp [options] [-A directory] [-B directory] [termname]', N'在terminfo目录下查找需要比较的信息', N'', N'', N'infocmp vt100 vt220(比较这两个终端的区别）。')
INSERT [dbo].[tb_study] ([id], [command], [fullname], [upower], [syntax], [funcexplain], [addexplain], [param], [example]) VALUES (13, N'tty', N'电传打字机', N'', N'', N'输入命令和显示信息的设备名称', N'tty1~6表示文字界面，Ctrl+Alt+F1~F6切换，+F7就是切换回图形界面。', N'', N'tty')
/****** Object:  Table [dbo].[tb_catalogue]    Script Date: 10/31/2018 07:41:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_catalogue](
	[id] [int] NOT NULL,
	[catalogue] [varchar](50) NULL,
 CONSTRAINT [PK_tb_catalogue] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (1, N'文件管理')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (2, N'文件传输')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (3, N'文档编辑')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (4, N'磁盘管理')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (5, N'磁盘维护')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (6, N'网络通信')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (7, N'系统管理')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (8, N'系统设置')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (9, N'备份压缩')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (10, N'其它')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (11, N'X-Window')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (12, N'电子邮件与新闻组')
INSERT [dbo].[tb_catalogue] ([id], [catalogue]) VALUES (13, N'附录')
