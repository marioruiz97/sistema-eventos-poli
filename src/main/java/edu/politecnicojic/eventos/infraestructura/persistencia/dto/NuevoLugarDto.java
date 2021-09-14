package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class NuevoLugarDto {

	@NotEmpty
	String nombre;

	@NotEmpty
	String direccion;

	@NotNull
	private Integer ciudad;

	@NotNull
	private Integer sede;

}
