package com.example.ejemplospring1.categories;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
