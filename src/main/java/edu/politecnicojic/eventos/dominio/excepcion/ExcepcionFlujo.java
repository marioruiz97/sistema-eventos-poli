package edu.politecnicojic.eventos.dominio.excepcion;

public class ExcepcionFlujo extends RuntimeException {
    public ExcepcionFlujo(String mensaje) {
        super(mensaje);
    }
}
