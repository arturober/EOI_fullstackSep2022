package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Consultas SELECT con Statement
 */
public class App {
    public final static String CADENA_CONEXION = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String USER = "root";
    public final static String PASS = "";

    /**
     * Listar todas las categorías
     */
    public static void ejemplo1() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("name");
                System.out.println(id + " - " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Listar categorías desde el final hacia atrás
     */
    public static void ejemplo2() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.afterLast();
            while (rs.previous()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("name");
                System.out.println(id + " - " + nombre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Cambiar el nombre a la última categoría por "Laptops"
     */
    public static void ejemplo3() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.last();
            rs.updateString("name", "Laptops");
            int id = rs.getInt("id");
            rs.updateRow();
            System.out.println("Categoría " + id + " actualizada");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Insertar una nueva categoría a partir de un resultSet
     */
    public static void ejemplo4() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.moveToInsertRow();
            rs.updateString("name", "New category"); // La id no hace falta (autonumérica)
            rs.insertRow();
            rs.last(); // VAmos a la fila insertada
            System.out.println("Categoría insertada con id " + rs.getInt("id"));
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Borrar la última categoría
    */
    public static void ejemplo5() {
        try (Connection conn = DriverManager.getConnection(CADENA_CONEXION, USER, PASS)) {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            rs.last();
            int id = rs.getInt("id");
            rs.deleteRow();
            System.out.println("Categoría " + id + " borrada");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // ejemplo1();
        // System.out.println(" ---------------------- ");
        // ejemplo2();
        // ejemplo3();
        // ejemplo4();
        // ejemplo5();
    }
}
