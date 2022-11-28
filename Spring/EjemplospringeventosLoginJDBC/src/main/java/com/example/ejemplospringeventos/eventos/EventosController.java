package com.example.ejemplospringeventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplospringeventos.eventos.dto.AsistirEventoDto;
import com.example.ejemplospringeventos.eventos.dto.EventoConUsuariosDto;
import com.example.ejemplospringeventos.eventos.dto.EventoInsertDto;
import com.example.ejemplospringeventos.eventos.dto.RespuestaEventoDto;
import com.example.ejemplospringeventos.eventos.dto.RespuestaEventosDto;
import com.example.ejemplospringeventos.usuarios.Usuario;
import com.example.ejemplospringeventos.usuarios.UsuariosService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;
    private final UsuariosService usuariosService;

    @GetMapping
    public RespuestaEventosDto getAll() {
        return new RespuestaEventosDto(eventosService.getAll());
    }

    @GetMapping("/{id}")
    public RespuestaEventoDto getById(@PathVariable int id) {
        Evento e = eventosService.getById(id);
        List<Usuario> asistentes = usuariosService.getAsistentesEvento(id);
        EventoConUsuariosDto evDto = new EventoConUsuariosDto(e, asistentes);
        return new RespuestaEventoDto(evDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento insert(@RequestBody @Valid EventoInsertDto evDto) {
        return eventosService.insert(new Evento(evDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }

    @PostMapping("/{idEvento}/asistir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void asistirEvento(@PathVariable int idEvento, @RequestBody @Valid AsistirEventoDto asistirDto) {
        eventosService.asistirEvento(idEvento, asistirDto.getUsuario());
    }

    @DeleteMapping("/{idEvento}/asistir/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void asistirEvento(@PathVariable int idEvento, @PathVariable int idUsuario) {
        eventosService.dejarAsistirEvento(idEvento, idUsuario);
    }
}
