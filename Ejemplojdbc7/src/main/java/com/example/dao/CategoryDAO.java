package com.example.dao;

import java.util.List;

import com.example.entidades.Category;

public interface CategoryDAO {
    /**
     * Devuelve todas las categorías
     * @return Lista de objetos Category
     */
    List<Category> findAll();

    /**
     * Busca una categoría a partir de su id
     * @return El objeto categoría encontrado o null si no lo encuentra
     */
    Category findById(int id);
}
