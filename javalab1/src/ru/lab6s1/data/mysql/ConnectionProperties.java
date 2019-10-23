package ru.lab6s1.data.mysql;

public class ConnectionProperties {
    private String host;
    private int port;
    private String database;
    private String user;
    private String password;
    public ConnectionProperties(String host, int port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }
    public static ConnectionProperties createMySqlProperties(String database, String user, String password) {
        return new ConnectionProperties("localhost", 3306, database, user, password);
    }
    public String getHost() {
        return host;
    }
    public int getPort() {
        return port;
    }
    public String getDatabase() {
        return database;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
}
