package edu.politecnicojic.eventos.dominio.modelo.evento;

import lombok.Getter;

public class Programa extends Organizador {

	@Getter
	private Integer codigo;

	@Getter
	private String nombre;

	@Getter
	private Integer codigoArea;

	public Programa(Integer codigo, String nombre, Integer codigoArea) {
		super(TipoOrganizador.PROGRAMA);
		this.codigo = codigo;
		this.nombre = nombre;
		this.codigoArea = codigoArea;
	}

}
