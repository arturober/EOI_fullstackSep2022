package com.example.ejerciciospringequipos.jugadores;

import java.util.List;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadoresService {
    private final JugadoresRepository jugadoresRepository;
    private final JdbcAggregateTemplate jdbcTemplate;

    public List<Jugador> getByEquipo(int id) {
        return jugadoresRepository.findByIdEquipo(id);
    }

    public List<Jugador> getByCiudad(String ciudad) {
        return jugadoresRepository.findByCiudad(ciudad);
    }

    public Jugador getById(int id) {
        return jugadoresRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));
    }

    public Jugador insert(Jugador jugador) {
        return jdbcTemplate.insert(jugador);
    }

    public void delete(int id) {
        jugadoresRepository.deleteById(id);
    }

}
