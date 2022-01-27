package com.dkuzmyk.videoplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("player.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("DK Player!");
        scene.getStylesheets().add("file:src/main/resources/com/dkuzmyk/videoplayer/main.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}