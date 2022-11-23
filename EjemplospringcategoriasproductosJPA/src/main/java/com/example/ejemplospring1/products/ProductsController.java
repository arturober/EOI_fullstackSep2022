package com.example.ejemplospring1.products;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplospring1.products.proyecciones.ProductWithCategory;
import com.example.ejemplospring1.products.proyecciones.ProductWithoutCategory;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public List<ProductWithoutCategory> getProducts(@RequestParam int category) {
        return productsService.getProducts(category);
    }

    @GetMapping("/{id}")
    public ProductWithCategory getProduct(@PathVariable int id) {
        return productsService.getProduct(id);
    }

    @PostMapping()
    public Product insertProduct(@RequestBody Product p) {
        return productsService.insertProduct(p, p.getCategory().getId());
    }

    @DeleteMapping("/{idProd}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int idProd) {
        productsService.deleteProduct(idProd);
    }
}
