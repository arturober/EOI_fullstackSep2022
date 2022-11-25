package com.example.ejerciciospringequipos.equipos;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Equipo {
    @Id private int id;
    private String nombre;
    private String ciudad;
    private String fechaCreacion;
}
