package com.github.jannled.raytracer;

import java.awt.image.BufferedImage;

import com.github.jannled.lib.Print;
import com.github.jannled.lib.math.Vector;
import com.github.jannled.raytracer.ray.Line;

/**
 * @version 0.1
 * @author Jannled
 * The camera for the raytracer and source for the rays, call <code>render()</code> to render the scene.
 */
public class Camera extends JTracer
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
		this.position = new Vector(0, 0, 0);
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
		Print.m("Frame rendered!");
	}

	public BufferedImage getCanvas()
	{
		return canvas;
	}
}
