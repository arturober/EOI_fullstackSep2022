package com.example.ejemplospring1.categories.proyecciones;

/*
 * Esta interfaz sirve para que en las consultas que obtengan
 * categorías, solo se incluyan los campos id y name, y no la lista de productos
 * Se denominan proyecciones a este tipo de interfaces
 */
public interface CategoryWithoutProducts {
    int getId();
    String getName();
}
