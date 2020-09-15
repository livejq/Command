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
	private static final Font font = new Font("����",Font.PLAIN,19);
	public RowDataRenderer() {
		setLineWrap(true);				//�����ı����Ļ��в��ԡ��������Ϊ true�����еĳ��ȴ���������Ŀ��ʱ��������
		setWrapStyleWord(true);			//�����������ʹ˷���ͬʱ����Ϊtrue�����еĳ��ȴ���������Ŀ��ʱ�����ڵ��ʱ߽磨���հף������С��������Ϊ false�������ַ��߽紦����
	}
	
	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int col) {
		int maxPreferredHeight = 0;
		
		for(int i = 0;i<table.getColumnCount();i++) {
			setText(""+table.getValueAt(row, i));			//��ʼ����������(���á�������Ϊ���û�����ó�ʼֵʱ����ʾΪ����ֵ������null)
			setSize(table.getColumnModel().getColumn(col).getWidth(),0);//��ʼ�����ÿ�е��п��߶ȸ������ݽ��е�������ʼֵΪ0��
			maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
		}
		if(table.getRowHeight()!=maxPreferredHeight) 		//����ǳ���Ҫ,ʹ��ʾ���ݵ����ʸ߶���Ч������
			table.setRowHeight(row,maxPreferredHeight);
		table.setEnabled(false);
		setText(value==null?"":value.toString());
		setForeground(Foreground);
		setFont(font);
		return this;
	}

}
