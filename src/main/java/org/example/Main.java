package org.example;

public class Main {
    public static void main(String[] args) {


        //creamos una instancia del circular buffer con capacidad para 4 elementos
        ProductorConsumidor.CircularBuffer buffer=new ProductorConsumidor.CircularBuffer(4);

        //creamos e iniciamos 3 hilos productores
        for(int i=0;i<3;i++){
            final int start=i*10+1;//definimos el rango inicial de produccion
            final int end=(i+1)*10;//define el rango final de produccion
            Thread productorThread=new Thread(new Productor(buffer,start,end));//instanciamos el hilo
            productorThread.start();//iniciamos el hilo productor
        }

        //creamos e iniciamos 2 hilos consumidores
        for(int i=0;i<2;i++){
            Thread consumidorThread=new Thread(new Consumidor(buffer));
            consumidorThread.start();//iniciamos el hilo consumidor
        }





    }
}