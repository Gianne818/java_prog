package org.example.cruz_la6_gui.item_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberCounterApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/cruz_la6_gui/number-counter-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Counter");
        primaryStage.show();
    }
}
