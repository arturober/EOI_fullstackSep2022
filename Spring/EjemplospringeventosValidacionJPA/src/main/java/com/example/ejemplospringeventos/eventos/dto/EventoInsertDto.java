package com.example.ejemplospringeventos.eventos.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EventoInsertDto {
    @NotNull(message = "El título tiene que estar presente")
    @Length(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @Positive(message = "El precio debe tener un valor superior a 0")
    private double precio;
    @NotNull(message = "La fecha tiene que estar presente")
    @Future(message = "La fecha debe ser posterior a hoy")
    private LocalDate fecha;
}
