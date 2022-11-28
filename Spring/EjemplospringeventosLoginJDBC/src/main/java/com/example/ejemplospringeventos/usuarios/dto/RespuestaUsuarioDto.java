package com.example.ejemplospringeventos.usuarios.dto;

import com.example.ejemplospringeventos.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuarioDto {
    UsuarioConEventosDto usuario;
}
