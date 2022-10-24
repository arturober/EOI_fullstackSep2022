package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    static final String db = "jdbc:mariadb://localhost:3306/pruebas";
    static final String user = "root";
    static final String pass = "";

    public static void main( String[] args ) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            System.out.println("Conexión establecida");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
