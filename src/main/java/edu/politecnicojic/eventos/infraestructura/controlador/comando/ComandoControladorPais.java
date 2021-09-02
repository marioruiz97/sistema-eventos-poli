package edu.politecnicojic.eventos.infraestructura.controlador.comando;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorPais;
import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import edu.politecnicojic.eventos.infraestructura.controlador.ControladorBase;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.PaisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/pais")
public class ComandoControladorPais extends ControladorBase {

    @Autowired
    private ManejadorPais manejadorPais;


    @PostMapping
    public ResponseEntity<RespuestaApi> crearPais(@Validated @RequestBody PaisDto paisDto, BindingResult result) {
        if (result.hasErrors()) return objetoInvalido(result);
        manejadorPais.crear(paisDto);
        RespuestaApi respuestaApi = crearRespuestaExitosa("Se ha creado el país con éxito");
        return new ResponseEntity<>(respuestaApi, HttpStatus.CREATED);
    }
}
