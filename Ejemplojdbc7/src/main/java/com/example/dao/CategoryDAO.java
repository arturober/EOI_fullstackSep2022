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

    /**
     * Inserta una categoría en la tabla category
     * @param c Categoría a insertar
     * @return La categoría insertada con la id autogenerada
     */
    Category insert(Category c);

    /**
     * Actualiza una categoría en la tabla category
     * @param c Categoría a actualizar
     * @return true si se ha actualizado una categoría
     */
    boolean update(Category c);

    /**
     * Borra una categoría en la tabla category
     * @param id id de la categoría a borrar
     * @return true si se ha borrado una categoría
     */
    boolean delete(int id);
}
