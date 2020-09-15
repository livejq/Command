package com.zhl.archives;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zhl.bean.Fresh;
import com.zhl.bean.Provide;
import com.zhl.importdb.DataDao;
import com.zhl.util.Refresh;

public class InsertCommand extends JFrame{
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
	private JButton closeButton;
	JTextArea remarkTextArea = new JTextArea();
	private String cata[] = {"文件管理","文件传输","文档编辑","磁盘管理","磁盘维护","网络通信","系统管理","系统设置","备份压缩","其它","X-Window","电子邮件与新闻组","附录"};
	private JLabel label_1;
	private JLabel label_5;
	private JLabel label_8;
	private JLabel label_9;
	/**
	 * Create the frame.
	 */
	public InsertCommand() {
		setTitle("添加命令");	
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setIconImage(getToolkit().getImage(
	            getClass().getResource("linuxIcon.png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font labelFont=new Font("行楷",Font.PLAIN ,12);
		cmdLabel = new JLabel("命令：");
		cmdLabel.setBounds(49, 53, 40, 15);
		cmdLabel.setFont(labelFont);
		contentPane.add(cmdLabel);

		cmdTextField = new JTextField();
		cmdTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cmdTextField);
		cmdTextField.setColumns(10);

		allNameLabel = new JLabel("全称：");
		allNameLabel.setBounds(321, 53, 40, 15);
		allNameLabel.setFont(labelFont);
		contentPane.add(allNameLabel);

		allNameTextField = new JTextField();
		allNameTextField.setColumns(10);
		allNameTextField.setBounds(385, 50, 164, 25);
		contentPane.add(allNameTextField);

		uPowerLabel = new JLabel("使用权限：");
		uPowerLabel.setBounds(49, 97, 70, 15);
		uPowerLabel.setFont(labelFont);
		contentPane.add(uPowerLabel);

		uPowerTextField = new JTextField();
		uPowerTextField.setBounds(114, 94, 164, 25);
		contentPane.add(uPowerTextField);
		uPowerTextField.setColumns(10);

		syntaxLabel = new JLabel("语法：");
		syntaxLabel.setBounds(321, 97, 40, 15);
		syntaxLabel.setFont(labelFont);
		contentPane.add(syntaxLabel);

		syntaxTextField = new JTextField();
		syntaxTextField.setBounds(385, 94, 164, 25);
		contentPane.add(syntaxTextField);
		syntaxTextField.setColumns(10);

		functionLabel = new JLabel("功能：");
		functionLabel.setBounds(50, 140, 40, 15);
		functionLabel.setFont(labelFont);
		contentPane.add(functionLabel);

		functionTextField = new JTextField();
		functionTextField.setColumns(10);
		functionTextField.setBounds(114, 137, 164, 25);
		contentPane.add(functionTextField);

		addLabel = new JLabel("补充说明：");
		addLabel.setBounds(321, 140, 70, 15);
		addLabel.setFont(labelFont);
		contentPane.add(addLabel);

		addTextField = new JTextField();
		addTextField.setColumns(10);
		addTextField.setBounds(385, 137, 164, 25);
		contentPane.add(addTextField);

		paramLabel = new JLabel("参数：");
		paramLabel.setBounds(49, 180, 40, 15);
		paramLabel.setFont(labelFont);
		contentPane.add(paramLabel);

		paramTextField = new JTextField();
		paramTextField.setColumns(10);
		paramTextField.setBounds(114, 177, 164, 25);
		contentPane.add(paramTextField);

		exampleLabel = new JLabel("例子：");
		exampleLabel.setBounds(321, 180, 40, 15);
		exampleLabel.setFont(labelFont);
		contentPane.add(exampleLabel);

		exampleTextField = new JTextField();
		exampleTextField.setColumns(10);
		exampleTextField.setBounds(385, 177, 164, 25);
		contentPane.add(exampleTextField);
		
		cataLabel = new JLabel("linux目录");
		cataLabel.setBounds(49, 223, 72, 15);
		contentPane.add(cataLabel);

		cataCombo =new JComboBox<String>(cata);
		cataCombo.setFont(labelFont);
		cataCombo.setBounds(114, 220, 164, 25);
		contentPane.add(cataCombo);

		JButton insertButton = new JButton("添加");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataDao dao = new DataDao();
				Provide provide = new Provide();
				String cmd = cmdTextField.getText();
				String allName = allNameTextField.getText();
				String uPower = uPowerTextField.getText();
				String syntax = syntaxTextField.getText();
				String function = functionTextField.getText();
				String add = addTextField.getText();
				String param = paramTextField.getText();
				String example = exampleTextField.getText();
				String ctg = (String) cataCombo.getSelectedItem();
				
				if((cmd.equals(""))||(function.equals(""))||(example.equals(""))){
					JOptionPane.showMessageDialog(getContentPane(), "请将带星号的信息填写完整！",
							"温馨提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				provide.setCommand(cmd);
				provide.setFullname(allName);
				provide.setUpower(uPower);
				provide.setSyntax(syntax);
				provide.setFuncexplain(function);
				provide.setAddexplain(add);				
				provide.setParam(param);
				provide.setExample(example);
				provide.setId(ctg);
				dao.insertProvide(provide);
				JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！",
						"添加命令", JOptionPane.INFORMATION_MESSAGE);
				Fresh fresh = new Fresh();
				fresh.setRefresh(true);
				Refresh.setFresh(fresh);
				InsertCommand.this.dispose();
				
			}
		});
		insertButton.setBounds(185, 388, 93, 23);
		contentPane.add(insertButton);

		closeButton = new JButton("退出");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(342, 388, 93, 23);
		contentPane.add(closeButton);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(283, 53, 6, 15);
		contentPane.add(label_1);
		
		label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(283, 140, 6, 15);
		contentPane.add(label_5);
		
		label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBounds(554, 179, 6, 15);
		contentPane.add(label_8);
		
		label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setBounds(283, 223, 6, 15);
		contentPane.add(label_9);
	}

	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
