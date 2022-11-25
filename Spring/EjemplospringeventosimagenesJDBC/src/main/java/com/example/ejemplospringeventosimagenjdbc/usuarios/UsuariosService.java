package com.example.ejemplospringeventosimagenjdbc.usuarios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    List<Usuario> getAll() {
        return (List<Usuario>) usuariosRepository.findAll();
    }

    public Usuario getById(int id) {
        return usuariosRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

    }

    public List<Usuario> getAsistentesEvento(int idEvento) {
        return usuariosRepository.getAsistentesEvento(idEvento);
    }

    public Usuario insert(Usuario u) {
        return usuariosRepository.save(u);
    }

    public void delete(int idUsuario) {
        usuariosRepository.deleteById(idUsuario);
    }
}
