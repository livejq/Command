package com.zhl.bean;

public class User {
	private int id;				//����ӳ������������
	private String userName;	//����ӳ���û���������
	private String password;	//����ӳ�����������
	public int getId() {		//id���Ե�getXXX()����
		return id;
	}
	public void setId(int id) {	//id���Ե�setXXX()����
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return password;
	}
	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	
}
