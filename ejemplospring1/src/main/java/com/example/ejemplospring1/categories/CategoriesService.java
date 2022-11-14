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
        return catRepository.findById(id).orElse(null);
    }
}
