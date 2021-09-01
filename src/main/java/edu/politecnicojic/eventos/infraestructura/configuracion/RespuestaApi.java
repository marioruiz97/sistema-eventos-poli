package edu.politecnicojic.eventos.infraestructura.configuracion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class RespuestaApi {

    @Getter
    @Setter
    private String mensaje;

    @Getter
    @Setter
    private List<String> errores;


}
