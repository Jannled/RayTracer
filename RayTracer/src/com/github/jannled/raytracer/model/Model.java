package com.github.jannled.raytracer.model;

import com.github.jannled.lib.math.Vector;

public class Model
{	
	//Everything vertices related
	private Vector[] vertices;
	
	//Everything face-related
	private Face[] faces;
	
	private boolean backfaceCulling = false;
	
	public Model(Vector[] vertices, Face[] faces)
	{
		this.vertices = vertices;
		this.faces = faces;
		
		for(int i=0; i<faces.length; i++)
		{
			
		}
	}
	
	public Vector[] getVertices()
	{
		return vertices;
	}
	
	public Face[] getFaces()
	{
		return faces;
	}
	
	public boolean isBackfaceCulling()
	{
		return backfaceCulling;
	}
	
	public void setBackfaceCulling(boolean enabled)
	{
		this.backfaceCulling = enabled;
	}
}
