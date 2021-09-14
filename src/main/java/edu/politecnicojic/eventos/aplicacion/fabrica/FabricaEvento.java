package edu.politecnicojic.eventos.aplicacion.fabrica;

import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.evento.InformacionEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FabricaEvento {

	public Evento convertirNuevoDtoADominio(NuevoEventoDto eventoDto, Lugar lugar, List<Facilitador> facilitadores, List<Organizador> organizadores) {
		InformacionEvento informacionEvento = new InformacionEvento(
				eventoDto.getTitulo(), 
				eventoDto.getDescripcion(),
				eventoDto.getCategorias(), 
				eventoDto.getFecha(), 
				lugar);
		
		return new Evento(eventoDto.getIdEvento(), informacionEvento, facilitadores, organizadores);
	}

	public Comentario crearComentario(ComentarioDto comentarioDto) {
		return new Comentario(comentarioDto.getMensaje(), comentarioDto.getUsuario());
	}
}
