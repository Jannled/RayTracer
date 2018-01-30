package com.github.jannled.raytracer.test;

import java.util.Arrays;

import com.github.jannled.raytracer.Camera;
import com.github.jannled.raytracer.Scene;
import com.github.jannled.raytracer.model.Model;
import com.github.jannled.raytracer.model.OBJLoader;

public class Main
{
	Camera camera = new Camera(64, 64, 10);
	Scene scene = new Scene();
	
	public Main()
	{
		Model m = OBJLoader.loadModel(Main.class.getResourceAsStream("Icosphere.obj"));
		scene.addModel(m);
		camera.render(scene);
	}
	
	public static void main(String[] args)
	{
		new Main();
		System.out.println(Arrays.toString(args));
	}
}
