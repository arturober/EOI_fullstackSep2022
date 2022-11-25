package com.example.ejemplospringeventosimagenjdbc.eventos.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.ejemplospringeventosimagenjdbc.eventos.Evento;
import com.example.ejemplospringeventosimagenjdbc.usuarios.Usuario;

public class EventoConUsuariosDto extends Evento {
    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public EventoConUsuariosDto(int id, String titulo, String descripcion, double precio, LocalDate fecha,
            String imagen, List<Usuario> usuarios) {
        super(id, titulo, descripcion, precio, fecha, imagen);
        this.usuarios = usuarios;
    }

    public EventoConUsuariosDto(Evento e, List<Usuario> usuarios) {
        super(e.getId(), e.getTitulo(), e.getDescripcion(), e.getPrecio(), e.getFecha(), e.getImagen());
        this.usuarios = usuarios;
    }
}
