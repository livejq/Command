package com.zhl.archives;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.zhl.bean.Fresh;
import com.zhl.bean.Provide;
import com.zhl.connection.Instance;
import com.zhl.importdb.UserDao;
import com.zhl.util.Refresh;

public class DeleteCommand extends JFrame {
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
	private JTextField cataTextField;
	private JButton closeButton;

	/**
	 * Create the frame.
	 */
	public DeleteCommand() {
		setTitle("删除命令");
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setIconImage(getToolkit().getImage(getClass().getResource("linuxIcon.png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font labelFont = new Font("行楷", Font.PLAIN, 12);
		cmdLabel = new JLabel("命令：");
		cmdLabel.setBounds(49, 53, 40, 15);
		cmdLabel.setFont(labelFont);
		contentPane.add(cmdLabel);

		cmdTextField = new JTextField();
		cmdTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cmdTextField);
		cmdTextField.addKeyListener(new QueryResult());
		cmdTextField.setColumns(10);

		allNameLabel = new JLabel("全称：");
		allNameLabel.setBounds(321, 53, 40, 15);
		allNameLabel.setFont(labelFont);
		contentPane.add(allNameLabel);

		allNameTextField = new JTextField();
		allNameTextField.setColumns(10);
		allNameTextField.setEditable(false);
		allNameTextField.setBounds(385, 50, 164, 25);
		contentPane.add(allNameTextField);

		uPowerLabel = new JLabel("使用权限：");
		uPowerLabel.setBounds(49, 97, 70, 15);
		uPowerLabel.setFont(labelFont);
		contentPane.add(uPowerLabel);

		uPowerTextField = new JTextField();
		uPowerTextField.setBounds(114, 94, 164, 25);
		uPowerTextField.setEditable(false);
		contentPane.add(uPowerTextField);
		uPowerTextField.setColumns(10);

		syntaxLabel = new JLabel("语法：");
		syntaxLabel.setBounds(321, 97, 40, 15);
		syntaxLabel.setFont(labelFont);
		contentPane.add(syntaxLabel);

		syntaxTextField = new JTextField();
		syntaxTextField.setBounds(385, 94, 164, 25);
		syntaxTextField.setEditable(false);
		contentPane.add(syntaxTextField);
		syntaxTextField.setColumns(10);

		functionLabel = new JLabel("功能：");
		functionLabel.setBounds(50, 140, 40, 15);
		functionLabel.setFont(labelFont);
		contentPane.add(functionLabel);

		functionTextField = new JTextField();
		functionTextField.setColumns(10);
		functionTextField.setBounds(114, 137, 164, 25);
		functionTextField.setEditable(false);
		contentPane.add(functionTextField);

		addLabel = new JLabel("补充说明：");
		addLabel.setBounds(321, 140, 70, 15);
		addLabel.setFont(labelFont);
		contentPane.add(addLabel);

		addTextField = new JTextField();
		addTextField.setColumns(10);
		addTextField.setBounds(385, 137, 164, 25);
		addTextField.setEditable(false);
		contentPane.add(addTextField);

		paramLabel = new JLabel("参数：");
		paramLabel.setBounds(49, 180, 40, 15);
		paramLabel.setFont(labelFont);
		contentPane.add(paramLabel);

		paramTextField = new JTextField();
		paramTextField.setColumns(10);
		paramTextField.setBounds(114, 177, 164, 25);
		paramTextField.setEditable(false);
		contentPane.add(paramTextField);

		exampleLabel = new JLabel("例子：");
		exampleLabel.setBounds(321, 180, 40, 15);
		exampleLabel.setFont(labelFont);
		contentPane.add(exampleLabel);

		exampleTextField = new JTextField();
		exampleTextField.setColumns(10);
		exampleTextField.setBounds(385, 177, 164, 25);
		exampleTextField.setEditable(false);
		contentPane.add(exampleTextField);

		cataLabel = new JLabel("linux目录");
		cataLabel.setBounds(49, 223, 72, 15);
		contentPane.add(cataLabel);

		cataTextField = new JTextField();
		cataTextField.setFont(labelFont);
		cataTextField.setBounds(114, 220, 164, 25);
		contentPane.add(cataTextField);

		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = cmdTextField.getText();
				if (cmd.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "您还未输入命令！", "温馨提示",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				UserDao dao = Instance.getGeneral();

				if (!dao.isExist(cmd)) {
					JOptionPane.showMessageDialog(getContentPane(), "抱歉！此命令不存在", "删除失败", JOptionPane.WARNING_MESSAGE);
				} else {
					if (dao.doDelete(cmd)) {
						JOptionPane.showMessageDialog(getContentPane(), "恭喜！删除成功", "删除成功", JOptionPane.DEFAULT_OPTION);
						Fresh fresh = new Fresh();
						fresh.setRefresh(true);
						Refresh.setFresh(fresh);
						DeleteCommand.this.dispose();
					} else {
						JOptionPane.showMessageDialog(getContentPane(), "无法删除此命令！", "错误提示", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		deleteButton.setBounds(185, 388, 93, 23);
		contentPane.add(deleteButton);

		closeButton = new JButton("退出");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(342, 388, 93, 23);
		contentPane.add(closeButton);

	}

	class QueryResult implements KeyListener {
		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				String cmd = cmdTextField.getText();
				if (cmd.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "您还未输入命令！", "温馨提示",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					UserDao dao = Instance.getGeneral();
					if (!dao.isExist(cmd)) {
						JOptionPane.showMessageDialog(getContentPane(), "抱歉！此命令不存在", "查询失败", JOptionPane.ERROR_MESSAGE);
					} else {
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
						cataTextField.setText(provide.getCata());

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
