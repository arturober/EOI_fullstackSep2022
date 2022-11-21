
package com.example.ejerciciospring.puntuacion;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/puntuaciones")
public class PuntuacionController {

    private final PuntuacionService puntuacionService;

    @GetMapping
    public List<Puntuacion> getPuntuaciones() {
        return puntuacionService.getPuntuaciones();
    }

    @GetMapping("/{id}")
    public Puntuacion getPuntuacion(@PathVariable int id) {
        return puntuacionService.getPuntuacion(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Puntuacion insertPuntuacion(@RequestBody Puntuacion p) {
        return puntuacionService.insert(p);
    }

    @PutMapping("/{id}")
    public Puntuacion updatePuntuacion(@RequestBody Puntuacion c, @PathVariable int id) {
        return puntuacionService.update(c, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePuntuacion(@PathVariable int id) {
        puntuacionService.delete(id);
    }

}
