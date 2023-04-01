package controller;

import java.util.concurrent.Semaphore;

public class Cook_Dish extends Thread
{
	private Semaphore entrega;
	private int coockingTime_max;
	private int coockingTime_min;
	private String name;
	
	
	public Cook_Dish(Semaphore entrega, int coockingTime_max, int coockingTime_min, String name) 
	{
		this.entrega = entrega;
		this.coockingTime_max = coockingTime_max;
		this.coockingTime_min = coockingTime_min;
		this.name = name;
		
	}
	
	@Override
	public void run() 
	{
		coock();
		try 
		{
			entrega.acquire();
			send();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			entrega.release();
		}
	}

	private void send() 
	{
		System.out.printf("Prato \"%s\" foi para o envio\n", name);
		sleepSecond(500);
		System.out.printf("Prato \"%s\" foi entrege\n", name);
	}

	private void coock() 
	{
		int time = secondRandom(coockingTime_min, coockingTime_max);
		double percent = 0;
		
		System.out.printf("Prato \"%s\" está cozinhando\n", name);
		
		for (int t = 0; t < time; t += 100)
		{
			sleepSecond(100);
			System.out.printf("\"%s\" está %.1f%% Concluido\n", name, percent);
			percent += ((double) 100/time) * 100;
		}
		System.out.printf("\"%s\" está 100%% Concluido\n", name);
		System.out.printf("\"%s\" está cozido\n", name);
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
