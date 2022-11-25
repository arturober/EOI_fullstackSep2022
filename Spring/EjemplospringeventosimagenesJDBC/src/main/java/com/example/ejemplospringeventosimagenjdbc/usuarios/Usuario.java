package com.example.ejemplospringeventosimagenjdbc.usuarios;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id
    private int id;
    private String nombre;
    private String correo;
}
