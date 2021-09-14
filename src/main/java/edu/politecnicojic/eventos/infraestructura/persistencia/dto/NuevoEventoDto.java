package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import lombok.Data;

@Data
public class NuevoEventoDto {

	String idEvento;

	@NotEmpty
	String titulo;

	@NotEmpty
	String descripcion;

	@NotEmpty
	List<@Valid Categoria> categorias;

	@NotNull
	@FutureOrPresent
	LocalDate fecha;

	@NotNull
	@Valid
	LugarDto lugar;

	@NotEmpty
	List<String> facilitadores;

	@NotEmpty
	List<OrganizadorDto> organizadores;
}
