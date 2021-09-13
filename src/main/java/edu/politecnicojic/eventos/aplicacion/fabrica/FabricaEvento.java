package edu.politecnicojic.eventos.aplicacion.fabrica;

import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.evento.InformacionEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.stereotype.Component;

@Component
public class FabricaEvento {

    public Evento convertirNuevoDtoADominio(NuevoEventoDto eventoDto) {
        InformacionEvento informacionEvento = new InformacionEvento(
                eventoDto.getTitulo(),
                eventoDto.getDescripcion(),
                eventoDto.getCategorias(),
                eventoDto.getFecha(),
                eventoDto.getLugar()
        );
        return new Evento(
                eventoDto.getIdEvento(),
                informacionEvento,
                eventoDto.getFacilitadores(),
                eventoDto.getOrganizadores()
        );
    }

    public Comentario crearComentario(ComentarioDto comentarioDto) {
        return new Comentario(
                comentarioDto.getMensaje(),
                comentarioDto.getUsuario()
        );
    }
}
