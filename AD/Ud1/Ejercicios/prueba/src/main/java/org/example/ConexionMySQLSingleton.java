package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionMySQLSingleton {
    private static Connection connection = null;

    public static Connection getConexion() {
        if (connection == null) {
            Properties prop = new Properties();
            prop.put("user", "root");
            prop.put("password", "mysql");
            prop.put("useSSL", false);
            prop.put("useUnicode", true);
            prop.put("serverTimezone", "UTC");
            String url = "jdbc:mysql://localhost:3307/world";

            try {
                connection = DriverManager.getConnection(url, prop);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void cerrar() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}