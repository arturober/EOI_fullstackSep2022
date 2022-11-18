package com.example.ejemplospring1.products;

import com.example.ejemplospring1.categories.Category;

import lombok.Data;

@Data
public class ProductWithCategory extends Product {
    private Category category;

    public ProductWithCategory(int id, String reference, String name, double price, int idCategory, Category category) {
        super(id, reference, name, price, idCategory);
        this.category = category;
    }

    public ProductWithCategory(Product p, Category category) {
        super(p.getId(), p.getReference(), p.getName(), p.getPrice(), category.getId());
        this.category = category;
    }
}
