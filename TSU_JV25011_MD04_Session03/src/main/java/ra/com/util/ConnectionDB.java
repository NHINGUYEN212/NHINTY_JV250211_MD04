package ra.com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Projects_db";
    private static final String USER = "root";
    private static final String PASS = "G62jJHTP";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn, CallableStatement callStmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw  new RuntimeException(e);
            }
        }
        if (callStmt != null) {
            try {
                callStmt.close();
            } catch (SQLException e) {
                throw  new RuntimeException(e);
            }
        }
    }

}
