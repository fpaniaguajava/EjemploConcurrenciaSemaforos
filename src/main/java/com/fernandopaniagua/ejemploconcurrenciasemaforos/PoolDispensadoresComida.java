package com.fernandopaniagua.ejemploconcurrenciasemaforos;

import java.util.concurrent.Semaphore;

public class PoolDispensadoresComida {

    private static final int NUMERO_DISPENSADORES = 3;
    private final Semaphore semaforo = new Semaphore(NUMERO_DISPENSADORES, true);

    private Dispensador[] dispensadores = {
        new Dispensador("d1"),
        new Dispensador("d2"),
        new Dispensador("d3")
    };
    private boolean[] used = new boolean[NUMERO_DISPENSADORES];

    private synchronized Dispensador getSiguienteDispensadorLibre() {
        for (int i = 0; i < NUMERO_DISPENSADORES; ++i) {
            if (!used[i]) {
                used[i] = true;
                return dispensadores[i];
            }
        }
        return null;
    }

    private synchronized boolean marcarDispensadorComoLibre(Dispensador dispensador) {
        for (int i = 0; i < NUMERO_DISPENSADORES; ++i) {
            if (dispensador == dispensadores[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public Dispensador getDispensador() throws InterruptedException {
        semaforo.acquire();
        return getSiguienteDispensadorLibre();
    }

    public void putDispensador(Dispensador x) {
        if (marcarDispensadorComoLibre(x)) {
            semaforo.release();
        }
    }
}
