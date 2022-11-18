package com.example.ejerciciospringequipos.jugadores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadoresRepository extends CrudRepository<Jugador, Integer> {

}
