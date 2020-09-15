package com.zhl.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class RowDataRenderer extends JTextArea implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color Foreground = new Color(91,69,187);
	private static final Font font = new Font("楷体",Font.PLAIN,19);
	public RowDataRenderer() {
		setLineWrap(true);				//设置文本区的换行策略。如果设置为 true，则当行的长度大于所分配的宽度时，将换行
		setWrapStyleWord(true);			//若上述方法和此方法同时设置为true，则当行的长度大于所分配的宽度时，将在单词边界（即空白）处换行。如果设置为 false，则将在字符边界处换行
	}
	
	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int col) {
		int maxPreferredHeight = 0;
		
		for(int i = 0;i<table.getColumnCount();i++) {
			setText(""+table.getValueAt(row, i));			//初始化表格的数据(设置“”是因为如果没有设置初始值时，显示为“”值而不是null)
			setSize(table.getColumnModel().getColumn(col).getWidth(),0);//初始化表格每列的列宽（高度根据内容进行调整，初始值为0）
			maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
		}
		if(table.getRowHeight()!=maxPreferredHeight) 		//这个非常重要,使显示内容的最适高度生效！！！
			table.setRowHeight(row,maxPreferredHeight);
		table.setEnabled(false);
		setText(value==null?"":value.toString());
		setForeground(Foreground);
		setFont(font);
		return this;
	}

}
