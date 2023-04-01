package view;

import controller.Chef;

public class Main 
{
	public static void call()
	{
		Chef chef = new Chef();
		chef.start();	
	}
	public static void main(String[] args)
	{
		call();
	}
}
