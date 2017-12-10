package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    public static final DBConnection INSTANCE = new DBConnection();
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "kampus";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    //  Ini akan dieksekusi lebih dahulu
    static {
        try {
//            driver diload
            Class.forName(DRIVER).newInstance();
//            setting database
            connection = DriverManager.getConnection(URL + DB_NAME, USERNAME, PASSWORD);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    private DBConnection() {

    }

    public Connection getConnection() {
        return connection;
    }

}
