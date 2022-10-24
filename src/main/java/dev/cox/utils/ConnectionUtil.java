package dev.cox.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton Design Pattern

public class ConnectionUtil {

    private static ConnectionUtil cu;

    public static synchronized ConnectionUtil getConnectionUtil() {
        return (cu == null) ? new ConnectionUtil() : cu;
    }

    //public static Connection getConnection(){
    public static Connection getConnection(){
            try{
                return DriverManager.getConnection(String.format(
                        "jdbc:postgresql://%s:5432/postgres?user=%s&password=%s",
                        System.getenv("HOST"), System.getenv("USER"),
                        System.getenv("PASS")
                ));
            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }

//small sanity check to make sure we can establish a connection to the database
    // don't leave this code in your final project!
    //SUCCESS!!!
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
   }

}

