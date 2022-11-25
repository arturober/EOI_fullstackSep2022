package com.example.ejemplospring1.products.proyecciones;

import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;

public interface ProductWithCategory {
    int getId();
    String getReference();
    String getName();
    double getPrice();
    CategoryWithoutProducts getCategory();
}
