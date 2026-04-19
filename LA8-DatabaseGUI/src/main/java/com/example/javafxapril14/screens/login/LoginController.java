package com.example.javafxapril14.screens.login;

import com.example.javafxapril14.SceneSwitcher;
import com.example.javafxapril14.database.RetrieveData;
import com.example.javafxapril14.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;

public class LoginController {
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;
    @FXML private Button btnLogin;
    @FXML private Label labelRegisterLink;

    @FXML
    private void onLoginButtonClick() {
        String username = tfUsername.getText();
        String password = pfPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Credentials cannot be empty.");
            return;
        }

        RetrieveData retriever = new RetrieveData();
        User user = retriever.authenticate(username, password);

        if (user != null) {
            // Serialize User Object (transient password ensures it's not saved)
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("currentUser.ser"))) {
                oos.writeObject(user);
                SceneSwitcher.goToScene(btnLogin, "landing-view.fxml", "Dashboard");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    @FXML
    private void onRegisterLinkLabelClick() {
        SceneSwitcher.goToScene(labelRegisterLink, "register.fxml", "Create Account");
    }
}