package com.fernandopaniagua.ejemploconcurrenciasemaforos;

public class Dispensador {
    String nombre;
    public Dispensador(String nombre){
        this.nombre=nombre;
    }
    public String getComida(){
        return String.format("Dispendador %s proporcionando comida...", nombre);
    }
}
