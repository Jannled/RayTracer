package com.github.jannled.raytracer;

import com.github.jannled.lib.Print;
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
				
				if(mxmin > mxmax) Print.e(i + "(x): " + mxmin + " > " + mxmax);
				if(mymin > mymax) Print.e(i + "(y): "+ mymin + " > " + mymax);
				if(mzmin > mzmax) Print.e(i + "(z): " + mzmin + " > " + mzmax);
				
				//System.out.println("[" + Maths.round(mxmin, 4) + "; " + Maths.round(mxmax, 4) + "]" + "	[" + Maths.round(mymin, 4) + "; " + Maths.round(mymax, 4) + "]" + "	[" + Maths.round(mzmin, 4) + "; " + Maths.round(mzmax, 4) + "]");
				
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
				//System.out.println(ray.toString());  
				
				pixel[0] = 255;
				pixel[1] = 255;
				pixel[2] = 255;
			}
		}
		
		return pixel;
	}
	
}
