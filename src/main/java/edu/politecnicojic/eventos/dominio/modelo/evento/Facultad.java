package edu.politecnicojic.eventos.dominio.modelo.evento;

import lombok.Getter;

public class Facultad extends Organizador {

	// private Integer codigo;

	@Getter
	private String nombre;

	@Getter
	private String ubicacion;

	@Getter
	private String nroTelefono;

	public Facultad(TipoOrganizador tipoOrganizador, String nombre, String ubicacion, String nroTelefono) {
		super(tipoOrganizador);
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.nroTelefono = nroTelefono;
	}

}
