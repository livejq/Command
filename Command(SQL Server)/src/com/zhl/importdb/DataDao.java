package com.zhl.importdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTree;

import com.zhl.bean.Provide;
import com.zhl.connection.GetConnection;

public class DataDao {
	GetConnection connection = new GetConnection();
	Connection conn = null;
	JTree tree;
	String str[]= new String[9];
	
	//≤È—Ø√¸¡Ó
	public String [] getCmd(String cmd) {
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			String sql = "select * from tb_study where command = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, cmd);
			ResultSet rest = ptmt.executeQuery();
			if(rest.next())
				for(int i=0;i<9;i++)
					str[i] = rest.getString(i+1);
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return str;
	}
	
	
	public boolean isExist(String cmd) {
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			String sql = "select * from tb_study where command = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, cmd);
			ResultSet rest = ptmt.executeQuery();
			if(rest.next())
				return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return false;
	}
	
	//ÃÌº”√¸¡Ó
	
	public void insertProvide(Provide provide) {
		
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			PreparedStatement statement = conn
					.prepareStatement("insert into tb_study values(?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, provide.getId());
			statement.setString(2, provide.getCommand());
			statement.setString(3, provide.getFullname());
			statement.setString(4, provide.getUpower());
			statement.setString(5, provide.getSyntax());
			statement.setString(6, provide.getFuncexplain());
			statement.setString(7, provide.getAddexplain());
			statement.setString(8, provide.getParam());
			statement.setString(9, provide.getExample());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//–ﬁ∏ƒ√¸¡Ó
public boolean doModify(Provide provide) {
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			PreparedStatement statement = conn
					.prepareStatement("update tb_study set id = ?,fullname = ?,upower = ?,syntax = ?,funcexplain = ?,addexplain = ?,param = ?,example = ? where command = "+"'"+provide.getCommand()+"'");
			statement.setInt(1, provide.getId());
			statement.setString(2, provide.getFullname());
			statement.setString(3, provide.getUpower());
			statement.setString(4, provide.getSyntax());
			statement.setString(5, provide.getFuncexplain());
			statement.setString(6, provide.getAddexplain());
			statement.setString(7, provide.getParam());
			statement.setString(8, provide.getExample());
			if(statement.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//…æ≥˝√¸¡Ó
	public boolean doDelete(String cmd) {
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			String sql = "delete from tb_study where command = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, cmd);
			if((ptmt.executeUpdate())==1)
				return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return false;
	}
}
