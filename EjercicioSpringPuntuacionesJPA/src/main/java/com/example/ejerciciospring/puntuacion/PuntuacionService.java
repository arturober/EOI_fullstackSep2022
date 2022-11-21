package com.example.ejerciciospring.puntuacion;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PuntuacionService {
    private final PuntuacionRepository puntuacionRepository;

    public List<Puntuacion> getPuntuaciones() {
        return puntuacionRepository.findAll();
    }

    public Puntuacion getPuntuacion(int id) {
        return puntuacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Puntuación no encontrada"));
    }

    public Puntuacion insert(Puntuacion p) {
        p.setId(0); // Por si acaso nos envían una id (haría un update en lugar de insert)
        return puntuacionRepository.save(p);
    }

    public Puntuacion update(Puntuacion p, int id) {
        if(!puntuacionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Puntuación no encontrada");
        }
        p.setId(id); // Al tener una id hace un update en lugar de un insert
        return puntuacionRepository.save(p);
    }

    public void delete(int id) {
        puntuacionRepository.deleteById(id);
    }

}
