package com.example.ejemplospringeventos.usuarios;

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

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {
    private final UsuariosService usuariosService;

    @GetMapping
    public List<UsuarioSinEventos> getAll() {
        return usuariosService.getAll();
    }

    @GetMapping("/{id}")
    public UsuarioConEventos getById(@PathVariable int id) {
        return usuariosService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insert(@RequestBody Usuario u) {
        return usuariosService.insert(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        usuariosService.delete(id);
    }
}
