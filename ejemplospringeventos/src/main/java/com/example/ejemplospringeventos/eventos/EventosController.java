package com.example.ejemplospringeventos.eventos;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.ejemplospringeventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController 
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;
    
    @GetMapping
    public List<EventoSinUsuarios> getAll() {
        return eventosService.getAll();
    }

    @GetMapping("/{id}")
    public EventoConUsuarios getById(@PathVariable int id) {
        return eventosService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento insert(@RequestBody Evento e) {
        return eventosService.insert(e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }
}
