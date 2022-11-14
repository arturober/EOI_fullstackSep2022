package com.example.ejemplospring1.categories;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        try {
            Category c = catService.getCategory(id);
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // 404 NOT FOUND
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category c) {
        return catService.insert(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category c, @PathVariable int id) {
        try {
            Category updated = catService.update(c, id);
            return ResponseEntity.ok(updated);
        } catch(DbActionExecutionException e) {
            return ResponseEntity.notFound().build(); // 404 NOT FOUND
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        catService.delete(id);
    }
}
