package com.example.batallanaval;

import com.example.batallanaval.view.BatallaNavalView;
import com.example.batallanaval.view.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainView.getInstance();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}