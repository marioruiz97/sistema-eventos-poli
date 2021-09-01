package edu.politecnicojic.eventos.infraestructura.controlador;

import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ControladorBase {

    /**
     * Método usado cuando hay errores en el binding result, retorna un bad_request
     * con los errores existentes
     *
     * @param result
     * @return
     */
    public ResponseEntity<RespuestaApi> objetoInvalido(BindingResult result) {
        String mensaje = "EL objeto ingresado no cumple las validaciones mínimas";
        List<String> errores = result.getFieldErrors().stream().map(err -> {
            String field = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(err.getField()), ' ') + ": ";
            return field + err.getDefaultMessage();
        }).collect(Collectors.toList());
        return new ResponseEntity<>(new RespuestaApi(mensaje, errores), HttpStatus.BAD_REQUEST);
    }
}
