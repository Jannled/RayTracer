package com.github.jannled.raytracer;

import java.awt.image.BufferedImage;

import com.github.jannled.lib.math.Vector;
import com.github.jannled.raytracer.model.Model;
import com.github.jannled.raytracer.ray.Line;

/**
 * @version 0.1
 * @author Jannled
 * The camera for the raytracer and source for the rays, call <code>render()</code> to render the scene.
 */
public class Camera
{
	int width, height, distance;
	int renderResult[][] = new int[width * height][3]; 
	public BufferedImage canvas; 
	
	public Camera(int width, int height, int distance)
	{
		this.width = width;
		this.height = height;
		this.distance = distance;
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
	}
	
	public void render(Scene scene)
	{
		Vector zero = new Vector(3);
		
		for(int i=0; i<width*height; i++)
		{
			double posx = (i%width - width/2);
			posx = posx / (width / 2);
			double posy = (((int) i/width) - height/2);
			posy = posy / (height / 2);
			
			Vector raster = new Vector(posx, posy, distance);
			
			Line ray = new Line(zero, raster);
			
			renderResult[i] = raytrace(scene, ray);
		}
	}
	
	public int[] raytrace(Scene scene, Line ray)
	{
		for(Model m : scene.getModels())
		{
			//Compute for each face
			for(int i=0; i<m.getFaces().length; i++)
			{	
				if(m.getFaces()[i].getMinMax()[0][0] > m.getFaces()[i].getMinMax()[1][1] ||
						m.getFaces()[i].getMinMax()[0][0] > m.getFaces()[i].getMinMax()[2][1])
				{
					
				}
			}
		}
		
		return new int[] {0, 0, 0};
	}
}
