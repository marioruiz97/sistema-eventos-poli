package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LugarDto {

	@NotEmpty
	String nombre;

	@NotEmpty
	String direccion;
}
