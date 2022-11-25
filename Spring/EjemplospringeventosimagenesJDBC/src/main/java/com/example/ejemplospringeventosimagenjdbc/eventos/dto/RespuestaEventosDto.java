package com.example.ejemplospringeventosimagenjdbc.eventos.dto;

import java.util.List;

import com.example.ejemplospringeventosimagenjdbc.eventos.Evento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventosDto {
    List<Evento> eventos;
}
