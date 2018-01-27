package com.github.jannled.raytracer;

import java.util.LinkedList;

import com.github.jannled.raytracer.model.Model;

public class Scene
{
	LinkedList<Model> models = new LinkedList<Model>();
	
	public Scene()
	{
		
	}
	
	public void addModel(Model m)
	{
		models.add(m);
	}
	
	public LinkedList<Model> getModels()
	{
		return models;
	}
}
