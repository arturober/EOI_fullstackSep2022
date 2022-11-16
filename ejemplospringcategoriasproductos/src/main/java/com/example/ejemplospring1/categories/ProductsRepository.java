package com.example.ejemplospring1.categories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT * FROM product WHERE category = :category")
    List<Product> findByCategory(@Param("category") int category);
}
