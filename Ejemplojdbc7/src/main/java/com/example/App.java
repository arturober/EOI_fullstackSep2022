package com.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
    private static CategoryDAO catDao;

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
        // Mostrar todas las categorías
        // El usuario elige una id de categoría a modificar (opcional: comprobar que la categoría existe)
        // Se le pide un nuevo nombre
        // Se modifica
    }

    public static void borraCategoria() {
        // Mostrar todas las categorías
        // El usuario elige una id de categoría a borrar 
        // se borra
    }

    public static void showMenu() {
        int opcion;
        do {
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Mostrar categorías");
            System.out.println("2. Añadir categoría");
            System.out.println("3. Modificar categoría");
            System.out.println("4. Borrar categoría");
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
            }
        } while(opcion != 0);
    }

    public static void main( String[] args ) throws SQLException {
        // Creamos Pool de conexiones MariaDB
        MariaDbPoolDataSource pool = new MariaDbPoolDataSource("jdbc:mariadb://localhost:3306/product-manager?user=root&maxPoolSize=10");
        pcon = pool.getPooledConnection();

        catDao = new CategoryDAOMariaDB(pcon);

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
