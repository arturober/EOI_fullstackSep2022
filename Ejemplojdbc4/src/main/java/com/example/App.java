package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public final static String PRODUCT_MANAGER = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String USER = "root";
    public final static String PASS = "";

    public static void mostrarCategorias() {
        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
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

    public static void mostrarProductosCategoria(int idCat) {
        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM product WHERE category = ?");
            st.setInt(1, idCat);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String referencia = rs.getString("reference");
                String nombre = rs.getString("name");
                double precio = rs.getDouble("price");
                System.out.printf("%5d %6s %20.20s %10.2f€\n", id, referencia, nombre, precio);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void insertCategoriaProducto(String nombreCat, String ref, String nombreProd, double precio) {
        try (Connection conn = DriverManager.getConnection(PRODUCT_MANAGER, USER, PASS)) {
            conn.setAutoCommit(false);
            // INSERT CATEGORIA
            PreparedStatement stCat = conn.prepareStatement("INSERT INTO category (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            stCat.setString(1, nombreCat);
            stCat.executeUpdate();
            ResultSet rs = stCat.getGeneratedKeys();
            rs.first();
            int idCat = rs.getInt(1);

            // INSERT PRODUCTO
            PreparedStatement stProd = conn.prepareStatement("INSERT INTO product (reference, name, price, category) VALUES (?, ?, ?, ?)");
            stProd.setString(1, ref);
            stProd.setString(2, nombreProd);
            stProd.setDouble(3, precio);
            stProd.setInt(4, idCat);
            stProd.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        insertCategoriaProducto("Ejemplo", null, "Producto ejemplo", 10);
        mostrarCategorias();
    }
}
