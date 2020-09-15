package com.zhl.bean;

import java.util.HashMap;

public class Provide {
	int id;
	private String catalogue;
	private String command;
	private String fullname;
	private String upower;
	private String syntax;
	private String funcexplain;
	private String addexplain;
	private String param;
	private String example;
	HashMap<String,String> hashtable = new HashMap<String,String>();
	
	public int getId() {
		return id;
	}
	public void setId(String cata) {
		hashtable.put("文件管理","1");
		hashtable.put("文件传输","2");
		hashtable.put("文档编辑","3");
		hashtable.put("磁盘管理","4");
		hashtable.put("磁盘维护","5");
		hashtable.put("网络通信","6");
		hashtable.put("系统管理","7");
		hashtable.put("系统设置","8");
		hashtable.put("备份压缩","9");
		hashtable.put("其它","10");
		hashtable.put("X-Window","11");
		hashtable.put("电子邮件与新闻组","12");///???????存在插入问题？原来是InsertCommand里的此字符输入错误
		hashtable.put("附录","13");
		
		if(hashtable.containsKey(cata)) {
			String i = hashtable.get(cata);
			this.id = Integer.parseInt(i);
		}
	}
	
	public String getCata() {
		return catalogue;
	}
	public void setCata(String id) {
		hashtable.put("1","文件管理");
		hashtable.put("2","文件传输");
		hashtable.put("3","文档编辑");
		hashtable.put("4","磁盘管理");
		hashtable.put("5","磁盘维护");
		hashtable.put("6","网络通信");
		hashtable.put("7","系统管理");
		hashtable.put("8","系统设置");
		hashtable.put("9","备份压缩");
		hashtable.put("10","其它");
		hashtable.put("11","X-Window");
		hashtable.put("12","电子邮件与新闻组");
		hashtable.put("13","附录");
		
		if(hashtable.containsKey(id)) {
			String str = hashtable.get(id);
			this.catalogue = str;
		}
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getUpower() {
		return upower;
	}
	public void setUpower(String upower) {
		this.upower = upower;
	}
	
	public String getSyntax() {
		return syntax;
	}
	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}
	
	public String getFuncexplain() {
		return funcexplain;
	}
	public void setFuncexplain(String funcexplain) {
		this.funcexplain = funcexplain;
	}
	
	public String getAddexplain() {
		return addexplain;
	}
	public void setAddexplain(String addexplain) {
		this.addexplain = addexplain;
	}
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
}
