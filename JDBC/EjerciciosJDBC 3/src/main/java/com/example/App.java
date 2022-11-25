package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Apartado 5 de los ejercicios de JDBC
 */
public class App {
    public final static String PRODUCT_MANAGER = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String USER = "root";
    public final static String PASS = "";

    public static void mostrarCategorias(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM category");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("name");
            System.out.println(id + " - " + nombre);
        }
    }

    // Transacción
    public static void borrarCategoria(Connection conn, int id) throws SQLException {
        try {
            conn.setAutoCommit(false);
            PreparedStatement stProd = conn.prepareStatement("DELETE FROM product WHERE category = ?");
            stProd.setInt(1, id);
            stProd.executeUpdate();

            PreparedStatement stCat = conn.prepareStatement("DELETE FROM category WHERE id = ?");
            stCat.setInt(1, id);
            stCat.executeUpdate();

            conn.commit();
        } catch(SQLException e) {
            conn.rollback();
            throw e; // Lanzo otra vez la excepción para que la capture el try..catch del main
        }

        conn.setAutoCommit(true);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            mostrarCategorias(conn);
            System.out.print("\nCategoría a borrar: ");
            int id = sc.nextInt();
            borrarCategoria(conn, id);
            System.out.println("Categoría " + id + " borrada");
            // Muchas más operaciones
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
