package edu.politecnicojic.eventos.dominio.modelo.evento;

public enum TipoOrganizador {
	FACULTAD, PROGRAMA;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}
