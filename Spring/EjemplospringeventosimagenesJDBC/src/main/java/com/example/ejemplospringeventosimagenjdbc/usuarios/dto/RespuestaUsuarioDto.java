package com.example.ejemplospringeventosimagenjdbc.usuarios.dto;

import com.example.ejemplospringeventosimagenjdbc.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuarioDto {
    UsuarioConEventosDto usuario;
}
