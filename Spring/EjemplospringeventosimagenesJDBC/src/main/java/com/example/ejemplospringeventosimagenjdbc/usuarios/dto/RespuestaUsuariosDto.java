package com.example.ejemplospringeventosimagenjdbc.usuarios.dto;

import java.util.List;

import com.example.ejemplospringeventosimagenjdbc.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuariosDto {
    private List<Usuario> usuarios;
}
