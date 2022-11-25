package com.example.ejemplospringbanco.cuentas;

import java.util.List;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentasService {
    private final CuentasRepository cuentasRepository;
    private final JdbcAggregateTemplate jdbcTemplate;

    public List<Cuenta> getAll() {
        return (List<Cuenta>) cuentasRepository.findAll();
    }

    public Cuenta getByNumero(int numero) {
        return cuentasRepository.findById(numero).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada"));
    }

    public Cuenta insert(Cuenta cuenta) {
        if (cuentasRepository.existsById(cuenta.getNumero())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cuenta ya existe", null);
        }
        // Usando jdbcTemplate podemos forzar un insert cuando la clave primaria
        // no es autogenerada (el método save haría un update)
        return jdbcTemplate.insert(cuenta);
    }

    public Cuenta update(Cuenta cuenta, int numero) {
        if (!cuentasRepository.existsById(numero)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada", null);
        }
        cuenta.setNumero(numero);
        return jdbcTemplate.update(cuenta);
    }

    public void delete(int numero) {
        cuentasRepository.deleteById(numero);
    }
}
