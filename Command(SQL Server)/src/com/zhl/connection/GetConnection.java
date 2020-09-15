package com.zhl.connection;

import java.sql.*;

public class GetConnection {
	
		public Connection con;			//�������ݿ����������
		private PreparedStatement pstm;
		private Statement stmt;
		private String user="sa";		//�������ݿ��û���
		private String password="123456";		//�������ݿ�����
		private String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";	//���ݿ�����
		private String url="jdbc:sqlserver://localhost:1433;DatabaseName=db_LinuxCompleteCommand";		//�������ݿ��URL

		
	public GetConnection(){
		try{
				Class.forName(className);
		}catch(ClassNotFoundException e){
				System.out.println("�������ݿ�����ʧ�ܣ�");
				e.printStackTrace();
		}
	}
		
		
		//�������ݿ�����
	public Connection getCon(){
		try {
				con=DriverManager.getConnection(url,user,password);		//��ȡ���ݿ�����
		} catch (SQLException e) {
				System.out.println("�������ݿ�����ʧ�ܣ�");
				con=null;
				e.printStackTrace();
		}
		return con;				//�������ݿ����Ӷ���
	}

	
	public void close(){
		try{
			if(pstm!=null)
				pstm.close();
			if(stmt!=null)
				stmt.close();
		}catch(SQLException e){
			System.out.println("�ر�statement����ʧ�ܣ�");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("�ر�con����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
