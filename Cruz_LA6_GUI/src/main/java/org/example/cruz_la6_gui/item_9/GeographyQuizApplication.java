package org.example.cruz_la6_gui.item_9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GeographyQuizApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/cruz_la6_gui/geography-quiz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 350);
        stage.setScene(scene);
        stage.setTitle("Geography Quiz");
        stage.show();;
    }
}
