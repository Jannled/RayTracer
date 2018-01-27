package com.github.jannled.raytracer;

import java.util.Arrays;

public class Main
{
	Camera camera = new Camera(64, 64, 10);
	Scene scene = new Scene();
	
	public Main()
	{
		camera.render(scene);
	}
	
	public static void main(String[] args)
	{
		new Main();
		System.out.println(Arrays.toString(args));
	}
}
