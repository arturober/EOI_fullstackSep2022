package com.example.ejerciciospring.puntuacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepository extends JpaRepository<Puntuacion, Integer> {
}
