package com.zhl.panel;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class MyJPanel extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void	paintComponent(Graphics g){
	try{ 
		URL url = getClass().getResource("/com/zhl/button/back.png");
		//��ǰ�������б�ܲ���©����������
		ImageIcon image = new ImageIcon(url);
		g.drawImage(image.getImage(), 0, 0, this); 
		}catch(Exception e){} 
	}
}
