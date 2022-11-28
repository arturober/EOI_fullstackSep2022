package com.example.ejemplospringeventos.eventos.dto;

import java.util.List;

import com.example.ejemplospringeventos.eventos.Evento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventosDto {
    List<Evento> eventos;
}
