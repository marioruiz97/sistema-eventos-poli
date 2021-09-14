package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import lombok.Data;

@Data
public class NuevoUsuarioDto {

	@NotEmpty
	String identificacion;

	@NotEmpty
	String nombres;

	@NotEmpty
	String apellidos;

	@NotEmpty
	@Email
	String email;

	@NotNull
	TipoRelacion tipoRelacion;

	@NotEmpty
	String nombreUsuario;

	@NotEmpty
	String contrasena;
}
