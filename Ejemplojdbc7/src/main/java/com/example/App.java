package com.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.sql.PooledConnection;

import org.mariadb.jdbc.MariaDbPoolDataSource;

import com.example.dao.CategoryDAO;
import com.example.dao.CategoryDAOMariaDB;
import com.example.dao.ProductDAO;
import com.example.dao.ProductDAOMariaDB;
import com.example.entidades.Category;
import com.example.entidades.Product;

/**
 * Ejemplo 3 de JDBC pero con Pool de conexiones
 */
public class App {
    private static PooledConnection pcon;
    private static CategoryDAO catDao;
    private static ProductDAO prodDao;

    public static void mostrarCategorias() {
        List<Category> cats = catDao.findAll();
        cats.forEach(c -> System.out.println(c));
    }

    public static void insertarCategoria() {
        System.out.print("Nombre categoría: ");
        String nombre = System.console().readLine();
        Category c = new Category(0, nombre);
        Category insertedCat = catDao.insert(c);
        System.out.println("Categoría insertada: " + insertedCat);
    }

    public static void actualizaCategoria() {
        mostrarCategorias();
        System.out.print("Categoría a modificar: ");
        int idCat = Integer.parseInt(System.console().readLine());

        Category c = catDao.findById(idCat);
        if(c != null) {
            System.out.print("Dime nuevo nombre: ");
            c.setName(System.console().readLine());
            catDao.update(c);
        } else {
            System.err.println("Categoría no existe");
        }
    }

    public static void borraCategoria() {
        mostrarCategorias();
        System.out.print("Categoría a borrar: ");
        int idCat = Integer.parseInt(System.console().readLine());
        catDao.delete(idCat);
    }

    public static void mostrarProductos() {
        mostrarCategorias();
        System.out.print("Elige una categoría: ");
        int idCat = Integer.parseInt(System.console().readLine());

        List<Product> prods = prodDao.findByCategory(idCat);
        prods.forEach(p -> System.out.println(p));
    }

    public static void insertarProducto() {
        mostrarCategorias();
        System.out.print("Elige una categoría: ");
        int idCat = Integer.parseInt(System.console().readLine());

        System.out.print("Referencia: ");
        String ref = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(System.console().readLine());
        
        Product p = new Product(0, ref, nombre, precio, idCat);
        Product pInsert = prodDao.insert(p);
        System.out.println("Producto insertado: " + pInsert);
    }

    public static void borrarProducto() {
        mostrarProductos();
        System.out.print("Producto a borrar: ");
        int idProd = Integer.parseInt(System.console().readLine());
        prodDao.delete(idProd);
    }

    public static void showMenu() {
        int opcion;
        do {
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Mostrar categorías");
            System.out.println("2. Añadir categoría");
            System.out.println("3. Modificar categoría");
            System.out.println("4. Borrar categoría");
            System.out.println("5. Mostrar productos");
            System.out.println("6. Añadir producto");
            System.out.println("7. Borrar producto");
            System.out.println("0. Salir");
            
            System.out.print("Elige una opción: ");
            try {
                opcion = Integer.parseInt(System.console().readLine());
            } catch(NumberFormatException e) {
                System.err.println("La opción debe ser numérica");
                opcion = -1;
            }

            switch(opcion) {
                case 1 -> mostrarCategorias();
                case 2 -> insertarCategoria();
                case 3 -> actualizaCategoria();
                case 4 -> borraCategoria();
                case 5 -> mostrarProductos();
                case 6 -> insertarProducto();
                case 7 -> borrarProducto();
            }
        } while(opcion != 0);
    }

    public static void main( String[] args ) throws SQLException {
        // Creamos Pool de conexiones MariaDB
        MariaDbPoolDataSource pool = new MariaDbPoolDataSource("jdbc:mariadb://localhost:3306/product-manager?user=root&maxPoolSize=10");
        pcon = pool.getPooledConnection();

        catDao = new CategoryDAOMariaDB(pcon);
        prodDao = new ProductDAOMariaDB(pcon);

        showMenu();

        // System.out.println("Obtener la categoría 1");
        // Category c1 = catDao.findById(1);
        // System.out.println(c1);

        // System.out.println("Obtener categoría que no existe");
        // Category c99 = catDao.findById(99);
        // System.out.println(c99);

        // Category c25 = catDao.findById(25);
        // c25.setName("Nombre cambiado");
        // catDao.update(c25);

        // catDao.delete(25);
    }
}
