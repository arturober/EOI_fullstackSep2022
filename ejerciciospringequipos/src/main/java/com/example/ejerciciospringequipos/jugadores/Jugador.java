package com.example.ejerciciospringequipos.jugadores;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Jugador {
    @Id private int id;
    private String nombre;
    private int numero;
    private double sueldo;
    @Column("equipo")
    private int idEquipo;
}
