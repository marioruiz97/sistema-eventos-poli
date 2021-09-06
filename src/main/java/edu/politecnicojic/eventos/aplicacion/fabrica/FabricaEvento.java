package edu.politecnicojic.eventos.aplicacion.fabrica;

import edu.politecnicojic.eventos.dominio.modelo.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.stereotype.Component;

@Component
public class FabricaEvento {

    public Evento convertirDtoADominio(NuevoEventoDto eventoDto) {
        return new Evento(
                eventoDto.getTitulo(),
                eventoDto.getDescripcion(),
                eventoDto.getCategorias(),
                eventoDto.getFechaInicio(),
                eventoDto.getFechaFin()
                //eventoDto.getLugar()
        );
    }

    public Comentario crearComentario(ComentarioDto comentarioDto) {
        return new Comentario(
                comentarioDto.getMensaje(),
                "ejemplo" // TODO: agregar logica de usuario
        );
    }
}
