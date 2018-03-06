package com.github.jannled.raytracer;

import com.github.jannled.raytracer.model.Face;
import com.github.jannled.raytracer.model.Model;
import com.github.jannled.raytracer.ray.Line;

public class JTracer implements Raytracer
{
	/**
	 * Compute for each pixel.
	 * @param scene The Scene containing the objects to render.
	 * @param ray The ray equation.
	 * @return The three color component.
	 */
	@Override
	public int[] raytrace(Scene scene, Line ray) 
	{
		int[] pixel = new int[3];
		
		//Compute for each model
		for(Model m : scene.getModels())
		{
			//Compute for each face
			for(int i=0; i<m.getFaces().length; i++)
			{
				double mxmin = (m.getFaces()[i].getMin(Face.X) - ray.getStart().X()) / ray.getDirection().X();
				double mxmax = (m.getFaces()[i].getMax(Face.X) - ray.getStart().X()) / ray.getDirection().X();
				double mymin = (m.getFaces()[i].getMin(Face.Y) - ray.getStart().Y()) / ray.getDirection().Y();
				double mymax = (m.getFaces()[i].getMax(Face.Y) - ray.getStart().Y()) / ray.getDirection().Y();
				double mzmin = (m.getFaces()[i].getMin(Face.Z) - ray.getStart().Z()) / ray.getDirection().Z();
				double mzmax = (m.getFaces()[i].getMax(Face.Z) - ray.getStart().Z()) / ray.getDirection().Z();
				
				//Print.m("[" + mxmin + "; " + mxmax + "]" + "	[" + mymin + "; " + mymax + "]" + "	[" + mzmin + "; " + mzmax + "]");
				
				if(mxmin > mymax || mxmin > mzmax)
				{
					pixel[0] = pixel[0] + 50;
					continue;
				}
				if(mymin > mxmax || mymin > mzmax)
				{
					pixel[1] = pixel[1] + 50;
					continue;
				}
				if(mzmin > mxmax || mzmin > mymax)
				{
					pixel[2] = pixel[2] + 50;
					continue;
				}
				
				pixel[0] = 255;
				pixel[1] = 255;
				pixel[2] = 255;
			}
		}
		
		return pixel;
	}
	
}
