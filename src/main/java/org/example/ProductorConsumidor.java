package org.example;

public class ProductorConsumidor {


    public static class CircularBuffer{
        private int[] buffer;
        private int capacidad;
        private int tamaño=0;
        private int cabeza=0;
        private int cola=0;

        public CircularBuffer(int capacidad) {
            this.capacidad = capacidad;
            this.buffer=new int[capacidad];
        }

        //metodo para insertar un elemento en el buffer
        public synchronized void put(int item)throws InterruptedException{
            //si el buffer esta lleno,el productor espera
            while(tamaño==capacidad){
                System.out.println("Buffer lleno,productor esperando");
                wait();//hazemos que el hilo actual espere hasta que otro hilo notifique que pueda seguir (notify())
            }
            buffer[cabeza]=item;
            cabeza=(cabeza+1)%capacidad;
            tamaño++;
            notifyAll();

        }

        //metodo para obtener un elemento del buffer
        public synchronized  int get() throws InterruptedException{
            while(tamaño==0){
                System.out.println("Buffer vacio consumidor esperando");
                wait();
            }
            int item=buffer[cola];
            tamaño--;
            notifyAll();
            return item;

        }


    }


}
