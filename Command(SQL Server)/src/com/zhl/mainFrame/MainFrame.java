package com.zhl.mainFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public MainFrame() {
			setSize(880,590);
			this.setIconImage(getToolkit().getImage(
		            getClass().getResource("linuxIcon.png")));
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenWidth = screenSize.width/2;
			int screenHeight = screenSize.height/2;
			int height = this.getHeight();
			int width = this.getWidth();
			setLocation(screenWidth-width/2,screenHeight-height/2);
			setUndecorated(true);
		}
}
