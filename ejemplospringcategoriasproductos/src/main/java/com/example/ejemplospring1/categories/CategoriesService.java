package com.example.ejemplospring1.categories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository catRepository;
    private final ProductsRepository prodRepository;

    public List<CategoryWithoutProducts> getCategories() {
        return catRepository.findBy();
    }

    public List<CategoryWithoutProducts> getCategoriesByName(String name) {
        // return catRepository.getByName("%" + name + "%");
        return catRepository.findByNameContaining(name);
    }

    public Category getCategory(int id) {
        return catRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada") 
        );
    }

    public Category insert(Category c) {
        c.setId(0); // Por si acaso nos envían una id (haría un update en lugar de insert)
        return catRepository.save(c);
    }

    public Category update(Category c, int id) {
        if(!catRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada", null);
        }
        c.setId(id); // Al tener una id hace un update en lugar de un insert
        return catRepository.save(c);
    }

    public void delete(int id) {
        catRepository.deleteById(id);
    }

    public List<Product> getProducts(int idCat) {
        // Category c = getCategory(idCat);
        // return new ArrayList<>(c.getProducts());
        return prodRepository.findByCategory(idCat);
    }

    public Product insertProduct(Product p, int idCat) {
        Category c = getCategory(idCat);
        p.setCategory(idCat);
        c.getProducts().add(p);
        catRepository.save(c);
        return p;
    }

    public void deleteProduct(int id) {
        prodRepository.deleteById(id);
    }
    
}
