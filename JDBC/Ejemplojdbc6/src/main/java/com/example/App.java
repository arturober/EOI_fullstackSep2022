package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import org.mariadb.jdbc.MariaDbPoolDataSource;

/**
 * Ejemplo 3 de JDBC pero con Pool de conexiones
 */
public class App {
    private static PooledConnection pcon;

    public static void mostrarCategorias() {
        try (Connection conn = pcon.getConnection()) {
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
     * INSERT category
     */
    public static int insertCategory(String name) {
        String sql = "INSERT INTO category (name) VALUES (?)";

        try (Connection conn = pcon.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Solo para id autogeneradas
            st.setString(1, name);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.first(); // Vamos a la primera y única fila
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public static boolean updateCategory(int id, String newName) {
        String sql = "UPDATE category SET name = ? WHERE id = ?";

        try (Connection conn = pcon.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, newName);
            st.setInt(2, id);
            int filas = st.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public static boolean deleteCategory(int id) {
        String sql = "DELETE FROM category WHERE id = ?";

        try (Connection conn = pcon.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            int filas = st.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public static void main( String[] args ) throws SQLException {
        // Creamos Pool de conexiones MariaDB
        MariaDbPoolDataSource pool = new MariaDbPoolDataSource("jdbc:mariadb://localhost:3306/product-manager?maxPoolSize=10");
        pool.setUser("root");
        pool.setPassword("");
        pcon = pool.getPooledConnection();

        int id = insertCategory("Example");
        if(id != -1) { // OK
            System.out.println("Category 'Example' inserted with id = " + id);
        } 

        mostrarCategorias();

        if(updateCategory(id, "Nuevo nombre")) {
            System.out.println("Categoría actualizada!");
        } else {
            System.out.println("Categoría no actualizada...");
        }

        mostrarCategorias();

        if(deleteCategory(id)) {
            System.out.println("Categoría borrada!");
        } else {
            System.out.println("Categoría no borrada...");
        }

        mostrarCategorias();
    }
}
