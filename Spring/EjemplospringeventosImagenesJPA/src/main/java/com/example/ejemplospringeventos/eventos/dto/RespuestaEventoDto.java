package com.example.ejemplospringeventos.eventos.dto;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoConUsuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventoDto {
    EventoConUsuarios evento;
}
