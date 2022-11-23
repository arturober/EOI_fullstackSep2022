package com.example.ejemplospring1.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ejemplospring1.products.proyecciones.ProductWithCategory;
import com.example.ejemplospring1.products.proyecciones.ProductWithoutCategory;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.id = :category")
    List<ProductWithoutCategory> findByCategory(@Param("category") int category);

    Optional<ProductWithCategory> findProductById(int id);
}
