package com.example.api;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("task.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);

        stage.setTitle("Bored Task App");

        // Set icon for the stage
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/api/bored.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}