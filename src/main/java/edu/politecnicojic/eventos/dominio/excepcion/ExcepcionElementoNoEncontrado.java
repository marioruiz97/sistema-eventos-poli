package edu.politecnicojic.eventos.dominio.excepcion;

public class ExcepcionElementoNoEncontrado extends RuntimeException {

    public ExcepcionElementoNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
