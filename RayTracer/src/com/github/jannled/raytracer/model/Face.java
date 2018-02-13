package com.github.jannled.raytracer.model;

import com.github.jannled.lib.math.Vector;

public class Face 
{
	private int[] indices;
	private Vector normal;
	private int[] minMax;
	
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
	
	public int[] getMinMax()
	{
		return minMax;
	}
	
	private void calculateMinMax(Vector[] vertices)
	{
		minMax = new int[indices.length * 2];
		
		for(int i=0; i<indices.length; i++)
		{
			
		}
	}
}
