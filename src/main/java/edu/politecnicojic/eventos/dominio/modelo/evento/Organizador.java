package edu.politecnicojic.eventos.dominio.modelo.evento;

import lombok.Getter;

@Getter
public abstract class Organizador {

	private final TipoOrganizador tipoOrganizador;

	protected Organizador(TipoOrganizador tipoOrganizador) {
		this.tipoOrganizador = tipoOrganizador;
	}
}
