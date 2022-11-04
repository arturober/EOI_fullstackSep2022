package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public final static String CADENA_CONEXION = "jdbc:mariadb://localhost:3306/eoi2";
    public final static String USER = "root";
    public final static String PASS = "";

    public static void apartado1() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categorias");
            while(rs.next()) {
                int categoria = rs.getInt("categoria");
                String titulo = rs.getString("titulo");
                int salario = rs.getInt("salario");
                int trienio = rs.getInt("trienio");
                System.out.println(categoria + " - " + titulo + " - " + salario + " - " + trienio);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main( String[] args ) {
        apartado1();
    }
}
