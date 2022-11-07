package com.fernandopaniagua.ejemploconcurrenciasemaforos;

public class EjemploConcurrenciaSemaforos {

    public static void main(String[] args) {
        PoolDispensadoresComida pool = new PoolDispensadoresComida();
        Raton mickey = new Raton("Mickey",30000,pool);
        Raton minnie = new Raton("Minnie",20000,pool);
        Raton jerry = new Raton("Jerry",50000,pool);
        Raton speedy = new Raton("Speedy",10000,pool);
        Raton perez = new Raton("Perez",40000,pool);
        Raton stuart = new Raton("Stuart",80000,pool);
        Raton[] ratones = {mickey, minnie, jerry, speedy, perez, stuart};
        for (Raton raton : ratones) {
            raton.start();
        }
    }
}
