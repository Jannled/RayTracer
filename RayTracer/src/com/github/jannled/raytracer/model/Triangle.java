package com.github.jannled.raytracer.model;

public class Triangle
{
	private double[][] vertices;
	
	public Triangle(double[][] vertices)
	{
		this.vertices = vertices;
	}
	
	public double[][] getVertices()
	{
		return vertices;
	}
}
