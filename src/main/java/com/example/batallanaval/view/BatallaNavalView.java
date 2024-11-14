package com.example.batallanaval.view;

import com.example.batallanaval.controller.BatallaNavalController;
import com.example.batallanaval.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BatallaNavalView extends Stage {

    private BatallaNavalController controller;

    public BatallaNavalView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batallanaval/batallaNavalview.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setScene(scene);
        setTitle("Batalla Naval");
        //getIcons().add(new Image(String.valueOf(getClass().getResource("//"))));
        setResizable(false);
        show();
    }

    public static BatallaNavalView getInstance() throws IOException{
        if (batallaNavalViewHolder.INSTANCE == null){
            return batallaNavalViewHolder.INSTANCE = new BatallaNavalView();
        }else{
            return batallaNavalViewHolder.INSTANCE;
        }
    }

    private static class batallaNavalViewHolder{
        private static BatallaNavalView INSTANCE;
    }

}
