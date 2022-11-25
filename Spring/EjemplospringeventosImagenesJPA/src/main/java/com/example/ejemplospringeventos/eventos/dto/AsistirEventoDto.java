package com.example.ejemplospringeventos.eventos.dto;

import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AsistirEventoDto {
    @Positive
    private int usuario;
}
