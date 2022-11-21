package com.example.ejerciciospringequipos.jugadores;

import com.example.ejerciciospringequipos.equipos.Equipo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JugadorConEquipo extends Jugador {
    Equipo equipo;

    public JugadorConEquipo(int id, String nombre, int numero, double sueldo, int idEquipo, Equipo equipo) {
        super(id, nombre, numero, sueldo, idEquipo);
        this.equipo = equipo;
    }

    public JugadorConEquipo(Jugador j, Equipo equipo) {
        super(j.getId(), j.getNombre(), j.getNumero(), j.getSueldo(), j.getIdEquipo());
        this.equipo = equipo;
    }
}
