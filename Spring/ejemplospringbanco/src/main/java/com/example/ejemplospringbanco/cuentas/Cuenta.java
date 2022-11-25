package com.example.ejemplospringbanco.cuentas;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Spring Data JDBC
@Data @AllArgsConstructor @NoArgsConstructor
public class Cuenta {
    @Id private int numero;
    private String cliente;
    private double saldo;
}
