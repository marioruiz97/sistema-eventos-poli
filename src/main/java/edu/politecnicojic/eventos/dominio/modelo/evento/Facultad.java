package edu.politecnicojic.eventos.dominio.modelo.evento;

import lombok.Getter;

public class Facultad extends Organizador {

	@Getter
	private Integer codigo;

	@Getter
	private String nombre;

	@Getter
	private String ubicacion;

	@Getter
	private String nroTelefono;

	public Facultad(Integer codigo, String nombre, String ubicacion, String nroTelefono) {
		super(TipoOrganizador.FACULTAD);
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.nroTelefono = nroTelefono;
	}

}
