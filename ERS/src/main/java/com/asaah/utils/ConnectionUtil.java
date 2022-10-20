package com.asaah.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static ConnectionUtil cu;

    private static String url;
    private static String user;
    private static String password;

    private ConnectionUtil() {
        url = System.getenv("URL");
        user = System.getenv("USER");
        password = System.getenv("PASSWORD");
    }

    public static synchronized ConnectionUtil getConnectionUtil() {
        return (cu == null) ? new ConnectionUtil() : cu;
    }

    public Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // small sanity check to make sure we can establish a connection to the database
    // don't leave this code in your final project!
//    public static void main(String[] args) throws SQLException {
//        ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
//        Connection conn = cu.getConnection();
//        if (conn != null) {
//            System.out.println("Connection successful" + conn);
//            conn.close();
//        } else {
//            System.out.println("Connection failed");
//        }
//    }
}

