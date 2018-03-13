package com.github.jannled.raytracer.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.github.jannled.lib.Print;
import com.github.jannled.lib.math.Maths;

public class ImagePane extends JPanel implements MouseMotionListener
{
	private static final long serialVersionUID = -4813564858885592514L;
	
	private BufferedImage canvas;

	public ImagePane(BufferedImage canvas)
	{
		setImage(canvas);
		addMouseMotionListener(this);
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

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		int x = Maths.map(e.getX(), 0, getWidth(), 0, canvas.getWidth());
		int y = Maths.map(e.getY(), 0, getHeight(), 0, canvas.getHeight());
		Print.d("Pos" + x + "|" + y);
	}
}
