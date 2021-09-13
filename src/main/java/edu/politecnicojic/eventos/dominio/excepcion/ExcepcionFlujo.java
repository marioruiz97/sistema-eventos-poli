package edu.politecnicojic.eventos.dominio.excepcion;

public class ExcepcionFlujo extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFlujo(String mensaje) {
		super(mensaje);
	}

}
