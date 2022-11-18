package com.example.ejemplospring1.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.example.ejemplospring1.products.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Category {
    @Id private int id;
    private String name;
}

// Esto equivale más o menos a lo de arriba
// public record Category(@Id int id, String name) {}
