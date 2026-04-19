package com.example.javafxapril14.screens.register;

import com.example.javafxapril14.SceneSwitcher;
import com.example.javafxapril14.database.InsertData;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {
    @FXML private TextField tfFullName;
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;
    @FXML private Button btnSignIn;
    @FXML private Label labelLoginLink;

    @FXML
    private void onRegisterClick() {
        String fullName = tfFullName.getText();
        String username = tfUsername.getText();
        String password = pfPassword.getText();

        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        InsertData inserter = new InsertData();
        if (inserter.registerUser(username, password, fullName)) {
            System.out.println("Registration successful!");
            SceneSwitcher.goToScene(btnSignIn, "login-view.fxml", "Login");
        } else {
            System.out.println("Registration failed. Username might be taken.");
        }
    }

    @FXML
    private void onLoginLinkLabelClick() {
        SceneSwitcher.goToScene(labelLoginLink, "login-view.fxml", "Login");
    }
}