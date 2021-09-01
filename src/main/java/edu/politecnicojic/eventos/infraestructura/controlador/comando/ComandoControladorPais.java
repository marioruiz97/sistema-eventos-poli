package edu.politecnicojic.eventos.infraestructura.controlador.comando;

import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import edu.politecnicojic.eventos.infraestructura.controlador.ControladorBase;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.PaisDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/pais")
public class ComandoControladorPais extends ControladorBase {

    @PostMapping
    public ResponseEntity<RespuestaApi> crearPais(@Validated @RequestBody PaisDto paisDto, BindingResult result) {
        if (result.hasErrors()) return objetoInvalido(result);
        // TODO: corregir metodo
        List<String> errores = new ArrayList<>();
        return new ResponseEntity<>(new RespuestaApi("", errores), HttpStatus.CREATED);
    }
}
