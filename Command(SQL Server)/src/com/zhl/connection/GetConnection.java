package com.zhl.connection;

import java.sql.*;

public class GetConnection {
	
		public Connection con;			//定义数据库连接类对象
		private PreparedStatement pstm;
		private Statement stmt;
		private String user="sa";		//连接数据库用户名
		private String password="123456";		//连接数据库密码
		private String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";	//数据库驱动
		private String url="jdbc:sqlserver://localhost:1433;DatabaseName=db_LinuxCompleteCommand";		//连接数据库的URL

		
	public GetConnection(){
		try{
				Class.forName(className);
		}catch(ClassNotFoundException e){
				System.out.println("加载数据库驱动失败！");
				e.printStackTrace();
		}
	}
		
		
		//创建数据库连接
	public Connection getCon(){
		try {
				con=DriverManager.getConnection(url,user,password);		//获取数据库连接
		} catch (SQLException e) {
				System.out.println("创建数据库连接失败！");
				con=null;
				e.printStackTrace();
		}
		return con;				//返回数据库连接对象
	}

	
	public void close(){
		try{
			if(pstm!=null)
				pstm.close();
			if(stmt!=null)
				stmt.close();
		}catch(SQLException e){
			System.out.println("关闭statement对象失败！");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
}
