package com.example.ejemplospringeventos.eventos.proyecciones;

import java.util.List;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

public interface EventoConUsuarios extends EventoSinUsuarios {
    List<UsuarioSinEventos> getUsuarios();
}
