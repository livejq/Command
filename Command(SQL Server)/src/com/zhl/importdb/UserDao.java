package com.zhl.importdb;
import java.sql.*;

import com.zhl.bean.User;
import com.zhl.connection.GetConnection;


public class UserDao {
		
		GetConnection connection = new GetConnection();
		Connection conn = null;
		
		//编写按用户名密码查询用户方法
		public User getUser(String userName,String password){
			User user = new User();				//创建JavaBean对象
			conn = connection.getCon();			//获取数据库连接
			try {
				String sql = "select * from tb_users where userName = ? and password = ?";	//定义查询预处理语句
				PreparedStatement statement = conn.prepareStatement(sql);		//实例化PreparedStatement对象
				statement.setString(1, userName);			//设置预处理语句参数
				statement.setString(2, password);
				ResultSet rest = statement.executeQuery();	//执行预处理语句
				while(rest.next()){
					user.setId(rest.getInt(1));				//应用查询结果设置对象属性
					user.setUserName(rest.getString(2));
					user.setPassWord(rest.getString(3));
				}
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			return user;						//返回查询结果
		}	
		
		//编写按用户名查询用户方法
				public boolean isUserName(String userName){
					conn = connection.getCon();			//获取数据库连接
					try {
						String sql = "select * from tb_users where userName = ? ";	//定义查询预处理语句
						PreparedStatement statement = conn.prepareStatement(sql);		//实例化PreparedStatement对象
						statement.setString(1, userName);			//设置预处理语句参数
						ResultSet rest = statement.executeQuery();	//执行预处理语句
						if(rest.next()){
							return true;
						}
					} catch (SQLException e) {			
						e.printStackTrace();
					}
					return false;						//返回查询结果
				}	
}