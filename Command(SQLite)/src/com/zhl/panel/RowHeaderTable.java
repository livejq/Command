package com.zhl.panel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
		//表格生成类  
	public class RowHeaderTable {          

		private JTable dataTable;     
		private DefaultTableModel dataTableModel;
		
		public void addRow(Object[] rowHeader){       
			if(dataTableModel == null){             
//				String [] header = {""};
				dataTableModel = new DefaultTableModel(0, 2);             
//				dataTableModel.setColumnIdentifiers(header);                          
				dataTable = new JTable(dataTableModel);
//				dataTable.getColumnModel().getColumn(0);
				JTableHeader header = dataTable.getTableHeader();
				header.setVisible(false);
				dataTable.setDefaultRenderer(dataTable.getColumnClass(0), new RowDataRenderer());
				}
			for(int i=0; i<rowHeader.length; i++){  //把横列转为纵列                
				Object[] value = {rowHeader[i]};             
				dataTableModel.addRow(value); //重写的绘制器可以由此得到行数
				}                  
			}         
		
		
		public void removeAllRow(){         
			if(dataTableModel != null){             
				dataTableModel.setRowCount(0);         
				}             
			}          
		
		
		public DefaultTableModel getModel(){//用来添加当点击单个命令树节点时所查询到的详细数据         
			return dataTableModel;
			}         
		
		
		public void stopCellEditing(){         
			if(dataTable.getCellEditor() != null){             
				dataTable.getCellEditor().stopCellEditing();         
				}     
			}            
		
		
		public JScrollPane getScrollPane() {         /* 将table加入JScrollPane */                 
			JScrollPane scrollPane = new JScrollPane(dataTable);            
			return scrollPane;
			} 
		
}