package com.example.ejemplospringeventosimagenjdbc.usuarios;

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

import com.example.ejemplospringeventosimagenjdbc.eventos.Evento;
import com.example.ejemplospringeventosimagenjdbc.eventos.EventosService;
import com.example.ejemplospringeventosimagenjdbc.usuarios.dto.RespuestaUsuarioDto;
import com.example.ejemplospringeventosimagenjdbc.usuarios.dto.RespuestaUsuariosDto;
import com.example.ejemplospringeventosimagenjdbc.usuarios.dto.UsuarioConEventosDto;
import com.example.ejemplospringeventosimagenjdbc.usuarios.dto.UsuarioInsertDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final UsuariosService usuariosService;
    private final EventosService eventosService;

    @GetMapping
    public RespuestaUsuariosDto getAll() {
        return new RespuestaUsuariosDto(usuariosService.getAll());
    }

    @GetMapping("/{id}")
    public RespuestaUsuarioDto getById(@PathVariable int id) {
        Usuario u = usuariosService.getById(id);
        List<Evento> eventos = eventosService.eventosUsuario(id);
        return new RespuestaUsuarioDto(new UsuarioConEventosDto(u, eventos));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insert(@RequestBody @Valid UsuarioInsertDto dto) {
        return usuariosService.insert(new Usuario(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        usuariosService.delete(id);
    }
}
