package com.github.jannled.raytracer.ray;

import com.github.jannled.lib.math.Vector;

public class Line
{
	private Vector start, direction;
	
	public Line(Vector start, Vector direction)
	{
		this.start = start;
		this.direction = direction;
	}

	public Vector getStart()
	{
		return start;
	}

	public Vector getDirection()
	{
		return direction;
	}

	public void setStart(Vector start)
	{
		this.start = start;
	}

	public void setDirection(Vector direction)
	{
		this.direction = direction;
	}
	
	@Override
	public String toString() 
	{
		return 	start.X() + "	+ m * " + direction.X() + "\n" +
				start.Y() + "	+ m * " + direction.Y() + "\n" +
				start.Z() + "	+ m * " + direction.Z();
	}
}
