package com.zhl.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.zhl.bean.User;
import com.zhl.importdb.UserDao;
import com.zhl.mainFrame.RemovableFrame;
import com.zhl.util.Session;

@SuppressWarnings("serial")
public class Enter extends JFrame implements KeyListener,ActionListener{
	private BackgroundPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;//密码框
	private int count = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new Enter();
						}
					});
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	
	
	public Enter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//setLocationRelativeTo(null);将窗口显示在屏幕正中央 (此方法目测没什么用)
		setTitle("Linux之路");
		this.setIconImage(getToolkit().getImage(
	            getClass().getResource("linuxIcon.png")));
		setSize(560,280);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width/2;
		int screenHeight = screenSize.height/2;
		int height = this.getHeight();
		int width = this.getWidth();
		setLocation(screenWidth-width/2,screenHeight-height/2);
//		setUndecorated(true);
		contentPane =  getLoginPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
	}



	private BackgroundPanel getLoginPanel() {
		if(contentPane==null) {
			contentPane = new BackgroundPanel();
			contentPane.setOpaque(false);
			contentPane.setImage(getToolkit().getImage(getClass().getResource("login_linux.png")));
			contentPane.setLayout(null);
			
			JLabel userNameLabel = new JLabel("用户名：");
			userNameLabel.setBounds(40,136,110,17);
			Font labelFont=new Font("楷体",Font.BOLD ,20);
			userNameLabel.setFont(labelFont);
			userNameLabel.setForeground(Color.GREEN);
			contentPane.add(userNameLabel);
			
			userNameTextField = new JTextField();
			userNameTextField.setBounds(130,133,139,25);
			userNameTextField.addKeyListener(this);
			contentPane.add(userNameTextField);
			
			JLabel passwordLabel = new JLabel("密  码：");
			passwordLabel.setBounds(40, 178, 110, 20);
			passwordLabel.setFont(labelFont);
			passwordLabel.setForeground(Color.GREEN);
			contentPane.add(passwordLabel);
			
			passwordTextField = new JPasswordField();
			passwordTextField.setBounds(130, 175, 139, 25);
			passwordTextField.addActionListener(this);
			contentPane.add(passwordTextField);
			
			JButton enterButton = new JButton("登录");
			URL url = getClass().getResource("enter.png");
			
			ImageIcon imageIcon  = new ImageIcon(url);
			enterButton.setBounds(0,40,imageIcon.getIconWidth(),imageIcon.getIconHeight());
			enterButton.setIcon(imageIcon);
			enterButton.setContentAreaFilled(false);
			enterButton.setBorder(null);
			enterButton.addActionListener(this);
			enterButton.setBounds(280, 138, 93, 64);
			contentPane.add(enterButton);
		}
		return contentPane;
	}



	@Override
	public void keyPressed(KeyEvent e) {
		UserDao userDao = new UserDao();
		if(e.getKeyCode() == KeyEvent.VK_ENTER && count%2 == 0) {
			if(userDao.isUserName(userNameTextField.getText())) {
				passwordTextField.requestFocus();
				count++;
			}else {
				JOptionPane.showMessageDialog(getContentPane(), "此用户名不存在!");
				userNameTextField.requestFocus();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER && count%2 != 0) {
			@SuppressWarnings("deprecation")
			User user = userDao.getUser(userNameTextField.getText(), passwordTextField.getText());
			if(user.getId()>0) {
				Session.setUser(user);			//设置Session对象的User属性值
				RemovableFrame frame = new RemovableFrame();		//创建主窗体对象
				frame.setVisible(true);
				 Enter.this.dispose();			//销毁登录窗体
			}else {
				JOptionPane.showMessageDialog(getContentPane(), "用户名或密码错误!");
				userNameTextField.setText("");
				passwordTextField.setText("");
				userNameTextField.requestFocus();
				count++;
			}
		}
	}

	
	public void actionPerformed(ActionEvent e) {
			UserDao userDao = new UserDao();
			@SuppressWarnings("deprecation")
			User user = userDao.getUser(userNameTextField.getText(), passwordTextField.getText());
			if(user.getId()>0) {
				Session.setUser(user);			//设置Session对象的User属性值
				RemovableFrame frame = new RemovableFrame();		//创建主窗体对象
				frame.setVisible(true);
				 Enter.this.dispose();			//销毁登录窗体
			}else {
				JOptionPane.showMessageDialog(getContentPane(), "用户名或密码错误!");
				userNameTextField.setText("");
				passwordTextField.setText("");
				userNameTextField.requestFocus();
			}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}