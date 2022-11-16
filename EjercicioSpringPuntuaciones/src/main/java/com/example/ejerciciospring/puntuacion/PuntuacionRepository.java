package com.example.ejerciciospring.puntuacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepository extends CrudRepository<Puntuacion, Integer> {
}
