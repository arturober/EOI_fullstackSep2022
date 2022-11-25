package com.example.ejemplospringbancojpa.cuentas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Spring Data JPA
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Cuenta {
    @Id private int numero;
    @Column(nullable = false)
    private String cliente;
    private double saldo;
}
