package com.example.ejemplospringeventosimagenjdbc.eventos;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.example.ejemplospringeventosimagenjdbc.eventos.dto.EventoInsertDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Evento {
    @Id
    private int id;
    private String titulo;
    private String descripcion;
    private double precio;
    private LocalDate fecha;
    private String imagen;

    public Evento(EventoInsertDto dto) {
        this.titulo = dto.getTitulo();
        this.descripcion = dto.getDescripcion();
        this.precio = dto.getPrecio();
        this.fecha = dto.getFecha();
        this.imagen = dto.getImagen();
    }
}
