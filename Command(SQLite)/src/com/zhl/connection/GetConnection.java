package com.zhl.connection;

import java.sql.*;

public class GetConnection {

	public Connection conn; // 定义数据库连接类对象
	public static final String className = "org.sqlite.JDBC"; // 数据库驱动
	public static final String url = "jdbc:sqlite:database/db_LinuxCommand"; // 连接数据库的URL
	public static final String cata[] = { "文件管理", "文件传输", "文档编辑", "磁盘管理", "磁盘维护", "网络通信", "系统管理", "系统设置", "备份压缩", "其它",
			"X-Window", "电子邮件与新闻组", "附录" };

	public GetConnection() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}
	}

	// 创建数据库连接
	public Connection getCon() {
		try {
			conn = createConnection(); // 获取数据库连接
			init(conn);
		} catch (SQLException e) {//SQL语句错误直接输出
			System.err.println(e.getMessage());
		} catch (Exception e) {//其它错误则使conn为null
			conn = null;
			e.printStackTrace();
		}
		return conn; // 返回数据库连接对象
	}

	public static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url);
	}

	public static void init(Connection con) {
		try {
			Statement query = con.createStatement();
			Statement stmt = con.createStatement();
			String q, sql;
			ResultSet rest;

			q = "select * from sqlite_master where type = 'table' and name = 'tb_catalogue'";
			rest = query.executeQuery(q);
			if (!rest.next()) {
				sql = "create table tb_catalogue(id int,catalogue varchar(50))";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("创建命令目录失败！");
			System.err.println(e.getMessage());
		}

		try {
			Statement query = con.createStatement();
			Statement stmt = con.createStatement();
			String q, sql;
			ResultSet rest;

			q = "select * from tb_catalogue";
			rest = query.executeQuery(q);
			if (!rest.next()) {
				for (int i = 0; i < cata.length; i++) {
					sql = "insert into tb_catalogue values(" + (i + 1) + "," + "'" + cata[i] + "')";
					stmt.executeUpdate(sql);
				}
			}
		} catch (SQLException e) {
			System.out.println("插入命令目录失败！");
			System.err.println(e.getMessage());
		}

		try {
			Statement query = con.createStatement();
			Statement stmt = con.createStatement();
			String q, sql;
			ResultSet rest;

			q = "select * from sqlite_master where type = 'table' and name = 'tb_users'";
			rest = query.executeQuery(q);
			if (!rest.next()) {
				sql = "create table tb_users(id int,userName varchar(50),password varchar(50))";
				stmt.executeUpdate(sql);
				sql = "insert into tb_users values(1,'zhl','zhlsoft')";
				stmt.executeUpdate(sql);
				sql = "insert into tb_users values(2,'朱洪龙','zhl')";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("创建并插入用户信息表失败！");
			System.err.println(e.getMessage());
		}

		try {
			Statement query = con.createStatement();
			Statement stmt = con.createStatement();
			String q, sql;
			ResultSet rest;
			q = "select * from sqlite_master where type = 'table' and name = 'tb_study'";
			rest = query.executeQuery(q);
			if (!rest.next()) {
				sql = "create table tb_study(id int,command varchar(50),fullname varchar(50),"
						+ "upower	varchar(100),syntax	varchar(100),funcexplain varchar(100),addexplain text,param	text,example text)";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("创建命令数据表失败！");
			System.err.println(e.getMessage());
		}
	}

}
