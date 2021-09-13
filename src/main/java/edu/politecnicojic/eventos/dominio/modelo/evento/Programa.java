package edu.politecnicojic.eventos.dominio.modelo.evento;

import lombok.Getter;

public class Programa extends Organizador {

	@Getter
	private String nombre;

	@Getter
	private Integer codigoArea;

	public Programa(TipoOrganizador tipoOrganizador, String nombre, Integer codigoArea) {
		super(tipoOrganizador);
		this.nombre = nombre;
		this.codigoArea = codigoArea;
	}

}
