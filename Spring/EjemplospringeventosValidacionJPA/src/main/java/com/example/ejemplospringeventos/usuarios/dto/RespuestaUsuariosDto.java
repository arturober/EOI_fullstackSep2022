package com.example.ejemplospringeventos.usuarios.dto;

import java.util.List;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuariosDto {
    private List<UsuarioSinEventos> usuarios;
}
