package com.github.jannled.raytracer.model;

import com.github.jannled.lib.math.Vector;

public class Model
{	
	//Everything vertices related
	private Vector[] vertices;
	
	//Everything face-related
	private int[][] faces;
	private Vector[] normals;
	private Vector[] faceMiddle;
	private double pnconst[];
	
	private boolean backfaceCulling = false;
	
	public Model(Vector[] vertices, Vector[] normals, int[][] faces)
	{
		this.vertices = vertices;
		this.normals = normals;
		this.faces = faces;
		this.pnconst = new double[faces.length];
		
		for(int i=0; i<faces.length; i++)
		{
			pnconst[i] = 	normals[i].getValue(0) * getFace(i)[0].getValue(0) + normals[i].getValue(1) * getFace(i)[0].getValue(1) + normals[i].getValue(2) * getFace(i)[0].getValue(2);
			faceMiddle[i] =	new Vector(
				(getFace(i)[0].getValue(0) + getFace(i)[1].getValue(0) + getFace(i)[2].getValue(0)) / 3,
				(getFace(i)[0].getValue(1) + getFace(i)[1].getValue(1) + getFace(i)[2].getValue(1)) / 3,
				(getFace(i)[0].getValue(2) + getFace(i)[1].getValue(2) + getFace(i)[2].getValue(2)) / 3);
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
	
	public double getPnConst(int face)
	{
		return pnconst[face];
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
