package com.zhl.bean;

public class User {
	private int id;				//定义映射主键的属性
	private String userName;	//定义映射用户名的属性
	private String password;	//定义映射密码的属性
	public int getId() {		//id属性的getXXX()方法
		return id;
	}
	public void setId(int id) {	//id属性的setXXX()方法
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
