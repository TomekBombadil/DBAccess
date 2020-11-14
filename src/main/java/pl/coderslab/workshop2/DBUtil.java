package pl.coderslab.workshop2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/!!DATABASE!!?useSSL=false&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    public static Connection getConnection(String database) throws SQLException {
        String dbUrlProper = DB_URL.replace("!!DATABASE!!", database);
        Connection conn = DriverManager.getConnection(dbUrlProper, DB_USER, DB_PASS);
        return conn;
    }
}
