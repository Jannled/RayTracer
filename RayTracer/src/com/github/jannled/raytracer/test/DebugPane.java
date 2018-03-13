package com.github.jannled.raytracer.test;

import javax.swing.JPanel;

import com.github.jannled.raytracer.ray.Line;

public class DebugPane extends JPanel 
{
	private static final long serialVersionUID = -668530110179678120L;
	double vals[][];
	Line[] rays;
	
	public DebugPane(int size)
	{
		vals = new double[size][6];
	}
	
	public void write(int pos, double xmin, double xmax, double ymin, double ymax, double zmin, double zmax, Line ray)
	{
		vals[pos] = new double[] {xmin, xmax, ymin, ymax, zmin, zmax};
		rays[pos] = ray;
	}
}
