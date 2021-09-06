package edu.politecnicojic.eventos.infraestructura.configuracion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class RespuestaApi<T> {

    @Getter
    @Setter
    private String mensaje;

    @Getter
    @Setter
    private T datos;

    public RespuestaApi(String mensaje) {
        this.mensaje = mensaje;
    }
}
