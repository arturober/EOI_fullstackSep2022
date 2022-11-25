package ejemplo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void cambiaProducto(Producto producto) throws IOException {
        producto.setNombre("Mesa");
    }

    public static void main(String[] args)  {
        Producto p = new Producto("Silla", 100);
        Producto p2 = new Producto(p.getNombre(), p.getPrecio());

        System.out.println(p);
        System.out.println(p2);

        if(p.equals(p2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son diferentes");
        }

        // System.out.println(p.getNombre().toUpperCase() + " - " + p.getPrecio());
        // System.out.println("Total con impuesto (10): " + p.getPrecioImpuesto(10));
        // System.out.println("Total con impuesto (21): " + p.getPrecioImpuesto());
    }
}
