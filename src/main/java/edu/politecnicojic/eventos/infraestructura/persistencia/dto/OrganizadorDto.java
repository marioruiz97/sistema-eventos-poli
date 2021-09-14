package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import edu.politecnicojic.eventos.dominio.modelo.evento.TipoOrganizador;
import lombok.Data;

@Data
public class OrganizadorDto {

	@NotEmpty
	Integer codigo;

	@NotNull
	TipoOrganizador tipoOrganizador;
}
