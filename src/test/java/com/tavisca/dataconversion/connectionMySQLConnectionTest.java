package com.tavisca.dataconversion;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class connectionMySQLConnectionTest {
    @Test
    public void canEstablishConnectionWithMySQLServer() throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        assertTrue(connection != null);
    }
}
