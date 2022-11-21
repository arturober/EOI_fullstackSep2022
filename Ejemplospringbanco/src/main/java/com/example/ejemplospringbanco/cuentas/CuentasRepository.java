package com.example.ejemplospringbanco.cuentas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasRepository extends CrudRepository<Cuenta, Integer> {
    
}
