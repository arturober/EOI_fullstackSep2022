package com.example.ejemplospring1.products;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospring1.categories.CategoriesRepository;
import com.example.ejemplospring1.categories.Category;
import com.example.ejemplospring1.categories.proyecciones.CategoryWithoutProducts;
import com.example.ejemplospring1.products.proyecciones.ProductWithCategory;
import com.example.ejemplospring1.products.proyecciones.ProductWithoutCategory;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository prodRepository;
    private final CategoriesRepository catRepository;

    public List<ProductWithoutCategory> getProducts(int idCat) {
        return prodRepository.findByCategory(idCat);
    }

    public ProductWithCategory getProduct(int idProd) {
        return prodRepository.findProductById(idProd).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
        );
    }

    public Product insertProduct(Product p, int idCat) {
        Category c = catRepository.findById(idCat).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada")
        );
        c.setProducts(null);
        p.setCategory(c);
        return prodRepository.save(p);
    }

    public void deleteProduct(int id) {
        prodRepository.deleteById(id);
    }
}
