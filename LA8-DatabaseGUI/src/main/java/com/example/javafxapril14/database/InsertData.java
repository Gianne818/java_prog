package com.example.javafxapril14.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {
    public boolean registerUser(String username, String password, String fullName) {
        String sql = "INSERT INTO users (username, password, full_name) VALUES (?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, fullName);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}