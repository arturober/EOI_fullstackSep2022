package com.example.ejemplospringeventosimagenjdbc.usuarios;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
    
    @Query("SELECT u.* FROM usuario u, usuario_asiste_evento uae WHERE u.id = uae.usuario AND uae.evento = :evento")
    List<Usuario> getAsistentesEvento(@Param("evento") int idEvento);
}
