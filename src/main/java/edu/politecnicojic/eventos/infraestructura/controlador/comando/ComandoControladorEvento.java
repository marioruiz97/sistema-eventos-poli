package edu.politecnicojic.eventos.infraestructura.controlador.comando;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;
import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import edu.politecnicojic.eventos.infraestructura.controlador.ControladorBase;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(Constantes.API_PATH + "eventos")
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
        RespuestaApi<?> respuesta = crearRespuestaExitosa("Se ha creado Evento con éxito", nuevoEvento);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/{idEvento}")
    public ResponseEntity<RespuestaApi> agregarComentario(
            @PathVariable String idEvento,
            @RequestBody @Valid ComentarioDto comentarioDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return objetoInvalido(bindingResult);
        manejadorEvento.agregarComentario(idEvento, comentarioDto);
        RespuestaApi<?> respuesta = crearRespuestaExitosa("Se ha agregado comentario con éxito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}
