package com.tavisca.dataconversion.connection;

import java.sql.*;

public class MySQLConnection {
    static Connection connection;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gce?autoReconnect=true&useSSL=false", "root", "root");
            return connection;
        }
        else{
            return connection;
        }
    }
}
