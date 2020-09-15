package com.zhl.mainFrame;

import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.zhl.archives.DeleteCommand;
import com.zhl.archives.InsertCommand;
import com.zhl.archives.ModifyCommand;
import com.zhl.bean.Fresh;
import com.zhl.bean.User;
import com.zhl.importdb.CatalogueDao;
import com.zhl.importdb.DataDao;
import com.zhl.panel.DetailTable;
import com.zhl.panel.MyJPanel;
import com.zhl.util.Refresh;
import com.zhl.util.Session;
import com.zhl.widget.BGPanel;
import com.zhl.widget.GlassButton;

public class RemovableFrame extends MainFrame implements MouseListener,KeyListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyJPanel contentPane = null;
	private JScrollPane tablePanel = null;
	private JScrollPane command = null;
	private BGPanel jPanel = null;
	private GlassButton StudyButton = null;
	private GlassButton AllcmdButton = null;
	private BGPanel backPanel,panel_1 = null;
	private DetailTable table_1 = new DetailTable();
	private DefaultTableModel dataModel;
	private JButton queryButton,updateButton,deleteButton,insertButton,turnoffButton;
	private JTextField cmdTextField;
	private JLabel cmdLabel;
	public String cmd;
	public boolean refresh = false;
	
	
	public RemovableFrame() {
		setTitle("Linux֮·");
		contentPane = new MyJPanel();
		//Ϊ��û�е���MyJPanel������ķ���paintComponent()ȴ����ʾ�˷����������õı���ͼ��
		//(�ѽ������Ϊ��д�˴Ӹ���̳еķ���)
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.add(getJPanel());
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getCataloguePane());

		User user =	Session.getUser();		
		String infor = "<html><body>" + "<font color=#FFFFFF>��ӭ��</font>"
				+ "<font color=black><b>" + user.getUserName() + "</font>"
				+ "</body></html>";
		JLabel label = new JLabel(infor);//������ʾָ�����ݵı�ǩ����
		label.setBounds(715, 10, 128, 39);
		Font labelFont=new Font("�п�",Font.BOLD ,20);
		label.setFont(labelFont);
		contentPane.add(label);
		contentPane.add(getContentPane("ѧϰ�ó�"));
		PrimeRun p = new PrimeRun(143);
		new Thread(p).start();
	}

	
	public JScrollPane setSearchTree() {
		CatalogueDao cmd = new CatalogueDao();
		String str[] = cmd.getStrCata();
		DefaultMutableTreeNode nodes[] = cmd.getNode(str);
		JTree tree = cmd.getTreeCata(nodes);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				if (!tree.isSelectionEmpty()) {
					TreePath selectionPaths = tree.getSelectionPath();
					Object path = selectionPaths.getLastPathComponent();
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
					String cmd = (String) node.getUserObject();
					DataDao data = new DataDao();
					String str[] = data.getCmd(cmd);
					dataModel = table_1.getModel();
		
						for(int i=1;i<str.length;i++)
							dataModel.setValueAt(str[i], i-1, 1);
						repaint();
					
				}
				
			}
			
		});
		command = new JScrollPane();//�����һ����ͼ
		command.setBounds(20, 15, 235, 442);
		command.getViewport().setOpaque(false);
		command.getViewport().setBackground(new Color(91,69,187));
		command.setViewportBorder(new EmptyBorder(5,5,5,5));
		command.setViewportView(tree);
		
		return command;
	}
	
	
	public BGPanel getCataloguePane() {
		if(panel_1 == null) {
			panel_1 = new BGPanel();
			panel_1.setBackground(new Color(91,69,187));
			panel_1.setBounds(0, 113, 270, 467);
			panel_1.setBorder(createTitledBorder(null,null,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.TOP));
			panel_1.setLayout(null);
			command = setSearchTree();
			panel_1.add(command);
		}
		return panel_1;
	}
	
	public  boolean isLegal(String str){
		if(str==null||str.equals("")||str.contains(" "))
			return false;
		return true;
	}
	
	public BGPanel getContentPane(String title) {
		if(backPanel == null) {
			backPanel = new BGPanel();
			backPanel.setBackground(new Color(91,69,187));
			backPanel.setSize(590,467);
			backPanel.setLocation(289,113);
			backPanel.setLayout(null);
			backPanel.setBorder(createTitledBorder(null,title,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.TOP,new Font("����",Font.BOLD,17),Color.YELLOW));
		
			tablePanel = table_1.getScrollPane();
			tablePanel.setBounds(20, 70, 550, 330);
//			tablePanel.getViewport().setBackground(Color.blue);
			backPanel.add(tablePanel);
		}
		cmdLabel = new JLabel("��������:");
		cmdLabel.setBounds(97, 27, 100, 40);
		Font labelFont=new Font("����",Font.BOLD ,20);
		cmdLabel.setFont(labelFont);
		backPanel.add(cmdLabel);

		cmdTextField = new JTextField();
		cmdTextField.setBounds(190, 30, 100, 35);
		cmdTextField.addKeyListener(this);
		backPanel.add(cmdTextField);

		queryButton = new JButton("����");
		queryButton.setBounds(300,27,100,40);
		queryButton.setFont(labelFont);
		backPanel.add(queryButton);
		
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals("����")){
					if(!isLegal(cmdTextField.getText())){
						JOptionPane.showMessageDialog(getContentPane(),"�����������淶��Ϊ�ջ�����ո�",
								"����Ƿ�",JOptionPane.WARNING_MESSAGE);
						cmdTextField.requestFocus();
						cmdTextField.setText("");
						
					}else if(cmdTextField.getText().matches("[0123456789]+")){
						JOptionPane.showMessageDialog(getContentPane(),"������������ȷ������ܴ����֣�",
								"����Ƿ�",JOptionPane.WARNING_MESSAGE);
						cmdTextField.requestFocus();
						cmdTextField.setText("");	
					}else{
						DataDao data = new DataDao();
						String rst = cmdTextField.getText();
						if(!data.isExist(rst)) {
							JOptionPane.showMessageDialog(getContentPane(),"��Ǹ��δ��������������",
									"�������",JOptionPane.ERROR_MESSAGE);
							cmdTextField.requestFocus();
							cmdTextField.setText("");
						}else {
							String str[] = data.getCmd(rst);
							dataModel = table_1.getModel();
							for(int i=1;i<str.length;i++)
								dataModel.setValueAt(str[i], i-1, 1);
							repaint();
						}	
					}		
				}
			}
		});
		
		
		insertButton = new JButton("���");
		insertButton.setBounds(80,415,100,40);
		insertButton.setFont(labelFont);
		backPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCommand insertProvide = new InsertCommand();
				insertProvide.setVisible(true);
			}
		});
		
		updateButton = new JButton("�޸�");
		updateButton.setBounds(190,415,100,40);
		updateButton.setFont(labelFont);
		backPanel.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyCommand modifyProvide = new ModifyCommand();
				modifyProvide.setVisible(true);
		}});
		
		deleteButton = new JButton("ɾ��");
		deleteButton.setBounds(300,415,100,40);
		deleteButton.setFont(labelFont);
		backPanel.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCommand deleteProvide = new DeleteCommand();
				deleteProvide.setVisible(true);
		}});
		turnoffButton = new JButton("�˳�");
		turnoffButton.setBounds(410,415,100,40);
		turnoffButton.setFont(labelFont);
		backPanel.add(turnoffButton);
		turnoffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemovableFrame.this.dispose();
		}});
		
		return backPanel;
	}
	
	
	public BGPanel getJPanel() {
		if (jPanel == null) {
			GridLayout gridLayout = new GridLayout(1,2,0,0);	//�������񲼾ֹ�����
			//gridLayout.setRows(1);gridLayout.setHgap(0);gridLayout.setVgap(0);
			jPanel = new BGPanel();								// ���ò��ֹ�����
			jPanel.setLayout(gridLayout);						// ���ó�ʼ��С
			//jPanel.setPreferredSize(new Dimension(200, 50));
			jPanel.setOpaque(true);
			jPanel.setBackground(new Color(91,69,187));
			jPanel.setBorder(createTitledBorder(null,null,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.TOP,new Font("����",Font.BOLD,17)));
			jPanel.add(getStudyButton());
			jPanel.add(getAllcmdButton());						// ��Ӱ�ť
			
		}
		return jPanel;
	}
	
	
	private GlassButton getStudyButton() {
		if (StudyButton == null) {
			StudyButton = new GlassButton();
			StudyButton.setToolTipText("ѧϰ�ó�");
			StudyButton.setActionCommand("study");		//���ð�ť�Ķ�������
			StudyButton.setBackground(new Color(91,69,187));
//			StudyButton.setBorder(BorderFactory.createRaisedBevelBorder());
			StudyButton.setIcon(new ImageIcon(getClass().getResource(
					"/com/zhl/button/1big.png")));	//���尴ť�ĳ�ʼ������
//			StudyButton.setRolloverIcon(icon1);		//���ð�ť�ķ�תͼƬ
//			StudyButton.setSelectedIcon(icon1big);		//���ð�ť��ѡ��ʱ��ʾͼƬ
//			StudyButton.setSelected(true);			
			StudyButton.addActionListener(new ToolsButtonActionAdapter());	//��ť�ļ�����
			StudyButton.addMouseListener(this);
		}
		return StudyButton;
	}
	
	
	private GlassButton getAllcmdButton() {
		if (AllcmdButton == null) {
			AllcmdButton = new GlassButton();
			AllcmdButton.setToolTipText("�����ȫ");
			AllcmdButton.setBackground(new Color(91,69,187));
			//AllcmdButton.setBorder(BorderFactory.createRaisedBevelBorder());
			AllcmdButton.setActionCommand("cmd");		//���ð�ť�Ķ�������
			AllcmdButton.setIcon(new ImageIcon(getClass().getResource(
					"/com/zhl/button/2.png")));	//���尴ť�ĳ�ʼ������
//			AllcmdButton.setRolloverIcon(icon2);		//���ð�ť�ķ�תͼƬ
//			AllcmdButton.setSelectedIcon(icon2big);		//���ð�ť��ѡ��ʱ��ʾͼƬ
			AllcmdButton.setSelected(true);			
			AllcmdButton.addActionListener(new ToolsButtonActionAdapter());	//��ť�ļ�����
			AllcmdButton.addMouseListener(this);
		}
		return AllcmdButton;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GlassButton sbtn = (GlassButton)e.getSource();
		if(sbtn==StudyButton) {
			StudyButton.setIcon(new ImageIcon(getClass().getResource(
					"/com/zhl/button/1big.png")));
			AllcmdButton.setIcon(new ImageIcon(getClass().getResource(
					"/com/zhl/button/2.png")));
			sbtn.setPaintFlag(true);
		}else if(sbtn==AllcmdButton) {
			StudyButton.setIcon(new ImageIcon(getClass().getResource(
					"/com/zhl/button/1.png")));
			AllcmdButton.setIcon(new ImageIcon(getClass().getResource(
					"/com/zhl/button/2big.png")));
			sbtn.setPaintFlag(true);
		}else {}
		repaint();	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseEntered(MouseEvent e) {
		GlassButton sbtn = (GlassButton)e.getSource();
		sbtn.setPaintFlag(true);
		repaint();
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		GlassButton sbtn = (GlassButton)e.getSource();
		sbtn.setPaintFlag(false);
		repaint();
	}
	
	class ToolsButtonActionAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == StudyButton) {
				panel_1.removeAll();
				backPanel.removeAll();
				panel_1.add(command);
				backPanel.setBorder(createTitledBorder(null,"ѧϰ�ó�",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.TOP,new Font("����",Font.BOLD,17),Color.YELLOW));
				backPanel.add(tablePanel);
				backPanel.add(cmdLabel);
				backPanel.add(tablePanel);
				backPanel.add(cmdTextField);
				backPanel.add(queryButton);
				backPanel.add(insertButton);
				backPanel.add(deleteButton);
				backPanel.add(updateButton);
				backPanel.add(turnoffButton);
				repaint();
			}
			if (e.getSource() == AllcmdButton) {
				panel_1.removeAll();
				backPanel.removeAll();
				backPanel.setBorder(createTitledBorder(null,null,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.TOP,new Font("����",Font.BOLD,17),Color.YELLOW));
//				panel_1.add();
				String infor = "<html><body>" + "<font color=white><b>" + "�����ڴ���"
						+ "</font>"+ "</body></html>";
				JLabel future = new JLabel(infor);
				future.setBounds(170, 210, 400, 200);
				Font font =new Font("�п�",Font.BOLD ,45);
				future.setFont(font);
				backPanel.add(future);
				repaint();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			if(!isLegal(cmdTextField.getText())){
				JOptionPane.showMessageDialog(getContentPane(),"�����������淶��Ϊ�ջ�����ո�",
						"����Ƿ�",JOptionPane.WARNING_MESSAGE);
				cmdTextField.requestFocus();
				cmdTextField.setText("");
				
			}else if(cmdTextField.getText().matches("[0123456789]+")){
				JOptionPane.showMessageDialog(getContentPane(),"������������ȷ������ܴ����֣�",
						"����Ƿ�",JOptionPane.WARNING_MESSAGE);
				cmdTextField.requestFocus();
				cmdTextField.setText("");	
			}else{
				DataDao data = new DataDao();
				String rst = cmdTextField.getText();
				if(!data.isExist(rst)) {
					JOptionPane.showMessageDialog(getContentPane(),"��Ǹ��δ��������������",
							"�������",JOptionPane.ERROR_MESSAGE);
					cmdTextField.requestFocus();
					cmdTextField.setText("");
				}else {
					String str[] = data.getCmd(rst);
					dataModel = table_1.getModel();
					for(int i=1;i<str.length;i++)
						dataModel.setValueAt(str[i], i-1, 1);
					repaint();
				}	
			}		
		}
		
	}
	
	class PrimeRun implements Runnable {
        long minPrime;
        PrimeRun(long minPrime) {
            this.minPrime = minPrime;
        }

        public void run() {
           while(true) {
        	   Fresh fresh = Refresh.getFresh();
        	   try {
	        	   if(fresh.isRefresh()) {
	        		   panel_1.removeAll();
	        		   panel_1.add(setSearchTree());
	        		   Refresh.setFresh(null);			//ÿ�ε�����ɾ�Ĳ�ˢ���������ˢ�¶���Ϊnull����
	        	   }
        	   }catch(NullPointerException e) {
        		   
        	   }
           }
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
