package com.example.ejemplospring1.products.proyecciones;

import org.springframework.beans.factory.annotation.Value;

// Proyección para que el repository pueda devolver un producto sin categoría asociada
public interface ProductWithoutCategory {
    int getId();
    String getReference();
    String getName();
    double getPrice();

    // Campo calculado (no está en Product) con el id de la categoría
    @Value("#{target.category.id}")
    int getIdCategory();

    // Ejemplos de campos nuevos calculados

    // default String getProductCode() {
    //     return getReference() + "-" + getName(); 
    // }

    // default double getPriceWithTax() {
    //     return getPrice() * 1.21;
    // }
}
