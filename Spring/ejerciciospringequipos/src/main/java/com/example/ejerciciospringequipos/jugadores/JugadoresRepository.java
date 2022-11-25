package com.example.ejerciciospringequipos.jugadores;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadoresRepository extends CrudRepository<Jugador, Integer> {
    // Usa nombre de la propiedad de la clase "idEquipo" y no la columna de la tabla "equipo"
    List<Jugador> findByIdEquipo(int idEquipo);

    @Query("SELECT j.* FROM jugador j INNER JOIN equipo e ON j.equipo = e.id WHERE e.ciudad = :ciudad")
    List<Jugador> findByCiudad(@Param("ciudad") String ciudad);
}
