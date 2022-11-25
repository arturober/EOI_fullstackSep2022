package com.example.ejerciciospring.puntuacion;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Puntuacion {
    @Id
    private int id;
    private String jugador;
    private int puntuacion;
}
