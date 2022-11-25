package com.example.ejemplospringeventos.usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
    List<UsuarioSinEventos> findBy();

    UsuarioConEventos findUsuarioById(@Param("id") int id);
}
