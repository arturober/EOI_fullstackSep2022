package com.example.ejemplospring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * En este ejemplo veremos como gestionar categorías y productos con Spring Data JPA
 * y relaciones unidireccionales: Categoría se relaciona con sus productos pero no al revés
 */
@SpringBootApplication
public class Ejemplospring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplospring1Application.class, args);
	}
}
