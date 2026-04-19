package com.example.javafxapril14.screens.landing;

import com.example.javafxapril14.SceneSwitcher;
import com.example.javafxapril14.database.RetrieveData;
import com.example.javafxapril14.database.UpdateData;
import com.example.javafxapril14.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LandingController {
    @FXML private Label labelFullName, labelUsername, labelUserId, labelLoginTime;
    @FXML private PasswordField pfCurrentPassword, pfNewPassword;
    @FXML private Button btnLogout, btnChangePassword;

    private User currentUser;

    public void initialize() {
        // Initial deserialization when the scene loads
        loadAndDisplaySession();
    }

    private void loadAndDisplaySession() {
        File file = new File("currentUser.ser");
        if (!file.exists()) {
            System.out.println("No session file found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // Task: Deserialize user data on the landing page
            currentUser = (User) ois.readObject();

            labelFullName.setText(currentUser.getFullName());
            labelUsername.setText(currentUser.getUsername());
            labelUserId.setText(String.valueOf(currentUser.getUserId()));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy - h:mm a");
            labelLoginTime.setText(dtf.format(LocalDateTime.now()));

            System.out.println("User session deserialized from disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveSession(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("currentUser.ser"))) {
            // Task: Serialize the user object (Password is transient/ignored)
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onChangePasswordClick() {
        String currentPassword = pfCurrentPassword.getText();
        String newPassword = pfNewPassword.getText();

        if (currentPassword.isEmpty() || newPassword.isEmpty()) {
            System.out.println("Error: Fields cannot be empty.");
            return;
        }

        RetrieveData retriever = new RetrieveData();
        // 1. Verify credentials via JDBC
        if (!retriever.checkPassword(currentUser.getUserId(), currentPassword)) {
            System.out.println("Error: Incorrect current password.");
            return;
        }

        UpdateData updater = new UpdateData();
        // 2. Update DB via JDBC
        if (updater.updatePassword(currentUser.getUserId(), newPassword)) {
            System.out.println("Database updated.");

            // 3. Serialize again
            saveSession(currentUser);

            // 4. Requirement: Must be deserialized after change
            loadAndDisplaySession();

            pfCurrentPassword.clear();
            pfNewPassword.clear();
        } else {
            System.out.println("Error: Database update failed.");
        }
    }

    @FXML
    private void onLogoutClick() {
        // Task: Delete the serialized file on logout
        File file = new File("currentUser.ser");
        if (file.exists()) file.delete();

        SceneSwitcher.goToScene(btnLogout, "login-view.fxml", "Login");
    }
}