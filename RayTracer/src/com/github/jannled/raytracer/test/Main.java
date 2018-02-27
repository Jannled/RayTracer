package com.github.jannled.raytracer.test;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.jannled.raytracer.Camera;
import com.github.jannled.raytracer.Scene;
import com.github.jannled.raytracer.model.Model;
import com.github.jannled.raytracer.model.OBJLoader;

public class Main
{
	public static final int WIDTH = 256;
	public static final int HEIGHT = 256;
	
	Camera camera = new Camera(WIDTH, HEIGHT, 10);
	Scene scene = new Scene();
	JFrame frame;
	JPanel render;
	
	public Main()
	{
		Model m = OBJLoader.loadModel(Main.class.getResourceAsStream("Triangle.obj"));
		scene.addModel(m);
		camera.render(scene);
		
		frame = new JFrame("RayTracer CPU Test");
		frame.setSize(WIDTH, HEIGHT);
		render = new ImagePane(camera.getCanvas());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(render, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new Main();
		System.out.println(Arrays.toString(args));
	}
}
