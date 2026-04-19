package com.example.javafxapril14.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/april17";
    private static final String USER = System.getenv("db_user");
    private static final String PASSWORD = System.getenv("db_pass");
    // change the user and pass to yours. I'm hiding mine.

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}