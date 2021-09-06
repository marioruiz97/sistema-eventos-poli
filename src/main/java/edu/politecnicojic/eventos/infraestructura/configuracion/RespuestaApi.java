package edu.politecnicojic.eventos.infraestructura.configuracion;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RespuestaApi<T> {

    private final String mensaje;
    private T datos;

    public RespuestaApi(String mensaje) {
        this.mensaje = mensaje;
    }
}
