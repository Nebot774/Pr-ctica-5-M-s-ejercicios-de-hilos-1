package org.example;

import java.util.Random;

public class Productor implements Runnable{
    private ProductorConsumidor.CircularBuffer buffer;
    private  int start;
    private int end;

    // Constructor del productor.
    public Productor(ProductorConsumidor.CircularBuffer buffer, int start, int end) {
        this.buffer = buffer;
        this.start = start;
        this.end = end;
    }

    //iniciamos el hilo productor
    @Override
    public void run(){
        Random rand=new Random();
        for(int item=start;item<=end;item++){
            try{
                Thread.sleep(rand.nextInt(2000));//Esperamos un tiempo aleatorio antes de producir
                buffer.put(item);//produce un item y lo coloca en el buffer
                System.out.println("Productor ha producido:"+item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
