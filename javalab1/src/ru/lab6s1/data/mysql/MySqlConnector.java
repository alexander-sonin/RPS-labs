package ru.lab6s1.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private final String driver = "com.mysql.jdbc.Driver";
    private ConnectionProperties properties;
    public MySqlConnector(ConnectionProperties properties) {
        this.properties = properties;
        setupDriver();
    }
    private void setupDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private String formatProperties(ConnectionProperties properties) {
        return String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC&useSSL=false",
                properties.getHost(), properties.getPort(), properties.getDatabase());
    }
    public Connection getConnection() throws SQLException  {
        return DriverManager.getConnection(formatProperties(properties), properties.getUser(), properties.getPassword());
    }
}
