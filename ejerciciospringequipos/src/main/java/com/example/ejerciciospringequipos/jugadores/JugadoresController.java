package com.example.ejerciciospringequipos.jugadores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jugadores")
@RequiredArgsConstructor
public class JugadoresController {
    private final JugadoresService jugadoresService;

    // Crear método obtener jugadores de equipos de una ciudad
}
