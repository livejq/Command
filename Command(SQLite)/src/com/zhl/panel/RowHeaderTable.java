package com.zhl.panel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
		//���������  
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
			for(int i=0; i<rowHeader.length; i++){  //�Ѻ���תΪ����                
				Object[] value = {rowHeader[i]};             
				dataTableModel.addRow(value); //��д�Ļ����������ɴ˵õ�����
				}                  
			}         
		
		
		public void removeAllRow(){         
			if(dataTableModel != null){             
				dataTableModel.setRowCount(0);         
				}             
			}          
		
		
		public DefaultTableModel getModel(){//������ӵ���������������ڵ�ʱ����ѯ������ϸ����         
			return dataTableModel;
			}         
		
		
		public void stopCellEditing(){         
			if(dataTable.getCellEditor() != null){             
				dataTable.getCellEditor().stopCellEditing();         
				}     
			}            
		
		
		public JScrollPane getScrollPane() {         /* ��table����JScrollPane */                 
			JScrollPane scrollPane = new JScrollPane(dataTable);            
			return scrollPane;
			} 
		
}