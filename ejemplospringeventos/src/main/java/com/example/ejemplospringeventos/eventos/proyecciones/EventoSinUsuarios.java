package com.example.ejemplospringeventos.eventos.proyecciones;

import java.time.LocalDate;

public interface EventoSinUsuarios {
    int getId();
    String getTitulo();
    String getDescripcion();
    double getPrecio();
    LocalDate getFecha();
}
