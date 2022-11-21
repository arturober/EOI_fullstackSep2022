package com.example.ejemplospring1.products;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.idCategory = :category")
    List<Product> findByCategory(@Param("category") int category);
}
