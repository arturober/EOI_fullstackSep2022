package com.example.ejemplospring1.categories;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @GetMapping
    public String getCategories() {
        return "Lista de categorías";
    }

    @GetMapping("/{id}")
    public String getCategory(@PathVariable int id) {
        return "Categoría " + id;
    }
}
