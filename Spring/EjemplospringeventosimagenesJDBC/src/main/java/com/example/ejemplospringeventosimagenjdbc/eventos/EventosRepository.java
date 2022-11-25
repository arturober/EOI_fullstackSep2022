package com.example.ejemplospringeventosimagenjdbc.eventos;

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
}
