package com.example.ejemplospringeventos.usuarios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.ejemplospringeventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    List<UsuarioSinEventos> getAll() {
        return usuariosRepository.findBy();
    }

    public UsuarioConEventos getById(int id) {
        UsuarioConEventos u = usuariosRepository.findUsuarioById(id);
        if(u == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        return u;
    }

    public Usuario insert(Usuario u) {
        u.setId(0);
        return usuariosRepository.save(u);
    }

    public void delete(int idUsuario) {
        usuariosRepository.deleteById(idUsuario);
    }
}
