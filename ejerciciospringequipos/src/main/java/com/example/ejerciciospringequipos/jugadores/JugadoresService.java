package com.example.ejerciciospringequipos.jugadores;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadoresService {
    private final JugadoresRepository jugadoresRepository;
}
