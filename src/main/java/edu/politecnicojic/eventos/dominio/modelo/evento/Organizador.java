package edu.politecnicojic.eventos.dominio.modelo.evento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Organizador {

	private TipoOrganizador tipoOrganizador;

	protected Organizador(TipoOrganizador tipoOrganizador) {
		this.tipoOrganizador = tipoOrganizador;
	}
}
