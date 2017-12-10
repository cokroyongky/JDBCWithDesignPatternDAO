package util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void getConnection() throws SQLException {
        Connection connection =  DBConnection.INSTANCE.getConnection();
        System.out.println(connection);
    }
}