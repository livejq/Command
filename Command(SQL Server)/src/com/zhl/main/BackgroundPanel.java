package com.zhl.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class BackgroundPanel extends JPanel{
	
	
		private Image image;
		
		public BackgroundPanel() {
			setOpaque(false);
			setLayout(null);
		}
		
		public void setImage(Image image) {
			this.image = image;
		}
		
		protected void paintComponent(Graphics g) {
			if(image!=null) {
				g.drawImage(image, 0, 0, this);
			}
			super.paintComponent(g);
		}

}
