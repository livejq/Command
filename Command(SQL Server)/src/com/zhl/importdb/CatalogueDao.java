package com.zhl.importdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.zhl.connection.GetConnection;

public class CatalogueDao {
	GetConnection connection = new GetConnection();
	Connection conn = null;
	JTree tree;
	String str[]= new String[13];
	DefaultMutableTreeNode nodes[] = new DefaultMutableTreeNode[13];
	DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
			"Linux命令目录");
	
	
	public String [] getStrCata() {
		int n = 0;
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			String sql = "select * from tb_catalogue ";
			Statement stmt = conn.createStatement();
			ResultSet rest = stmt.executeQuery(sql);
			while(rest.next()) {
				str[n] = rest.getString(2);
				n++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	public DefaultMutableTreeNode [] getNode(String [] str) {
		int n = 0;
		for(String i:str) {
			nodes[n] = new DefaultMutableTreeNode(i);
			n++;
		}
		return nodes;
	}
	
	
	public JTree getTreeCata(DefaultMutableTreeNode treeNodes[]) {
		int sum = treeNodes.length;int n = 0;
		try {
			if(conn==null||connection.getCon()==null||connection.con.isClosed())
				conn = connection.getCon();
			while(n<sum){
				String sql = "select * from tb_study where id = ?";
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setInt(1, n+1);
				ResultSet rest = ptmt.executeQuery();
				while(rest.next()) {
					DefaultMutableTreeNode node_x = new DefaultMutableTreeNode(rest.getString(2));
					treeNodes[n].add(node_x);
				}
				rootNode.add(treeNodes[n]);//注意：这个不包含在上面的while循环里
				n++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		tree = new JTree(rootNode);
		return tree;
	}
	
	
}
