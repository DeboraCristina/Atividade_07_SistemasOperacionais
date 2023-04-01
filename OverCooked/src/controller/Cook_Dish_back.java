package controller;

import java.util.concurrent.Semaphore;

import Model.Dish;

public class Cook_Dish_back extends Thread
{
	private Semaphore entrega;
	private Dish dish;
	
	public Cook_Dish_back(Semaphore entrega, Dish dish) 
	{
		this.entrega = entrega;
		this.dish = dish;
	}
	
	@Override
	public void run() 
	{
		System.out.printf("\"%s\" - id: %d - tid: %d\n", dish.name, dish.id, (int) getId());

//		coock();
//		try 
//		{
//			entrega.acquire();
//			send();
//		} 
//		catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			entrega.release();
//		}
	}

	private void send() 
	{
		System.out.printf("Prato \"%s\" foi para o envio\n", dish.name);
		sleepSecond(500);
		System.out.printf("Prato \"%s\" foi entrege\n", dish.name);
	}

	private void coock() 
	{
		int time = secondRandom(dish.coockingTime_min, dish.coockingTime_max);
		double percent = 0;
		
		System.out.printf("Prato \"%s\" está cozinhando\n", dish.name);
		
		for (int t = 0; t < time; t += 100)
		{
			sleepSecond(100);
			System.out.printf("\"%s\" está %.1f%% Concluido\n", dish.name, percent);
			percent += ((double) 100/time) * 100;
		}
		System.out.printf("\"%s\" está 100%% Concluido\n", dish.name);
		System.out.printf("\"%s\" está cozido\n", dish.name);
	}

	private void sleepSecond(int time)
	{
		try 
		{
			sleep(time);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static int secondRandom(int min, int max)
	{
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
	
}
