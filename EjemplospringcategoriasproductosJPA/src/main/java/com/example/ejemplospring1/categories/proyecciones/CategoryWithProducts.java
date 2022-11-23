package com.example.ejemplospring1.categories.proyecciones;

import java.util.List;

import com.example.ejemplospring1.products.proyecciones.ProductWithoutCategory;

public interface CategoryWithProducts {
    int getId();
    String getName();
    List<ProductWithoutCategory> getProducts();
}
