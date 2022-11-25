package com.example.ejemplospring1.products;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

import com.example.ejemplospring1.categories.Category;
import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id private int id;
    private String reference;
    private String name;
    private double price;
    @Column("category")
    private int idCategory;

    @Transient // No lo tiene en cuenta para las consultas a la base de datos
    private CategoryWithoutProducts category;
}
