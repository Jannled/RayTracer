package com.github.jannled.raytracer.model;

import java.util.Arrays;

import com.github.jannled.lib.math.Vector;

public class Face 
{
	private int[] indices;
	private Vector normal;
	private double[][] minMax;
	
	public Face(int[] indices, Vector normal, Vector[] vertices)
	{
		this.indices = indices;
		this.normal = normal;
		calculateMinMax(vertices);
	}
	
	public Vector getNormal()
	{
		return normal;
	}
	
	public int[] getIndices()
	{
		return indices;
	}
	
	public double[][] getMinMax()
	{
		return minMax;
	}
	
	private void calculateMinMax(Vector[] vertices)
	{
		minMax = new double[3][2];
		
		double[] x = new double[indices.length]; 
		double[] y = new double[indices.length];
		double[] z = new double[indices.length];
		
		for(int i=0; i<indices.length; i++)
		{
			x[i] = vertices[indices[i]-1].getValue(0);
			y[i] = vertices[indices[i]-1].getValue(1);
			z[i] = vertices[indices[i]-1].getValue(2);
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		Arrays.sort(z);
		
		minMax[0][0] = x[0];
		minMax[0][1] = x[x.length-1];
		minMax[1][0] = y[0];
		minMax[1][1] = y[y.length-1];
		minMax[2][0] = z[0];
		minMax[2][1] = z[z.length-1];
	}
}
