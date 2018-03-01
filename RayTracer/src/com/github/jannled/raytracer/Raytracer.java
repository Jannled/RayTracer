package com.github.jannled.raytracer;

import com.github.jannled.raytracer.ray.Line;

public interface Raytracer 
{
	public int[] raytrace(Scene scene, Line ray);
}
