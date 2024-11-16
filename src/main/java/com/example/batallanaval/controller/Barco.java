package com.example.batallanaval.controller;

import java.util.ArrayList;

public class Barco {
    private String nombre;
    private int tamaño;
    private int casillasOcupadas;
    private ArrayList<int[]> posiciones;

    /**
     *
     * @param nombre
     * @param tamaño
     */
    public Barco(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.casillasOcupadas = 0;
        this.posiciones = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     *
     * @return
     */
    public boolean estaHundido() {
        return casillasOcupadas == tamaño;
    }

    /**
     *
     * @param fila
     * @param columna
     */
    public void marcarImpacto(int fila, int columna) {
        for (int[] pos : posiciones) {
            if (pos[0] == fila && pos[1] == columna) {
                casillasOcupadas++;
                break;
            }
        }
    }

    /**
     *
     * @param fila
     * @param columna
     */
    public void agregarPosicion(int fila, int columna) {
        posiciones.add(new int[]{fila, columna});
    }

    /**
     *
     * @return
     */
    public ArrayList<int[]> getPosiciones() {
        return posiciones;
    }

}
