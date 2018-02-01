package com.github.jannled.raytracer.model;

import com.github.jannled.lib.math.Vector;

public class Model
{	
	private Vector[] vertices;
	private int[][] faces;
	private Vector[] normals;
	private double pnconst[];
	
	public Model(Vector[] vertices, int[][] faces)
	{
		this.vertices = vertices;
		this.faces = faces;
		this.pnconst = new double[faces.length];
		
		for(int i=0; i<faces.length; i++)
		{
			pnconst[i] = normals[i].getValue(0) * getFace(i)[0] ;
		}
	}
	
	public Vector[] getVertices()
	{
		return vertices;
	}
	
	public int[][] getFaces()
	{
		return faces;
	}
	
	public Vector[] getNormals()
	{
		return normals;
	}
	
	public Vector[] getFace(int face)
	{
		Vector[] out = new Vector[faces[face].length];
		
		if(out.length == 3)
		{
			out[0] = vertices[faces[face][0]];
			out[1] = vertices[faces[face][1]];
			out[2] = vertices[faces[face][2]];
		}
		return out;
	}
	
	public double[] getPnConst(int face)
	{
		return pnconst;
	}
}
