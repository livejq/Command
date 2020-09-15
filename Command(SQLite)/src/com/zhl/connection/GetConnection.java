package com.zhl.connection;

import java.sql.*;

public class GetConnection {

	public Connection conn; // �������ݿ����������
	public static final String className = "org.sqlite.JDBC"; // ���ݿ�����
	public static final String url = "jdbc:sqlite:database/db_LinuxCommand"; // �������ݿ��URL
	public static final String cata[] = { "�ļ�����", "�ļ�����", "�ĵ��༭", "���̹���", "����ά��", "����ͨ��", "ϵͳ����", "ϵͳ����", "����ѹ��", "����",
			"X-Window", "�����ʼ���������", "��¼" };

	public GetConnection() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	// �������ݿ�����
	public Connection getCon() {
		try {
			conn = createConnection(); // ��ȡ���ݿ�����
			init(conn);
		} catch (SQLException e) {//SQL������ֱ�����
			System.err.println(e.getMessage());
		} catch (Exception e) {//����������ʹconnΪnull
			conn = null;
			e.printStackTrace();
		}
		return conn; // �������ݿ����Ӷ���
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
			System.out.println("��������Ŀ¼ʧ�ܣ�");
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
			System.out.println("��������Ŀ¼ʧ�ܣ�");
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
				sql = "insert into tb_users values(2,'�����','zhl')";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			System.out.println("�����������û���Ϣ��ʧ�ܣ�");
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
			System.out.println("�����������ݱ�ʧ�ܣ�");
			System.err.println(e.getMessage());
		}
	}

}
