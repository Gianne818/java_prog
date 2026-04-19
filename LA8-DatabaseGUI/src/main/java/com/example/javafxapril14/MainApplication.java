package com.example.javafxapril14;

import com.example.javafxapril14.database.CreateTable;
import com.example.javafxapril14.screens.landing.LandingController;
import com.example.javafxapril14.screens.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Ensure Database Table exists
        CreateTable.execute();

        // STRICT LABORATORY REQUIREMENT: Startup Safety Check
        // Delete the serialized file at startup to prevent session reuse
        File sessionFile = new File("currentUser.ser");
        if (sessionFile.exists()) {
            System.out.println("Exists");
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("landing-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Secure Login System");
            stage.setScene(scene);
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Secure Login System");
            stage.setScene(scene);
            stage.show();
        }

        // Always show Login Page first

    }

    public static void main(String[] args) {
        launch();
    }
}