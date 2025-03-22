package com.gameshop.dao;

import java.sql.*;

public class CommonDao {
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/gameshop?useUnicode=true&characterEncoding=utf8";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";

    private static Connection conn = null;

    protected Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
