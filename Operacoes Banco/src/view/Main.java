package view;

import controller.Banco;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(1);

        for (int i = 1 ; i <= 21; i++)
        {
            Banco tranferencia = new Banco(i, semaphore);
            tranferencia.start();
        }
    }
}
