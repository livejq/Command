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
		hashtable.put("�ļ�����","1");
		hashtable.put("�ļ�����","2");
		hashtable.put("�ĵ��༭","3");
		hashtable.put("���̹���","4");
		hashtable.put("����ά��","5");
		hashtable.put("����ͨ��","6");
		hashtable.put("ϵͳ����","7");
		hashtable.put("ϵͳ����","8");
		hashtable.put("����ѹ��","9");
		hashtable.put("����","10");
		hashtable.put("X-Window","11");
		hashtable.put("�����ʼ���������","12");///???????���ڲ������⣿ԭ����InsertCommand��Ĵ��ַ��������
		hashtable.put("��¼","13");
		
		if(hashtable.containsKey(cata)) {
			String i = hashtable.get(cata);
			this.id = Integer.parseInt(i);
		}
	}
	
	public String getCata() {
		return catalogue;
	}
	public void setCata(String id) {
		hashtable.put("1","�ļ�����");
		hashtable.put("2","�ļ�����");
		hashtable.put("3","�ĵ��༭");
		hashtable.put("4","���̹���");
		hashtable.put("5","����ά��");
		hashtable.put("6","����ͨ��");
		hashtable.put("7","ϵͳ����");
		hashtable.put("8","ϵͳ����");
		hashtable.put("9","����ѹ��");
		hashtable.put("10","����");
		hashtable.put("11","X-Window");
		hashtable.put("12","�����ʼ���������");
		hashtable.put("13","��¼");
		
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
