package com.example.ejemplospringeventosimagenjdbc.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospringeventosimagenjdbc.usuarios.UsuariosRepository;
import com.example.ejemplospringeventosimagenjdbc.utils.ImageUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventosService {
    private final EventosRepository eventosRepository;
    private final UsuariosRepository usuariosRepository;
    private final ImageUtils imageUtils;

    public List<Evento> getAll() {
        return (List<Evento>) eventosRepository.findAll();
    }

    public Evento getById(int id) {
        return eventosRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));
    }

    public Evento insert(Evento e) {
        if(e.getImagen() != null) {
            e.setImagen(imageUtils.saveImageBase64("eventos", e.getImagen()));
        }
        return eventosRepository.save(e);
    }

    public void delete(int idEvento) {
        eventosRepository.deleteById(idEvento);
    }

    public void asistirEvento(int idEvento, int idUsuario) {
        eventosRepository.asistir(idUsuario, idEvento);
    }

    public void dejarAsistirEvento(int idEvento, int idUsuario) {
        eventosRepository.noAsistir(idUsuario, idEvento);
    }
}
