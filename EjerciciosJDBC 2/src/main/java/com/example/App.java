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
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement("INSERT INTO departamentos VALUES (?, ?)");
            st.setInt(1, num);
            st.setString(2, nombre);
            int filas = st.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public static boolean deleteDepartamento(int num) {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement("DELETE FROM departamentos WHERE deptno = ?");
            st.setInt(1, num);
            int filas = st.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Listado de departamentos actuales:");
        mostrarDepartamentos();

        System.out.println("---------- Nuevo departamento ----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de departamento: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre departamento: ");
        String nombre = sc.nextLine();
        insertDepartamento(num, nombre);
        System.out.println("Departamento insertado correctamente...");

        mostrarDepartamentos();
        System.out.println("A continuación voy a borrarlo. Presione enter para continuar...");
        sc.nextLine();
        
        deleteDepartamento(num);
        System.out.println("Departamento borrado...");
        mostrarDepartamentos();
    }
}
