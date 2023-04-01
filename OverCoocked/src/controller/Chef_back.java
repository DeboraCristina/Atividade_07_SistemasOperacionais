package controller;

import java.util.concurrent.Semaphore;

import Model.Dish;

public class Chef_back extends Thread
{
//	private Semaphore entrega = new Semaphore(1);
//	private Dish dish = new Dish();
//	
//	public Chef_back() 
//	{
//		
//	}
//	
//	
//	@Override
//	public void run() 
//	{
//		callDishes(5);
//	}
//
//
//	private void callDishes(int dishesNum) 
//	{
//		for (int d = 1; d <= dishesNum; d++)
//		{
//			dish.id = d;
//			setCoockingTime(d);
//			setName(d);
//			System.out.println("----" + d);
//			Cook_Dish dishCooked = new Cook_Dish(entrega, dish);
//			dishCooked.start();
//		}
//	}
//
//
//	private void setName(int id)
//	{
//		if (id % 2 == 0)
//			dish.name = "Sopa de Cebola";
//		else
//			dish.name = "Lasanha a Bolanhesa";
//	}
//
//
//	private void setCoockingTime(int id) {
//		
//		if (id % 2 == 0)
//		{
//			dish.coockingTime_min = toSeconds(0.6);
//			dish.coockingTime_max = toSeconds(1.2);
//		}
//		else
//		{
//			dish.coockingTime_min = toSeconds(0.5);
//			dish.coockingTime_max = toSeconds(0.8);
//		}
//	}
//
//
//	private int toSeconds(double value) {
//		return (int) value * 1000;
//	}
//

	
}
