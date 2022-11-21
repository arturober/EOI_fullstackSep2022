package com.example.ejerciciospringequipos.equipos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipos")
public class EquiposController {
    private final EquiposService equiposService;

    @GetMapping
    public List<Equipo> getAll(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String ciudad) {
        if (nombre != null) {
            return equiposService.getByNombre(nombre);
        } else if (ciudad != null) {
            return equiposService.getByCiudad(ciudad);
        } else {
            return equiposService.getAll();
        }
    }

    @GetMapping("/{id}")
    public Equipo getById(@PathVariable int id) {
        return equiposService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo insert(@RequestBody Equipo e) {
        return equiposService.insert(e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
      equiposService.delete(id);
    }
}
