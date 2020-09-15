package com.zhl.archives;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zhl.bean.Fresh;
import com.zhl.bean.Provide;
import com.zhl.importdb.DataDao;
import com.zhl.util.Refresh;

public class ModifyCommand extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel cmdLabel;
	private JTextField cmdTextField;
	private JLabel allNameLabel;
	private JTextField allNameTextField;
	private JLabel uPowerLabel;
	private JTextField uPowerTextField;
	private JLabel syntaxLabel;
	private JTextField syntaxTextField;
	private JLabel functionLabel;
	private JTextField functionTextField;
	private JLabel addLabel;
	private JTextField addTextField;
	private JLabel paramLabel;
	private JTextField paramTextField;
	private JLabel exampleLabel;
	private JTextField exampleTextField;
	private JLabel cataLabel;
	private JComboBox<String> cataCombo;
	private String cata[] = {"�ļ�����","�ļ�����","�ĵ��༭","���̹���","����ά��","����ͨ��","ϵͳ����","ϵͳ����","����ѹ��","����","X-Window","�����ʼ���������","��¼"};
	private JButton closeButton;
	/**
	 * Create the frame.
	 */
	public ModifyCommand() {
		setTitle("�޸�����");	
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setIconImage(getToolkit().getImage(
	            getClass().getResource("linuxIcon.png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font labelFont=new Font("�п�",Font.PLAIN ,12);
		cmdLabel = new JLabel("���");
		cmdLabel.setBounds(49, 53, 40, 15);
		cmdLabel.setFont(labelFont);
		contentPane.add(cmdLabel);

		cmdTextField = new JTextField();
		cmdTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cmdTextField);
		cmdTextField.addKeyListener(new QueryResult());
		cmdTextField.setColumns(10);

		allNameLabel = new JLabel("ȫ�ƣ�");
		allNameLabel.setBounds(321, 53, 40, 15);
		allNameLabel.setFont(labelFont);
		contentPane.add(allNameLabel);

		allNameTextField = new JTextField();
		allNameTextField.setColumns(10);
		allNameTextField.setBounds(385, 50, 164, 25);
		contentPane.add(allNameTextField);

		uPowerLabel = new JLabel("ʹ��Ȩ�ޣ�");
		uPowerLabel.setBounds(49, 97, 70, 15);
		uPowerLabel.setFont(labelFont);
		contentPane.add(uPowerLabel);

		uPowerTextField = new JTextField();
		uPowerTextField.setBounds(114, 94, 164, 25);
		contentPane.add(uPowerTextField);
		uPowerTextField.setColumns(10);

		syntaxLabel = new JLabel("�﷨��");
		syntaxLabel.setBounds(321, 97, 40, 15);
		syntaxLabel.setFont(labelFont);
		contentPane.add(syntaxLabel);

		syntaxTextField = new JTextField();
		syntaxTextField.setBounds(385, 94, 164, 25);
		contentPane.add(syntaxTextField);
		syntaxTextField.setColumns(10);

		functionLabel = new JLabel("���ܣ�");
		functionLabel.setBounds(50, 140, 40, 15);
		functionLabel.setFont(labelFont);
		contentPane.add(functionLabel);

		functionTextField = new JTextField();
		functionTextField.setColumns(10);
		functionTextField.setBounds(114, 137, 164, 25);
		contentPane.add(functionTextField);

		addLabel = new JLabel("����˵����");
		addLabel.setBounds(321, 140, 70, 15);
		addLabel.setFont(labelFont);
		contentPane.add(addLabel);

		addTextField = new JTextField();
		addTextField.setColumns(10);
		addTextField.setBounds(385, 137, 164, 25);
		contentPane.add(addTextField);

		paramLabel = new JLabel("������");
		paramLabel.setBounds(49, 180, 40, 15);
		paramLabel.setFont(labelFont);
		contentPane.add(paramLabel);

		paramTextField = new JTextField();
		paramTextField.setColumns(10);
		paramTextField.setBounds(114, 177, 164, 25);
		contentPane.add(paramTextField);

		exampleLabel = new JLabel("���ӣ�");
		exampleLabel.setBounds(321, 180, 40, 15);
		exampleLabel.setFont(labelFont);
		contentPane.add(exampleLabel);

		exampleTextField = new JTextField();
		exampleTextField.setColumns(10);
		exampleTextField.setBounds(385, 177, 164, 25);
		contentPane.add(exampleTextField);
		
		cataLabel = new JLabel("linuxĿ¼");
		cataLabel.setBounds(49, 223, 72, 15);
		contentPane.add(cataLabel);

		cataCombo =new JComboBox<String>(cata);
		cataCombo.setFont(labelFont);
		cataCombo.setBounds(114, 220, 164, 25);
		contentPane.add(cataCombo);
		
		JButton modifyButton = new JButton("�޸�");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = cmdTextField.getText();
				if(cmd.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "����δ�������",
							"��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				DataDao dao = new DataDao();
				
				if(!dao.isExist(cmd)) {
					JOptionPane.showMessageDialog(getContentPane(), "��Ǹ�����������",
							"����", JOptionPane.WARNING_MESSAGE);
				}else {
					Provide provide = new Provide();
					String allName = allNameTextField.getText();
					String uPower = uPowerTextField.getText();
					String syntax = syntaxTextField.getText();
					String function = functionTextField.getText();
					String add = addTextField.getText();
					String param = paramTextField.getText();
					String example = exampleTextField.getText();
					String ctg = (String) cataCombo.getSelectedItem();
					provide.setCommand(cmd);
					provide.setFullname(allName);
					provide.setUpower(uPower);
					provide.setSyntax(syntax);
					provide.setFuncexplain(function);
					provide.setAddexplain(add);				
					provide.setParam(param);
					provide.setExample(example);
					provide.setId(ctg);
					if(dao.doModify(provide)) {
						JOptionPane.showMessageDialog(getContentPane(), "��ϲ���޸ĳɹ�",
								"�޸ĳɹ�", JOptionPane.DEFAULT_OPTION);
						
						Fresh fresh = new Fresh();
						fresh.setRefresh(true);
						Refresh.setFresh(fresh);
						ModifyCommand.this.dispose();
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "�޷��޸Ĵ����",
								"������ʾ", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		modifyButton.setBounds(185, 388, 93, 23);
		contentPane.add(modifyButton);

		closeButton = new JButton("�˳�");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(342, 388, 93, 23);
		contentPane.add(closeButton);
		
	}

	class QueryResult implements KeyListener{
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
				String cmd = cmdTextField.getText();
				if(cmd.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "����δ�������",
							"��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					DataDao dao = new DataDao();
					if(!dao.isExist(cmd)) {
						JOptionPane.showMessageDialog(getContentPane(), "��Ǹ�����������",
								"��ѯʧ��", JOptionPane.ERROR_MESSAGE);
					}else {
						String str[] = dao.getCmd(cmd);
						Provide provide = new Provide();
						allNameTextField.setText(str[2]);
						uPowerTextField.setText(str[3]);
						syntaxTextField.setText(str[4]);
						functionTextField.setText(str[5]);
						addTextField.setText(str[6]);
						paramTextField.setText(str[7]);
						exampleTextField.setText(str[8]);
						provide.setCata(str[0]);
						for(int i=0;i<cata.length;i++) {
							if(cata[i].equals(provide.getCata()))
								cataCombo.setSelectedIndex(i);
						}
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
	}
	
	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}

}
