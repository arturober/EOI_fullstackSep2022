package com.example.ejemplospringeventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.ejemplospringeventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class EventosService {
    private final EventosRepository eventosRepository;

    public List<EventoSinUsuarios> getAll() {
        return eventosRepository.findBy();
    }

    public EventoConUsuarios getById(int id) {
        EventoConUsuarios e = eventosRepository.findEventoById(id);
        if(e == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado");
        }
        return e;
    }

    public Evento insert(Evento e) {
        e.setId(0);
        return eventosRepository.save(e);
    }

    public void delete(int idEvento) {
        eventosRepository.deleteById(idEvento);
    }
}
