package com.example.ejemplospringeventos.eventos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.ejemplospringeventos.eventos.dto.EventoInsertDto;
import com.example.ejemplospringeventos.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descripcion;
    private double precio;
    private LocalDate fecha;
    
    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios;

    public Evento(EventoInsertDto dto) {
        this.titulo = dto.getTitulo();
        this.descripcion = dto.getDescripcion();
        this.precio = dto.getPrecio();
        this.fecha = dto.getFecha();
    }
}
