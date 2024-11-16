package com.example.batallanaval.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class BatallaNavalController {

    private BatallaNavalGame juego;

    @FXML
    private ImageView Destructor1;

    @FXML
    private ImageView Destructor2;

    @FXML
    private ImageView Destructor3;

    @FXML
    private ImageView Fragata1;

    @FXML
    private ImageView Fragata2;

    @FXML
    private ImageView Fragata3;

    @FXML
    private ImageView Fragata4;

    @FXML
    private ImageView Portaaviones;

    @FXML
    private ImageView Submarino1;

    @FXML
    private ImageView Submarino2;

    @FXML
    private Button iniciarJuegoButton;

    @FXML
    private Button mostrarTableroButton;

    @FXML
    public Label mensajeLabel;

    @FXML
    private GridPane tablerodejugadorGridpane;

    @FXML
    private GridPane tablerodeordenadorGridpane;

    private double mouseX;
    private double mouseY;

    private Barco[] flotaMaquina;

    /**
     *
     * @param event
     */
    @FXML
    void oniniciarjuegoMouseClicked(MouseEvent event) {

        juego.iniciarJuego();

        mensajeLabel.setText("Juego iniciado. Coloca tus barcos.\n");

        inicializarTablero();
    }

    /**
     *
     * @param event
     */
    @FXML
    void onMostrarTableroButtonClicked(MouseEvent event) {
        mostrarTableroMaquina();
    }


    /**
     *
     */
    private void mostrarTableroMaquina() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button("~");
                button.setMinSize(30, 30);
                button.setStyle("-fx-background-color: lightgray;");

                tablerodeordenadorGridpane.add(button, j, i);
            }
        }
    }

    /**
     *
     */
    public BatallaNavalController() {
        this.juego = new BatallaNavalGame();
    }


    /**
     *
     */
    public void reiniciarJuego() {
        juego.reiniciarJuego();
        mensajeLabel.setText("Juego reiniciado. Coloca tus barcos.\n");
        inicializarTablero();
    }

    /**
     *
     */
    private void inicializarTablero() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button(" ");
                button.setMinSize(30, 30);
                final int fila = i;
                final int columna = j;


                button.setOnAction(e -> dispararEnTableroMaquina(fila, columna));


                tablerodejugadorGridpane.add(button, j, i);
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button(" ");
                button.setMinSize(30, 30);

                tablerodeordenadorGridpane.add(button, j, i);
            }
        }
    }

    /**
     *
     * @param fila
     * @param columna
     */
    private void dispararEnTableroMaquina(int fila, int columna) {
        if (juego.dispararJugador(fila, columna)) {

            actualizarTableroJugador(fila, columna, "Tocado");
        } else {

            actualizarTableroJugador(fila, columna, "Agua");
        }


        if (juego.turnoJugador == false) {
            maquinaDispara();
        }
    }

    /**
     *
     */
    private void maquinaDispara() {

        boolean acierto = juego.dispararMaquina();

        if (acierto) {
            mensajeLabel.setText("¡La máquina ha impactado!");
        } else {
            mensajeLabel.setText("La máquina falló.");
        }

        juego.turnoJugador = true;
    }

    /**
     *
     * @param fila
     * @param columna
     * @param tipoImpacto
     */
    private void actualizarTableroJugador(int fila, int columna, String tipoImpacto) {
        Button button = (Button) getNodeAt(fila, columna, tablerodeordenadorGridpane);
        if ("Tocado".equals(tipoImpacto)) {
            button.setText("X");
            button.setStyle("-fx-background-color: red;");
        } else if ("Agua".equals(tipoImpacto)) {
            button.setText("O");
            button.setStyle("-fx-background-color: blue;");
        }
    }


    /**
     *
     * @param row
     * @param column
     * @param gridPane
     * @return
     */
    private Node getNodeAt(int row, int column, GridPane gridPane) {
        Node result = null;
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @param event
     */
    @FXML
    public void onMouseReleased(MouseEvent event) {
        int fila = (int) (event.getSceneY() / 30);
        int columna = (int) (event.getSceneX() / 30);
    }


    /**
     *
     * @param imageView
     * @param barco
     */
    private void setupImageDrag(ImageView imageView, Barco barco) {

        imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mouseX = event.getSceneX() - event.getX();
                mouseY = event.getSceneY() - event.getY();
            }
        });


        imageView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getSceneX() - mouseX;
                double y = event.getSceneY() - mouseY;
                imageView.setLayoutX(x);
                imageView.setLayoutY(y);
            }
        });


        imageView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int fila = (int) (event.getSceneY() / 30);
                int columna = (int) (event.getSceneX() / 30);
                juego.colocarBarcoJugador(fila, columna, barco, true);
            }
        });
    }


    /**
     *
     */
    @FXML
    public void initialize() {
        if (flotaMaquina == null) {
           flotaMaquina = new Barco[10];

            flotaMaquina[0] = new Barco("Portaaviones", 4);
            flotaMaquina[1] = new Barco("Submarino1", 3);
            flotaMaquina[2] = new Barco("Submarino2", 3);
            flotaMaquina[3] = new Barco("Destructor3", 2);
            flotaMaquina[4] = new Barco("Destructor2", 2);
            flotaMaquina[5] = new Barco("Fragata1" , 1);
            flotaMaquina[6] = new Barco("Fragata2" , 1);
            flotaMaquina[7] = new Barco("Fragata3" ,1);
            flotaMaquina[8] = new Barco("Fragata4" , 1);
            flotaMaquina[9] = new Barco("Destructor1" ,2);
        }

        // Arreglo de las imágenes y los barcos
        ImageView[] barcosImages = {
                Portaaviones, Submarino1, Submarino2, Destructor3,
                Destructor2, Fragata1, Fragata2, Fragata3, Fragata4, Destructor1
        };

        if (flotaMaquina != null) {

            for (int i = 0; i < barcosImages.length; i++) {
                setupImageDrag(barcosImages[i], flotaMaquina[i]);
            }
        }
    }


    /**
     *
     */
    private void verificarGanador() {
        if (juego.verificarVictoria()) {
            mensajeLabel.setText("¡Has ganado!");
            reiniciarJuego();
        }
    }

}