package org.example;

import java.util.Random;

public class Consumidor implements Runnable{
   private ProductorConsumidor.CircularBuffer buffer;

    // Constructor del consumidor.
    public Consumidor( ProductorConsumidor.CircularBuffer buffer) {
        this.buffer = buffer;
    }

    //metodo run del hilo consumidor
    @Override
    public void run() {
        Random rand=new Random();
        for(int j=0;j<15;j++){
            try{
                Thread.sleep(rand.nextInt(2000));
                int item= buffer.get();
                System.out.println("Consumidor ha consumido: " + item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
