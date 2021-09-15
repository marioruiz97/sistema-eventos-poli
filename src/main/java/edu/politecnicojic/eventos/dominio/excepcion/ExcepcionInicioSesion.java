package edu.politecnicojic.eventos.dominio.excepcion;

public class ExcepcionInicioSesion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionInicioSesion(String mensaje) {
		super(mensaje);
	}
}
