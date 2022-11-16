package com.example.ejemplospring1.categories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Integer> {
    // @Query("SELECT * FROM `category` WHERE name LIKE :name")
    // List<Category> getByName(String name);

    // Lo mismo que el método de arriba
    List<CategoryWithoutProducts> findByNameContaining(String name); 

    // Devuelve todas las categorías 
    List<CategoryWithoutProducts> findBy();

}
