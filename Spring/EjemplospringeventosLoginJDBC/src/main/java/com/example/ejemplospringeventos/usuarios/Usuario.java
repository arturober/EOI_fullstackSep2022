package com.example.ejemplospringeventos.usuarios;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.example.ejemplospringeventos.usuarios.dto.UsuarioInsertDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id
    private int id;
    private String nombre;
    private String correo;
    private String password;

    public Usuario(UsuarioInsertDto dto) {
        this.nombre = dto.getNombre();
        this.correo = dto.getCorreo();
        this.password = dto.getPassword();
    }
}
