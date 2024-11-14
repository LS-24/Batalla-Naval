package com.example.batallanaval.controller;

import com.example.batallanaval.view.BatallaNavalView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainController {

    @FXML
    private Button iniciarJuegoButton;

    @FXML
    void oniniciarjuegoMouseClicked(MouseEvent event) throws IOException {

        BatallaNavalView batallaNavalView = BatallaNavalView.getInstance();

    }

}
