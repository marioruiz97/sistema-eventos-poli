package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SesionDto {

	@NotEmpty
	@Email
	String usuario;

	@NotEmpty
	@Size(min = 6)
	String contrasena;

}
