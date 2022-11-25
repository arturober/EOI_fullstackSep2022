package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            while (rs.next()) {
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

    public static void apartado2() {
        int edad = 40;
        String contrato = "1998-01-01";
        String sql = "SELECT * FROM empleados WHERE edad >= ? AND contrato < ?";

        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, edad);
            st.setString(2, contrato);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("num") + " - " + rs.getString("nombre") +
                        " - " + rs.getInt("edad") + ": " + rs.getString("contrato"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // apartado1();
        apartado2();
    }
}
