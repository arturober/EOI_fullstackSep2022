package com.eoi;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // Sustituye (@Getter @Setter y @ToString)
public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private LocalDate fechaNacimiento;
}
