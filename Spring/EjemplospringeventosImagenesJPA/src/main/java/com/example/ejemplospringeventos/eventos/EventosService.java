package com.example.ejemplospringeventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ejemplospringeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.ejemplospringeventos.eventos.proyecciones.EventoSinUsuarios;
import com.example.ejemplospringeventos.usuarios.Usuario;
import com.example.ejemplospringeventos.usuarios.UsuariosRepository;
import com.example.ejemplospringeventos.utils.ImageUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventosService {
    private final EventosRepository eventosRepository;
    private final UsuariosRepository usuariosRepository;
    private final ImageUtils imageUtils;

    public List<EventoSinUsuarios> getAll() {
        return eventosRepository.findBy();
    }

    public EventoConUsuarios getById(int id) {
        EventoConUsuarios e = eventosRepository.findEventoById(id);
        if (e == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado");
        }
        return e;
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
        Evento e = eventosRepository.findById(idEvento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));
        Usuario u = usuariosRepository.findById(idUsuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        e.getUsuarios().add(u);
        u.getEventos().add(e);
        eventosRepository.save(e);
    }

    public void dejarAsistirEvento(int idEvento, int idUsuario) {
        Evento e = eventosRepository.findById(idEvento)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado"));
        Usuario u = usuariosRepository.findById(idUsuario)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        e.getUsuarios().remove(u);
        u.getEventos().remove(e);
        eventosRepository.save(e);
    }
}
