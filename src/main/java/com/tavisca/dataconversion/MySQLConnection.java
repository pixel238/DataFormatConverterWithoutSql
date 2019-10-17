package com.tavisca.dataconversion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    static Connection connection;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gce", "root", "");
            return connection;
        }
        else{
            return connection;
        }
    }
}
