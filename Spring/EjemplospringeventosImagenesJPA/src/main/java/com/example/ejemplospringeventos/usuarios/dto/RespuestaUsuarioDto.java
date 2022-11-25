package com.example.ejemplospringeventos.usuarios.dto;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioConEventos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuarioDto {
    UsuarioConEventos usuario;
}
