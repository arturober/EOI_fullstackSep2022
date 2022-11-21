package com.example.ejerciciospringequipos.equipos;

import java.util.List;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class EquiposService {
    private final EquiposRepository equiposRepository;
    private final JdbcAggregateTemplate jdbcTemplate;

    public List<Equipo> getAll() {
        return (List<Equipo>)equiposRepository.findAll();
    }

    public List<Equipo> getByNombre(String nombre) {
        return equiposRepository.findByNombreContaining(nombre);
    }

    public List<Equipo> getByCiudad(String ciudad) {
        return equiposRepository.findByCiudad(ciudad);
    }

    public Equipo getById(int id) {
        return equiposRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada")
        );
    }

    public Equipo insert(Equipo e) {
        return jdbcTemplate.insert(e);
    }

    public void delete(int id) {
        equiposRepository.deleteById(id);
    }
}
