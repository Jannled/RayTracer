package com.github.jannled.raytracer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.github.jannled.lib.math.Vector;

/**
 * Class to load OBJ-files into memory
 * @author Jannled
 * @version 0.0.1
 */
public class OBJLoader implements Loader
{
	private static String COMMENT = "#";
	private static String VERTEX = "v";
	private static String TEXTURE = "vt";
	private static String FACE = "f";
	private static String NORMAL = "vn";
	private static String NAME = "o";
	private static String GROUP = "g";
	
	private static ArrayList<String> svertices = new ArrayList<String>();
	private static ArrayList<String> snormals = new ArrayList<String>();
	private static ArrayList<String> stextures = new ArrayList<String>();
	private static ArrayList<String> sfaces = new ArrayList<String>();
	
	public static Model loadModel(InputStream in)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return loadModel(br);
	}
	
	public static Model loadModel(BufferedReader in)
	{
		preprocess(in);
		
		Vector[] vertices = new Vector[svertices.size()];
		Vector[] normals = new Vector[snormals.size()];
		float[] textures = new float[stextures.size()*2];
		Face[] faces = new Face[sfaces.size()];
		
		for(int i=0; i<vertices.length; i++)
		{
			String[] values = svertices.get(i).split(" ");
			vertices[i] = new Vector(Float.parseFloat(values[0]), Float.parseFloat(values[1]), Float.parseFloat(values[2]));
		}
		
		for(int i=0; i<normals.length; i++)
		{
			String[] values = snormals.get(i).split(" ");
			normals[i] = new Vector(Float.parseFloat(values[0]), Float.parseFloat(values[1]), Float.parseFloat(values[2]));
		}
		
		for(int i=0; i<textures.length/2; i++)
		{
			String[] values = stextures.get(i).split(" ");
			textures[i*2+0] = Float.parseFloat(values[0]);
			textures[i*2+1] = Float.parseFloat(values[1]);
		}
		
		for(int i=0; i<faces.length; i++)
		{
			String[] values = sfaces.get(i).split(" ");
			//TODO Enable normal loading
			faces[i] = new Face(new int[] {Short.parseShort(values[0].split("/")[0]), Short.parseShort(values[1].split("/")[0]), Short.parseShort(values[2].split("/")[0])}, null, vertices);
		}
		
		return new Model(vertices, faces);
	}
	
	private static void preprocess(BufferedReader r)
	{
		try
		{
			String line;
			while((line = r.readLine()) != null) 
			{
				String[] l = line.split(" ", 2);
				if(l[0].equals(VERTEX))
				{
					svertices.add(l[1]);
				}
				else if(l[0].equals(NORMAL))
				{
					snormals.add(l[1]);
				}
				else if(l[0].equals(TEXTURE))
				{
					stextures.add(l[1]);
				}
				else if(l[0].equals(FACE))
				{
					sfaces.add(l[1]);
				}
				else if(l[0].equals(GROUP))
				{
					
				}
				else if(l[0].equals(NAME))
				{
					
				}
				else if(l[0].startsWith(COMMENT))
				{
					continue;
				}
			}
			r.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
}
