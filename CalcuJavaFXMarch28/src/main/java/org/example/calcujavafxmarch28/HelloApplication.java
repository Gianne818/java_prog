package org.example.calcujavafxmarch28;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 400);
        scene.getStylesheets().add(getClass().getResource("/org/example/calcujavafxmarch28/styles/styles.css").toExternalForm());
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
}