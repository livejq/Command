package com.zhl.importdb;

import java.sql.*;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.zhl.bean.Provide;
import com.zhl.bean.User;
import com.zhl.connection.GetConnection;

public class UserDao {

	GetConnection connection = new GetConnection();
	Connection conn = connection.getCon();
	PreparedStatement ptmt_R;
	PreparedStatement ptmt_W;
	ResultSet rest;
	Statement stmt;
	String cata[] = new String[13];
	DefaultMutableTreeNode nodes[] = new DefaultMutableTreeNode[13];
	DefaultMutableTreeNode rootNode;
	String sql;
	JTree tree;
	
	// ��д���û����������ѯ�û�����
	public User getUser(String userName, String password) {
		User user = new User(); // ����JavaBean����
		try {
			sql = "select * from tb_users where userName = ? and password = ?"; // �����ѯԤ�������
			ptmt_R = conn.prepareStatement(sql); // ʵ����PreparedStatement����
			ptmt_R.setString(1, userName); // ����Ԥ����������
			ptmt_R.setString(2, password);
			rest = ptmt_R.executeQuery(); // ִ��Ԥ�������
			while (rest.next()) {
				user.setId(rest.getInt(1)); // Ӧ�ò�ѯ������ö�������
				user.setUserName(rest.getString(2));
				user.setPassWord(rest.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user; // ���ز�ѯ���
	}
	
	// ��д���û�����ѯ�û�����
	public boolean isUserName(String userName) {
		try {
			sql = "select * from tb_users where userName = ? "; // �����ѯԤ�������
			ptmt_R = conn.prepareStatement(sql); // ʵ����PreparedStatement����
			ptmt_R.setString(1, userName); // ����Ԥ����������
			rest = ptmt_R.executeQuery(); // ִ��Ԥ�������
			if (rest.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // ���ز�ѯ���
	}
	
	public String[] getStrCata() {
		int n = 0;
		try {
			sql = "select * from tb_catalogue ";
			stmt = conn.createStatement();
			rest = stmt.executeQuery(sql);
			while (rest.next()) {
				cata[n] = rest.getString(2);
				n++;
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cata;
	}
	
	public DefaultMutableTreeNode[] getNode(String[] str) {
		int n = 0;
		nodes = new DefaultMutableTreeNode[13];
		for (String i : str) {
			nodes[n] = new DefaultMutableTreeNode(i);
			n++;
		}
		return nodes;
	}

	public JTree getTreeCata(DefaultMutableTreeNode treeNodes[]) {
		int sum = treeNodes.length;
		rootNode = new DefaultMutableTreeNode("Linux����Ŀ¼");
		int n = 0;
		try {
			while (n < sum) {
				sql = "select * from tb_study where id = ?";
				ptmt_R = conn.prepareStatement(sql);
				ptmt_R.setInt(1, n + 1);
				rest = ptmt_R.executeQuery();
				while (rest.next()) {
					DefaultMutableTreeNode node_x = new DefaultMutableTreeNode(rest.getString(2));
					treeNodes[n].add(node_x);
				}
				rootNode.add(treeNodes[n]);// ע�⣺����������������whileѭ����
				n++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tree = new JTree(rootNode);
		return tree;
	}

	// ��ѯ����
	public String[] getCmd(String cmd) {
		String data[] = new String[9];
		try {
			sql = "select * from tb_study where command = ?";
			ptmt_R = conn.prepareStatement(sql);
			ptmt_R.setString(1, cmd);
			rest = ptmt_R.executeQuery();
			if (rest.next())
				for (int i = 0; i < 9; i++)
					data[i] = rest.getString(i + 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean isExist(String cmd) {
		try {
			sql = "select * from tb_study where command = ?";
			ptmt_R = conn.prepareStatement(sql);
			ptmt_R.setString(1, cmd);
			rest = ptmt_R.executeQuery();
			if (rest.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// �������

	public void insertProvide(Provide provide) {

		try {
			ptmt_W = conn.prepareStatement("insert into tb_study values(?,?,?,?,?,?,?,?,?)");
			ptmt_W.setInt(1, provide.getId());
			ptmt_W.setString(2, provide.getCommand());
			ptmt_W.setString(3, provide.getFullname());
			ptmt_W.setString(4, provide.getUpower());
			ptmt_W.setString(5, provide.getSyntax());
			ptmt_W.setString(6, provide.getFuncexplain());
			ptmt_W.setString(7, provide.getAddexplain());
			ptmt_W.setString(8, provide.getParam());
			ptmt_W.setString(9, provide.getExample());
			ptmt_W.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �޸�����
	public boolean doModify(Provide provide) {
		try {
			ptmt_W = conn.prepareStatement(
					"update tb_study set id = ?,fullname = ?,upower = ?,syntax = ?,funcexplain = ?,addexplain = ?,param = ?,example = ? where command = '"
							+ provide.getCommand() + "'");
			ptmt_W.setInt(1, provide.getId());
			ptmt_W.setString(2, provide.getFullname());
			ptmt_W.setString(3, provide.getUpower());
			ptmt_W.setString(4, provide.getSyntax());
			ptmt_W.setString(5, provide.getFuncexplain());
			ptmt_W.setString(6, provide.getAddexplain());
			ptmt_W.setString(7, provide.getParam());
			ptmt_W.setString(8, provide.getExample());
			if (ptmt_W.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ɾ������
	public boolean doDelete(String cmd) {
		try {
			sql = "delete from tb_study where command = ?";
			ptmt_W = conn.prepareStatement(sql);
			ptmt_W.setString(1, cmd);
			if ((ptmt_W.executeUpdate()) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

