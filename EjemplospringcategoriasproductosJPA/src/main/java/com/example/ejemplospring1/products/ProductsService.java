package com.example.ejemplospring1.products;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospring1.categories.CategoriesRepository;
import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository prodRepository;
    private final CategoriesRepository catRepository;

    public List<Product> getProducts(int idCat) {
        return prodRepository.findByCategory(idCat);
    }

    public ProductWithCategory getProduct(int idProd) {
        Product p = prodRepository.findById(idProd).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
        );
        CategoryWithoutProducts c = catRepository.findCategoryById(p.getIdCategory());
        return new ProductWithCategory(p, c);
    }

    public Product insertProduct(Product p) {
        if(!catRepository.existsById(p.getIdCategory())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada");
        }
        return prodRepository.save(p);
    }

    public void deleteProduct(int id) {
        prodRepository.deleteById(id);
    }
}
