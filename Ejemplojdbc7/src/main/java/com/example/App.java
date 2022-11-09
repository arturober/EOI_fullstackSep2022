package com.example;

import java.sql.SQLException;
import java.util.List;

import javax.sql.PooledConnection;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import com.example.dao.CategoryDAO;
import com.example.dao.CategoryDAOMariaDB;
import com.example.entidades.Category;

/**
 * Ejemplo 3 de JDBC pero con Pool de conexiones
 */
public class App {
    private static PooledConnection pcon;

    public static void main( String[] args ) throws SQLException {
        // Creamos Pool de conexiones MariaDB
        MariaDbPoolDataSource pool = new MariaDbPoolDataSource("jdbc:mariadb://localhost:3306/product-manager?user=root&maxPoolSize=10");
        pcon = pool.getPooledConnection();

        CategoryDAO catDao = new CategoryDAOMariaDB(pcon);

        List<Category> cats = catDao.findAll();
        cats.forEach(c -> System.out.println(c));

        System.out.println("Obtener la categoría 1");
        Category c1 = catDao.findById(1);
        System.out.println(c1);

        System.out.println("Obtener categoría que no existe");
        Category c99 = catDao.findById(99);
        System.out.println(c99);

    }
}
