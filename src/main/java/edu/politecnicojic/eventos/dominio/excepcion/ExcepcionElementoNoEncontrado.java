package edu.politecnicojic.eventos.dominio.excepcion;

public class ExcepcionElementoNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionElementoNoEncontrado(String mensaje) {
		super(mensaje);
	}
}
