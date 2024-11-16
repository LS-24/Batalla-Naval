package com.example.batallanaval.controller;

import com.example.batallanaval.view.BatallaNavalView;
import com.example.batallanaval.view.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainController {

    private MainView mainView;


    /**
     *
     * @param mainView
     */
    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     *
     */
    @FXML
    private Button iniciarJuegoButton;

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void oniniciarjuegoMouseClicked(MouseEvent event) throws IOException {

        if (mainView != null) {
            mainView.close();
        }

        BatallaNavalView batallaNavalView = BatallaNavalView.getInstance();

    }

}
