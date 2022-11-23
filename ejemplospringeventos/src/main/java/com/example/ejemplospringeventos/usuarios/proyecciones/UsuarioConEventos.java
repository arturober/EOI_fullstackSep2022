package com.example.ejemplospringeventos.usuarios.proyecciones;

import java.util.List;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoSinUsuarios;

public interface UsuarioConEventos extends UsuarioSinEventos {
    List<EventoSinUsuarios> getEventos();
}
