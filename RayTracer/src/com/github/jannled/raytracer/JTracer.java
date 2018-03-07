package com.github.jannled.raytracer;

import com.github.jannled.lib.Print;
import com.github.jannled.lib.math.Maths;
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
		
		double temp;
		
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
				
				if(ray.getDirection().X() < 0)
				{
					Print.e("Swapped x");
					temp = mxmin;
					mxmin = mxmax;
					mxmax = temp;
				}
				if(ray.getDirection().Y() < 0)
				{
					Print.e("Swapped y");
					temp = mymin;
					mymin = mymax;
					mymax = temp;
				}
				if(ray.getDirection().Z() < 0)
				{
					Print.e("Swapped z");
					temp = mzmin;
					mzmin = mzmax;
					mzmax = temp;
				}
				
				if(mxmin > mxmax) Print.e("x: " + mxmin + " > " + mxmax);
				if(mymin > mymax) Print.e("y: " + mymin + " > " + mymax);
				if(mzmin > mzmax) Print.e("z: " + mzmin + " > " + mzmax);
				
				System.out.println("[" + Maths.round(mxmin, 5) + "; " + Maths.round(mxmax, 5) + "]" + "	[" + Maths.round(mymin, 5) + "; " + Maths.round(mymax, 5) + "]" + "	[" + Maths.round(mzmin, 5) + "; " + Maths.round(mzmax, 5) + "]");
				
				//Check if limits have common values
				if(mxmin > mymax || mxmin > mzmax || mymin > mxmax || mymin > mzmax || mzmin > mxmax || mzmin > mymax)
				{
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
