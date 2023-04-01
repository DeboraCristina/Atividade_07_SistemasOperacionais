package controller;

import java.util.concurrent.Semaphore;

public class Banco extends Thread
{
    private int id;
    private double[] calc_value = new double[2];
    private double trans_value;
    private Semaphore transaction;
    private int loop;

    public Banco (int id, Semaphore transaction)
    {
        this.id = id;
        this.transaction = transaction;
    }

    @Override
    public void run() {
        setValues();
        for (int i = 0; i < loop; i++)
        {
            sendMessage("Transferencia #" + id + " esta calculando");
            calculate(calc_value[0], calc_value[1]);
            sendMessage("Transferencia #" + id + " ja terminou de calcular. E esta pronto pra transferir os dados");
            try
            {
                sendMessage("Transferencia #" + id + " esta transfereindo dados para o banco");
                transaction.acquire();
                transfer2DB();
                sendMessage("Transferencia #" + id + " concluiu a tranferencia");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                transaction.release();
                sendMessage("Transferencia #" + id + " concluio suas operações");
            }
        }
    }

    private void sendMessage(String message)
    {
        System.out.println(message);
    }

    private void transfer2DB() {
        int time = (int) trans_value * 1000;
        try
        {
            sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void calculate(double min, double max)
    {
        max = max * 1000;
        min = min * 1000;
        int time = (int) ((Math.random() * (max + 1 - min)) + min);

        try
        {
            sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void setValues()
    {
        if (id % 3 == 0)
        {
            calc_value[0] = 1;
            calc_value[1] = 2;
            trans_value = 1.5;
            loop = 3;
        }
        else if (id % 3 == 1)
        {
            calc_value[0] = 0.2;
            calc_value[1] = 1;
            trans_value = 1;
            loop = 2;
        }
        else if (id % 3 == 2)
        {
            calc_value[0] = 0.5;
            calc_value[1] = 1.5;
            trans_value = 1.5;
            loop = 3;
        }
    }


}
