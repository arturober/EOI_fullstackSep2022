package com.example.ejemplospring1.categories;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService catService;

    @GetMapping
    public List<Category> getCategories() {
        return catService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return catService.getCategory(id);
    }
}
