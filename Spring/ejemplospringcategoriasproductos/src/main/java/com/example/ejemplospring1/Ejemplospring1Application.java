package com.example.ejemplospring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * En este ejemplo, manejaremos categorías y productos,
 * Pero los productos están relacionados con una categoría en las entidades
 * y dependen totalmente de la categoría para las operaciones
 * Es decir, no se puede por ejemplo insertar un producto directamente,
 * sino que debemos obtener su categoría y a dicha categoría añadirle el producto
 */
@SpringBootApplication
public class Ejemplospring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplospring1Application.class, args);
	}
}
