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
    public final static String BANCO = "jdbc:mariadb://localhost:3306/banco";
    public final static String USER = "root";
    public final static String PASS = "";

    public static void transferirSaldo(int numOrigen, int numDestino, double cantidad) {
        try (Connection conn = DriverManager.getConnection(BANCO, USER, PASS)) {
            conn.setAutoCommit(false);
            PreparedStatement stOrigen = conn.prepareStatement("UPDATE cuenta SET saldo = saldo - ? WHERE numero = ?");
            stOrigen.setDouble(1, cantidad);
            stOrigen.setInt(2, numOrigen);
            int filasOrigen = stOrigen.executeUpdate();

            if(filasOrigen == 1) {
                PreparedStatement stDest = conn.prepareStatement("UPDATE cuenta SET saldo = saldo + ? WHERE numero = ?");
                stDest.setDouble(1, cantidad);
                stDest.setInt(2, numDestino);
                int filasDest = stDest.executeUpdate();

                if(filasDest == 1) {
                    conn.commit(); // Confirmar transacción
                } else {
                    System.err.println("Cuenta destino no válida");
                    conn.rollback(); // Cancelar. No es necesario al cerrar la conexión en el try. Si no se cerrara, sí es necesario
                }
            } else {
                System.err.println("Cuenta origen no válida");
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        transferirSaldo(1001, 2002, 500);
    }
}
