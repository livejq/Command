package com.zhl.widget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import javax.swing.JToggleButton;

public class GlassButton extends JToggleButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean paintFlag = false;
	
	public GlassButton() {
		initialize();
	}
	
	private void initialize() {
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setMargin(new Insets(0, 0, 0, 0));
	}
	
	public void setPaintFlag(boolean paintFlag) {
		this.paintFlag = paintFlag;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		super.paint(g2);
		Rectangle bs = g2.getClipBounds();
        if (paintFlag) {
            Point2D center = new Point2D.Float(bs.width / 2, bs.height / 2);
            float radius = Math.min(bs.height / 2, bs.width / 2);
            Point2D focus = new Point2D.Float(bs.width / 2f, bs.height / 2f);
            float[] dist = { 0f, 0.8f };
            Color[] colors = { Color.WHITE, new Color(255, 255, 255, 0) };
            if (radius > 0) {
                RadialGradientPaint p = new RadialGradientPaint(center, radius,
                        focus, dist, colors, CycleMethod.NO_CYCLE);
                g2.setPaint(p);
                g2.fillRect(0, 0, bs.width, bs.height);
            }
        }
	}
}
