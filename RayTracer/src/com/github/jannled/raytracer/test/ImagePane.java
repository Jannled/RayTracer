package com.github.jannled.raytracer.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePane extends JPanel
{
	private static final long serialVersionUID = -4813564858885592514L;
	
	private BufferedImage canvas;

	public ImagePane(BufferedImage canvas)
	{
		setImage(canvas);
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{	
		g.setColor(Color.PINK);
		g.drawImage(canvas, 0, 0, getWidth(), getHeight(), 0, 0, canvas.getWidth(), canvas.getHeight(), null);
	}
	
	public void setImage(BufferedImage canvas)
	{
		this.canvas = canvas;
		setMinimumSize(new Dimension(canvas.getWidth(), canvas.getHeight()));
		setPreferredSize(new Dimension(canvas.getWidth(), canvas.getHeight()));
		repaint();
	}
}
