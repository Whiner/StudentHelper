package ru.java.works.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private Connection connection;
    private String url;

    public Connection getConnection() {
        return connection;
    }

    public boolean isOpen() throws SQLException {
        if(connection != null){
            return !connection.isClosed();
        } else {
            return false;
        }

    }
    public Connection connectToDB() throws SQLException {
        url = "jdbc:sqlite:StudentHelper.db";
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public void closeConnection() throws SQLException {
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }

    private static Connector instance;
    private Connector(){}
    public static Connector getInstance(){
        if(instance == null){
            instance = new Connector();
        }
        return instance;
    }

}
