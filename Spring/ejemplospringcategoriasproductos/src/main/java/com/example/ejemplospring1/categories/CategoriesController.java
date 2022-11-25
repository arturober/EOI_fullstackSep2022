package com.example.ejemplospring1.categories;

import java.util.List;
import java.util.NoSuchElementException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;
import com.example.ejemplospring1.products.Product;
import com.example.ejemplospring1.products.ProductsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService catService;
    private final ProductsService productsService;

    @GetMapping
    public List<CategoryWithoutProducts> getCategories(@RequestParam(required = false) String name) {
        if(name != null) {
            return catService.getCategoriesByName(name);
        } else {
            return catService.getCategories();
        }
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return catService.getCategory(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category c) {
        return catService.insert(c);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category c, @PathVariable int id) {
        return catService.update(c, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        catService.delete(id);
    }

    // Devuelve todos los productos de una categoría
    @GetMapping("/{idCat}/products")
    public List<Product> getProducts( @PathVariable int idCat) {
        return productsService.getProducts(idCat);
    }

    // Inserta un producto en una categoría
    @PostMapping("/{idCat}/products")
    public Product insertProduct(@RequestBody Product p, @PathVariable int idCat) {
        p.setIdCategory(idCat);
        return productsService.insertProduct(p);
    }

    // Borra un producto de una categoría
    @DeleteMapping("/{idCat}/products/{idProd}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int idProd) {
        productsService.deleteProduct(idProd);
    }
}
