package com.example.batallanaval.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.util.ArrayList;


public class BatallaNavalController {

    private static final int SIZE = 10; // Tamaño del tablero 10x10
    private static ArrayList<ArrayList<Boolean>> barcosJugador; // Barcos del jugador
    private static ArrayList<ArrayList<Boolean>> barcosMaquina; // Barcos de la máquina
       private static ArrayList<ArrayList<Button>> botonesMaquina; // Botones del tablero de la máquinabotonesTablero; // Botones del tablero

    private int barcosRestantes;

    @FXML
    private Button iniciarJuegoButton;

    @FXML
    private GridPane tablerodejugadorGridpane;

    @FXML
    private GridPane tablerodeordenadorGridpane;

    @FXML
    void oniniciarjuegoMouseClicked(ActionEvent event) {

    }

    public void initialize() {
        botonesMaquina = new ArrayList<>();
        barcosJugador = new ArrayList<>();
        barcosMaquina = new ArrayList<>();


        // Crear tableros de 10x10 para jugador y máquina
        for (int i = 0; i < SIZE; i++) {
            ArrayList<Button> filaBotonesMaquina = new ArrayList<>();
            ArrayList<Boolean> filaBarcosJugador = new ArrayList<>();
            ArrayList<Boolean> filaBarcosMaquina = new ArrayList<>();

            for (int j = 0; j < SIZE; j++) {
                // Botones para el tablero de la máquina
                Button buttontnMaquina = new Button("~");
                buttontnMaquina.setMinSize(30, 30);
                tablerodeordenadorGridpane.add(buttontnMaquina, j, i);
                filaBotonesMaquina.add(buttontnMaquina);
                filaBarcosMaquina.add(false);
            }

            botonesMaquina.add(filaBotonesMaquina);
            barcosJugador.add(filaBarcosJugador);
            barcosMaquina.add(filaBarcosMaquina);
        }
    }



    

}
