package com.example.ejemplospringeventosimagenjdbc.usuarios.dto;

import java.util.List;

import com.example.ejemplospringeventosimagenjdbc.eventos.Evento;
import com.example.ejemplospringeventosimagenjdbc.usuarios.Usuario;


public class UsuarioConEventosDto extends Usuario {
    private List<Evento> eventos;

    public UsuarioConEventosDto(int id, String nombre, String correo, List<Evento> eventos) {
        super(id, nombre, correo);
        this.eventos = eventos;
    }

    public UsuarioConEventosDto(Usuario u, List<Evento> eventos) {
        super(u.getId(), u.getNombre(), u.getCorreo());
        this.eventos = eventos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    
}
