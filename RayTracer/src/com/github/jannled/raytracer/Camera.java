package com.github.jannled.raytracer;

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
	
	public Camera(int width, int height, int distance)
	{
		this.width = width;
		this.height = height;
		this.distance = distance;
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
			
			raytrace(scene, ray);
		}
	}
	
	public void raytrace(Scene scene, Line ray)
	{
		for(Model m : scene.getModels())
		{
			//Compute for each face
			for(int i=0; i<m.getFaces().length; i++)
			{
				if()
				{
					double zahler = (- ray.getStart().getValue(0) * m.getNormals()[i].getValue(0) - ray.getStart().getValue(1) * m.getNormals()[i].getValue(1) - ray.getStart().getValue(0) * m.getNormals()[i].getValue(0) + m.getPnConst(i));
					double nenner = ray.getDirection().getValue(0) * m.getNormals()[i].getValue(0) + ray.getDirection().getValue(1) * m.getNormals()[i].getValue(1) + ray.getDirection().getValue(2) * m.getNormals()[i].getValue(2);
					
					//Check if ray is parallel to the face.
					if(nenner != 0)
					{
						double x = zahler / nenner;
						
						//If backface culling is enabled drop the specified faces
						if(!(m.isBackfaceCulling() && x < 0))
						{
							
						}
					}
				}
			}
		}
	}
}
