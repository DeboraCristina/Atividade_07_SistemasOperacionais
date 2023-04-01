package controller;

import java.util.concurrent.Semaphore;

public class Chef extends Thread
{
	private Semaphore entrega = new Semaphore(1);
	private int coockingTime_max;
	private int coockingTime_min;
	private String name;
	
	public Chef() 
	{
		
	}
	
	
	@Override
	public void run() 
	{
		callDishes(5);
	}


	private void callDishes(int dishesNum) 
	{
		for (int d = 1; d <= dishesNum; d++)
		{
			setCoockingTime(d);
			setName(d);
			Cook_Dish dishCooked = new Cook_Dish(entrega, coockingTime_max, coockingTime_min, name);
			dishCooked.start();
		}
	}


	private void setName(int id)
	{
		if (id % 2 == 0)
			name = "Lasanha a Bolanhesa";
		else
			name = "Sopa de Cebola";
	}


	private void setCoockingTime(int id) {
		
		if (id % 2 == 0)
		{
			coockingTime_min = toSeconds(0.6);
			coockingTime_max = toSeconds(1.2);
		}
		else
		{
			coockingTime_min = toSeconds(0.5);
			coockingTime_max = toSeconds(0.8);
		}
	}


	private int toSeconds(double value) {
		return (int) (value * 1000);
	}


	
}
