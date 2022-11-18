package com.example.ejemplospring1.categories;

import java.util.List;

import com.example.ejemplospring1.products.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
public class CategoryWithProducts extends Category {
    private List<Product> products;

    public CategoryWithProducts(int id, String name, List<Product> products) {
        super(id, name);
        this.products = products;
    }
}
