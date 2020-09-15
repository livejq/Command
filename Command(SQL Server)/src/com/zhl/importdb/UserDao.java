package com.zhl.importdb;
import java.sql.*;

import com.zhl.bean.User;
import com.zhl.connection.GetConnection;


public class UserDao {
		
		GetConnection connection = new GetConnection();
		Connection conn = null;
		
		//��д���û��������ѯ�û�����
		public User getUser(String userName,String password){
			User user = new User();				//����JavaBean����
			conn = connection.getCon();			//��ȡ���ݿ�����
			try {
				String sql = "select * from tb_users where userName = ? and password = ?";	//�����ѯԤ�������
				PreparedStatement statement = conn.prepareStatement(sql);		//ʵ����PreparedStatement����
				statement.setString(1, userName);			//����Ԥ����������
				statement.setString(2, password);
				ResultSet rest = statement.executeQuery();	//ִ��Ԥ�������
				while(rest.next()){
					user.setId(rest.getInt(1));				//Ӧ�ò�ѯ������ö�������
					user.setUserName(rest.getString(2));
					user.setPassWord(rest.getString(3));
				}
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			return user;						//���ز�ѯ���
		}	
		
		//��д���û�����ѯ�û�����
				public boolean isUserName(String userName){
					conn = connection.getCon();			//��ȡ���ݿ�����
					try {
						String sql = "select * from tb_users where userName = ? ";	//�����ѯԤ�������
						PreparedStatement statement = conn.prepareStatement(sql);		//ʵ����PreparedStatement����
						statement.setString(1, userName);			//����Ԥ����������
						ResultSet rest = statement.executeQuery();	//ִ��Ԥ�������
						if(rest.next()){
							return true;
						}
					} catch (SQLException e) {			
						e.printStackTrace();
					}
					return false;						//���ز�ѯ���
				}	
}