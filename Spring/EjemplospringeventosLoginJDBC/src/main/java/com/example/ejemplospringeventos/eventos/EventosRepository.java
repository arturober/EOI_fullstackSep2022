package com.example.ejemplospringeventos.eventos;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends CrudRepository<Evento, Integer> {
    @Query("INSERT INTO usuario_asiste_evento VALUES (:usuario,:evento)")
    void asistir(@Param("usuario") int idUsuario, @Param("evento") int idEvento);

    @Query("DELETE FROM usuario_asiste_evento WHERE usuario = :usuario AND evento = :evento")
    void noAsistir(@Param("usuario") int idUsuario, @Param("evento") int idEvento);

    @Query("SELECT e.* FROM evento e, usuario_asiste_evento uae WHERE e.id = uae.evento AND uae.usuario = :usuario")
    List<Evento> getEventosUsuario(@Param("usuario") int idUsuario);
}
