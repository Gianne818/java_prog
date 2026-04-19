package com.example.javafxapril14.database;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
    public static void execute() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "user_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "username VARCHAR(50) UNIQUE NOT NULL, "
                + "password VARCHAR(50) NOT NULL, "
                + "full_name VARCHAR(100) NOT NULL)";

        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'users' verified/created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}