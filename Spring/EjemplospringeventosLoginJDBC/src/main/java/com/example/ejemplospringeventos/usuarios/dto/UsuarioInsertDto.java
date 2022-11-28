package com.example.ejemplospringeventos.usuarios.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInsertDto {
    @NotBlank(message = "El nombre del usuario debe estar presente")
    private String nombre;
    @NotNull(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato correcto")
    private String correo;
    @NotNull(message = "La contraseña es obligatoria")
    @Length(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    private String password;
}
