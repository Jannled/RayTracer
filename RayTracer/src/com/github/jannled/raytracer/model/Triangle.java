package com.github.jannled.raytracer.model;

import java.util.Arrays;

import com.github.jannled.lib.math.Vector;

public class Triangle
{
	private Vector[] vertices;
	
	private Vector normal;
	
	public Triangle(Vector[] vertices)
	{
		if(vertices != null && vertices.length == 3 && vertices[0] != null && vertices[1] != null && vertices[2] != null)
		{
			this.vertices = vertices;
		}
		else
		{
			vertices = new Vector[] {new Vector(3), new Vector(3), new Vector(3)};
			throw new IllegalArgumentException("Error while creating triangle, invalid arguments: " + Arrays.deepToString(vertices));
		}
		this.normal = vertices[0].subtract(vertices[1]).crossProduct(vertices[0].subtract(vertices[2]));
	}
	
	public Vector[] getVertices()
	{
		return vertices;
	}
	
	public Vector getNormal()
	{
		return normal;
	}
}
