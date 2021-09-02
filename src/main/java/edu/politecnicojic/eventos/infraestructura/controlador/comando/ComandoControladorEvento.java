package edu.politecnicojic.eventos.infraestructura.controlador.comando;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorEvento;
import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import edu.politecnicojic.eventos.infraestructura.controlador.ControladorBase;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("api/v1/eventos")
public class ComandoControladorEvento extends ControladorBase {

    private final ManejadorEvento manejadorEvento;

    @Autowired
    public ComandoControladorEvento(ManejadorEvento manejadorEvento) {
        this.manejadorEvento = manejadorEvento;
    }

    @PostMapping
    public ResponseEntity<RespuestaApi> crear(@RequestBody @Valid NuevoEventoDto nuevoEventoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return objetoInvalido(bindingResult);
        Evento nuevoEvento = manejadorEvento.crear(nuevoEventoDto);
        RespuestaApi respuesta = crearRespuestaExitosa("Se ha creado Evento con éxito", nuevoEvento);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }
}
