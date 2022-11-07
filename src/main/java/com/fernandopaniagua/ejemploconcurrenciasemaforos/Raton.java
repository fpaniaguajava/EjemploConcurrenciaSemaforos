package com.fernandopaniagua.ejemploconcurrenciasemaforos;

public class Raton extends Thread {

    String nombre;
    int tiempoParaComer;
    PoolDispensadoresComida pool;
    public Raton(String nombre, int tiempoParaComer, PoolDispensadoresComida pool){
        this.nombre=nombre;
        this.tiempoParaComer = tiempoParaComer;
        this.pool = pool;
    }
    
    @Override
    public void run() {
        try {
            while(true){
                System.out.println(String.format("El ratón %s quiere comer", nombre));
                Dispensador dispensadorAsignado = pool.getDispensador();
                dispensadorAsignado.getComida();
                System.out.println(String.format("El ratón %s está comiendo", nombre));
                Thread.sleep(tiempoParaComer);
                System.out.println(String.format("El ratón %s ha terminado de comer", nombre));
                pool.putDispensador(dispensadorAsignado);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
