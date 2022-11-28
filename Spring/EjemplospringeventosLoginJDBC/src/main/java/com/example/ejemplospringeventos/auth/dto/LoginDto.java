package com.example.ejemplospringeventos.auth.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LoginDto {
    @NotNull(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato correcto")
    private String correo;
    @NotNull(message = "La contraseña es obligatoria")
    @Length(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    private String password;
}
