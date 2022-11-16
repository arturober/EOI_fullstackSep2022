package com.example.ejemplospringbanco.cuentas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController @RequiredArgsConstructor
@RequestMapping("/cuentas")
public class CuentasController {
    private final CuentasService cuentasService;

    @GetMapping
    public List<Cuenta> getAll() {
        return cuentasService.getAll();
    }

    @GetMapping("/{numero}")
    public Cuenta getByNumero(@PathVariable int numero) {
        return cuentasService.getByNumero(numero);
    }

    @PostMapping    
    @ResponseStatus(HttpStatus.CREATED)
    public Cuenta insert(@RequestBody Cuenta cuenta) {
        return cuentasService.insert(cuenta);
    }
    
    @PutMapping("/{numero}")
    public Cuenta update(@RequestBody Cuenta cuenta, @PathVariable int numero) {
        return cuentasService.update(cuenta, numero);
    }

    @DeleteMapping("/{numero}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int numero) {
        cuentasService.delete(numero);
    }
}
