package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Solución apartado 3 ejercicios JDBC
 */
public class App {
    public final static String CADENA_CONEXION = "jdbc:mariadb://localhost:3306/eoi2";
    public final static String USER = "root";
    public final static String PASS = "";

    public static void mostrarDepartamentos() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM departamentos");
            while (rs.next()) {
                int num = rs.getInt("deptno");
                String nombre = rs.getString("nombre");
                System.out.println(num + " - " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static boolean insertDepartamento(int num, String nombre) {
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de departamento: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre departamento: ");
        String nombre = sc.nextLine();
        // apartado1();
        insertDepartamento(num, nombre);
        mostrarDepartamentos();
        
    }
}
