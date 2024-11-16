package com.example.batallanaval.controller;

import java.util.ArrayList;
import java.util.Random;

public class BatallaNavalGame {

    private static final int SIZE = 10;
    private ArrayList<ArrayList<Boolean>> tableroJugador;
    private ArrayList<ArrayList<Boolean>> tableroMaquina;
    private ArrayList<Barco> flotaJugador;
    public static ArrayList<Barco> flotaMaquina;
    public boolean turnoJugador;

    /**
     *
     */
    public BatallaNavalGame() {
        this.tableroJugador = new ArrayList<>();
        this.tableroMaquina = new ArrayList<>();
        this.flotaJugador = new ArrayList<>();
        this.flotaMaquina = new ArrayList<>();
        this.turnoJugador = true;
    }


    /**
     *
     * @param tablero
     */
    private void inicializarTablero(ArrayList<ArrayList<Boolean>> tablero) {
        for (int i = 0; i < SIZE; i++) {
            ArrayList<Boolean> fila = new ArrayList<>();
            for (int j = 0; j < SIZE; j++) {
                fila.add(false);
            }
            tablero.add(fila);
        }
    }


    /**
     *
     */
    public static void crearFlotaMaquina() {
        flotaMaquina.add(new Barco("Portaaviones", 4));
        flotaMaquina.add(new Barco("Submarino 1", 3));
        flotaMaquina.add(new Barco("Submarino 2", 3));
        flotaMaquina.add(new Barco("Destructor 1", 2));
        flotaMaquina.add(new Barco("Destructor 2", 2));
        flotaMaquina.add(new Barco("Destructor 3", 2));
        flotaMaquina.add(new Barco("Fragata 1", 1));
        flotaMaquina.add(new Barco("Fragata 2", 1));
        flotaMaquina.add(new Barco("Fragata 3", 1));
        flotaMaquina.add(new Barco("Fragata 4", 1));
    }


    /**
     *
     * @param fila
     * @param columna
     * @param barco
     * @param horizontal
     * @return
     */
    public boolean colocarBarcoJugador(int fila, int columna, Barco barco, boolean horizontal) {
        boolean espacioDisponible = true;

        if (horizontal) {
            if (columna + barco.getTamaño() > SIZE) {
                espacioDisponible = false;
            } else {
                for (int i = 0; i < barco.getTamaño(); i++) {
                    if (tableroJugador.get(fila).get(columna + i)) {
                        espacioDisponible = false;
                        break;
                    }
                }
            }
        } else {
            if (fila + barco.getTamaño() > SIZE) {
                espacioDisponible = false;
            } else {
                for (int i = 0; i < barco.getTamaño(); i++) {
                    if (tableroJugador.get(fila + i).get(columna)) {
                        espacioDisponible = false;
                        break;
                    }
                }
            }
        }

        if (espacioDisponible) {
            for (int i = 0; i < barco.getTamaño(); i++) {
                if (horizontal) {
                    tableroJugador.get(fila).set(columna + i, true);
                } else {
                    tableroJugador.get(fila + i).set(columna, true);
                }
            }
            return true;
        }
        return false;
    }


    /**
     *
     * @param fila
     * @param columna
     * @param barco
     * @param horizontal
     * @return
     */
    public boolean colocarBarcoMaquinaEnTablero(int fila, int columna, Barco barco, boolean horizontal) {
        boolean espacioDisponible = true;

        if (horizontal) {
            if (columna + barco.getTamaño() > SIZE) {
                espacioDisponible = false;
            } else {
                for (int i = 0; i < barco.getTamaño(); i++) {
                    if (tableroMaquina.get(fila).get(columna + i)) {
                        espacioDisponible = false;
                        break;
                    }
                }
            }
        } else {
            if (fila + barco.getTamaño() > SIZE) {
                espacioDisponible = false;
            } else {
                for (int i = 0; i < barco.getTamaño(); i++) {
                    if (tableroMaquina.get(fila + i).get(columna)) {
                        espacioDisponible = false;
                        break;
                    }
                }
            }
        }

        if (espacioDisponible) {
            for (int i = 0; i < barco.getTamaño(); i++) {
                if (horizontal) {
                    tableroMaquina.get(fila).set(columna + i, true);
                } else {
                    tableroMaquina.get(fila + i).set(columna, true);
                }
                barco.agregarPosicion(fila, columna + i);
            }
            return true;
        }
        return false;
    }


    /**
     *
     */
    public void iniciarJuego() {
        inicializarTablero(tableroJugador);
        inicializarTablero(tableroMaquina);


        turnoJugador = true;
    }


    /**
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean dispararJugador(int fila, int columna) {
        for (Barco barco : flotaMaquina) {
            for (int[] posicion : barco.getPosiciones())
                if (posicion[0] == fila && posicion[1] == columna) {
                    barco.marcarImpacto(fila, columna);
                    return true;
                }
        }
        return false;
    }


    /**
     *
     * @return
     */
    public boolean dispararMaquina() {
        Random rand = new Random();
        int fila = rand.nextInt(10);
        int columna = rand.nextInt(10);
        return dispararJugador(fila, columna);
    }

    /**
     *
     * @return
     */
    public boolean verificarVictoria() {
                for (Barco barco : flotaMaquina) {
            if (!barco.estaHundido()) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     */
    public void reiniciarJuego() {
        tableroJugador.clear();
        tableroMaquina.clear();
        flotaJugador.clear();
        flotaMaquina.clear();
        turnoJugador = true;
    }


    /**
     *
     * @param fila
     * @param columna
     * @param barco
     * @param horizontal
     */
    public void colocarBarcoJugador(int fila, int columna, Barco[] barco, boolean horizontal) {
    }
}
