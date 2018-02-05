package com.github.jannled.raytracer.model;

import com.github.jannled.lib.math.Vector;

public class Face 
{
	private int[] indices;
	private Vector normal;
	
	public Face(int[] indices, Vector normal)
	{
		this.indices = indices;
		this.normal = normal;
	}
	
	public Vector getNormal()
	{
		return normal;
	}
	
	public int[] getIndices()
	{
		return indices;
	}
}
