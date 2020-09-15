package com.zhl.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.zhl.panel.RowHeaderTable;

public class DetailTable extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] rowHeader= {"命令","全称","使用权限",
				"语法","功能","补充说明","参数","例子"};
	private RowHeaderTable table_1;
	private JScrollPane scrollPane;
	private DefaultTableModel dataTableModel;
	
	void init() {
		table_1 = new RowHeaderTable();
		table_1.addRow(rowHeader);
		dataTableModel = table_1.getModel(); 
		scrollPane = table_1.getScrollPane();
	}
	
	public DefaultTableModel getModel() {
		return dataTableModel;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public DetailTable() {
		init();
	}

}


