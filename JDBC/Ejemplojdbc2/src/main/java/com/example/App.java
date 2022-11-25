package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public final static String PRODUCT_MANAGER = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String INSTITUTO = "jdbc:mariadb://localhost:3306/instituto";
    public final static String USER = "root";
    public final static String PASS = "";

    /**
     * Mostrar productos con la referencia que indique el usuario MAL
     * Probad lo siguiente como referencia: ' OR name LIKE '% 
     * Muestra todos los productos
     */
    public static void ejemplo1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Referencia del producto a buscar: ");
        String referencia = sc.nextLine();
        String sql = "SELECT * FROM product WHERE reference = '" + referencia + "'";
        System.out.println("Ejecutando: " + sql);

        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ref = rs.getString("reference");
                String nombre = rs.getString("name");
                double precio = rs.getDouble("price");
                System.out.printf("%3d - %8s %20s %10.2f\n", id, ref, nombre, precio);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Mostrar datos de las asignaturas que contengan una cadena en el nombre
     * Probad con esto como nombre (con un espacio al final):
     * ' UNION SELECT fecha, nota, asignatura FROM examen WHERE alumno IN (SELECT nia FROM alumno WHERE nombre = 'Juan'); -- 
     * Debería sacar también las notas del alumno "Pepe"
     */
    public static void ejemplo2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe parte del nombre de la asignatura: ");
        String nombreBuscar = sc.nextLine();
        String sql = "SELECT * FROM asignatura WHERE nombre LIKE '%" + nombreBuscar + "%'";
        System.out.println("Ejecutando: " + sql);

        try (Connection conn = DriverManager.getConnection(INSTITUTO, USER, PASS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso");
                System.out.printf("%-8s %20s %6s\n", codigo, nombre, curso);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Mostrar productos con la referencia que indique el usuario BIEN
     * Aquí no podemos hacer trampas
     */
    public static void ejemplo3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Referencia del producto a buscar: ");
        String referencia = sc.nextLine();
        String sql = "SELECT * FROM product WHERE reference = ?";

        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, referencia); // AQUÍ ASIGNAMOS LOS VALORES
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ref = rs.getString("reference");
                String nombre = rs.getString("name");
                double precio = rs.getDouble("price");
                System.out.printf("%3d - %8s %20s %10.2f\n", id, ref, nombre, precio);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

     /**
     * Mostrar datos de las asignaturas que contengan una cadena en el nombre (BIEN)
     * No funciona el hack del ejemplo 2
     */
    public static void ejemplo4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe parte del nombre de la asignatura: ");
        String nombreBuscar = sc.nextLine();
        String sql = "SELECT * FROM asignatura WHERE nombre LIKE ?";

        try (Connection conn = DriverManager.getConnection(INSTITUTO, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + nombreBuscar + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso");
                System.out.printf("%-8s %20s %6s\n", codigo, nombre, curso);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main( String[] args ) {
        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        ejemplo4();
    }
}
