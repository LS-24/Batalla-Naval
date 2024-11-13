package com.example.batallanaval.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BatallaNavalController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}