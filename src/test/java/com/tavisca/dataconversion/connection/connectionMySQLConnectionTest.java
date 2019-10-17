package com.tavisca.dataconversion.connection;

import org.junit.Test;

import java.sql.*;

import static junit.framework.TestCase.assertTrue;

public class connectionMySQLConnectionTest {
    @Test
    public void canEstablishConnectionWithMySQLServer() throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        assertTrue(connection != null);
    }
}
