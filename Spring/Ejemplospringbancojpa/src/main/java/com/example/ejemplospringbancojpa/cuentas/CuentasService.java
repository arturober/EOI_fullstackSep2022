package com.example.ejemplospringbancojpa.cuentas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentasService {
    private final CuentasRepository cuentasRepository;

    public List<Cuenta> getAll() {
        return cuentasRepository.findAll();
    }

    public Cuenta getByNumero(int numero) {
        return cuentasRepository.findById(numero).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada"));
    }

    public Cuenta insert(Cuenta cuenta) {
        if (cuentasRepository.existsById(cuenta.getNumero())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cuenta ya existe", null);
        }
        return cuentasRepository.save(cuenta);
    }

    public Cuenta update(Cuenta cuenta, int numero) {
        if (!cuentasRepository.existsById(numero)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada", null);
        }
        cuenta.setNumero(numero);
        return cuentasRepository.save(cuenta);
    }

    public void delete(int numero) {
        cuentasRepository.deleteById(numero);
    }
}
