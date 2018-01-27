package com.github.jannled.raytracer.model;

public class Model
{
	
	private Triangle[] vertices;
	
	public Model(Triangle[] vertices)
	{
		this.vertices = vertices;
	}
	
	public Triangle[] getVertices()
	{
		return vertices;
	}
}
