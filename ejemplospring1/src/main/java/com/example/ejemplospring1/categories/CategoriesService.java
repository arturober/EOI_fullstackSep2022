package com.example.ejemplospring1.categories;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository catRepository;

    public List<Category> getCategories() {
        List<Category> cats = (List<Category>)catRepository.findAll();
        return cats;
    }

    public Category getCategory(int id) {
        return catRepository.findById(id).get();
    }

    public Category insert(Category c) {
        c.setId(0); // Por si acaso nos envían una id (haría un update en lugar de insert)
        return catRepository.save(c);
    }

    public Category update(Category c, int id) {
        c.setId(id); // Al tener una id hace un update en lugar de un insert
        return catRepository.save(c);
    }
}
