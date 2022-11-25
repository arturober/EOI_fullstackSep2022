package com.example.ejemplospringeventosimagenjdbc.eventos.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AsistirEventoDto {
    @Positive
    private int usuario;
}
