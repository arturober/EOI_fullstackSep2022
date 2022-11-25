package com.example.ejemplospringeventos.eventos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.ejemplospringeventos.eventos.proyecciones.EventoSinUsuarios;

@Repository
public interface EventosRepository extends JpaRepository<Evento, Integer> {
    List<EventoSinUsuarios> findBy();
    EventoConUsuarios findEventoById(int id);

    // @Query(value = "INSERT INTO usuario_asiste_evento VALUES (:usuario,:evento)", nativeQuery = true)
    // void asistir(@Param("usuario") int idUsuario, @Param("evento") int idEvento);
}
