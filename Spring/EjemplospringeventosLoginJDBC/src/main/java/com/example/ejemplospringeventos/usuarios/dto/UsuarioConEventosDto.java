package com.example.ejemplospringeventos.usuarios.dto;

import java.util.List;

import com.example.ejemplospringeventos.eventos.Evento;
import com.example.ejemplospringeventos.usuarios.Usuario;


public class UsuarioConEventosDto extends Usuario {
    private List<Evento> eventos;

    public UsuarioConEventosDto(int id, String nombre, String correo, String password ,List<Evento> eventos) {
        super(id, nombre, correo, password);
        this.eventos = eventos;
    }

    public UsuarioConEventosDto(Usuario u, List<Evento> eventos) {
        super(u.getId(), u.getNombre(), u.getCorreo(), u.getPassword());
        this.eventos = eventos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    
}
