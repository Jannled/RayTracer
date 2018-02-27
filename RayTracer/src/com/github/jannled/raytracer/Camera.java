package com.github.jannled.raytracer;

import java.awt.image.BufferedImage;

import com.github.jannled.lib.math.Vector;
import com.github.jannled.raytracer.model.Face;
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
	int renderResult[][]; 
	public BufferedImage canvas; 
	private Vector position;
	
	public Camera(int width, int height, int distance)
	{
		this.width = width;
		this.height = height;
		this.distance = distance;
		this.position = new Vector(0, 0, -10);
		this.renderResult = new int[width * height][3];
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void render(Scene scene)
	{	
		for(int i=0; i<width*height; i++)
		{
			double posx = (i%width - width/2);
			posx = posx / (width / 2);
			double posy = (((int) i/width) - height/2);
			posy = posy / (height / 2);
			
			Vector raster = new Vector(posx, posy, distance).add(position);
			
			Line ray = new Line(position, raster);
			
			renderResult[i] = raytrace(scene, ray);
			canvas.getRaster().setPixel(i%width, i/width, renderResult[i]);
		}
	}
	
	/* a + m * x = rx	(rx - a) / x = mx;
	 * b + m * y = ry	(ry - b) / y = my;
	 * c + m * z = rz	(rz - c) / z = mz;
	 * 
	 * a/b/c = ray equation
	 * x/y/z = ray equation
	 * rx/ry/rz = min and max per face 
	 * m = wanted
	*/
	
	/**
	 * Compute for each pixel.
	 * @param scene The Scene containing the objects to render.
	 * @param ray The ray equation.
	 * @return The three color component.
	 */
	public int[] raytrace(Scene scene, Line ray)
	{
		int[] pixel = new int[3];
		
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
				
				double test1 = (m.getFaces()[i].getMin(Face.Z) - ray.getStart().Z());
				double test2 = ray.getDirection().Z();
				
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
				if(mzmin > mxmax || mzmin > mzmax)
				{
					pixel[2] = pixel[2] + 50;
					continue;
				}
			}
		}
		
		return pixel;
	}
	
	public BufferedImage getCanvas()
	{
		return canvas;
	}
}
