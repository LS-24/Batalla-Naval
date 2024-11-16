package com.example.batallanaval.view;

import com.example.batallanaval.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Stage {

    private MainController controller;

    public MainView() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batallanaval/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setScene(scene);
        setTitle("Batalla Naval");
        //getIcons().add(new Image(String.valueOf(getClass().getResource("//"))));
        setResizable(false);
        show();
    }

    public static MainView getInstance() throws IOException{
        if (mainViewHolder.INSTANCE == null){
            return mainViewHolder.INSTANCE = new MainView();
        }else{
            return mainViewHolder.INSTANCE;
        }
    }

    private static class mainViewHolder{
        private static MainView INSTANCE;
    }
}
