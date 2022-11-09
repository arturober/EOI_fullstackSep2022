package com.example.dao;

import java.util.List;

import com.example.entidades.Product;

public interface ProductDAO {
    List<Product> findByCategory(int idCat);

    Product insert(Product p);
}
