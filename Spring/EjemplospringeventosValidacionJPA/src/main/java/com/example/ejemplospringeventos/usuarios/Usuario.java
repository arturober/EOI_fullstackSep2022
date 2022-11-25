package com.example.ejemplospringeventos.usuarios;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import com.example.ejemplospringeventos.eventos.Evento;
import com.example.ejemplospringeventos.usuarios.dto.UsuarioInsertDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String correo;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "usuario_asiste_evento", 
        joinColumns = @JoinColumn(name = "usuario"), 
        inverseJoinColumns = @JoinColumn(name = "evento"))
    private List<Evento> eventos;

    public Usuario(UsuarioInsertDto dto) {
        this.nombre = dto.getNombre();
        this.correo = dto.getCorreo();
    }
}
