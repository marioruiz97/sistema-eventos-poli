package edu.politecnicojic.eventos.aplicacion.manejador.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.servicio.ServicioGestionEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;

@Service
public class ManejadorEdicionEvento {

	private final FabricaEvento fabricaEvento;
	private final ServicioGestionEvento servicioGestionEvento;

	@Autowired
	public ManejadorEdicionEvento(FabricaEvento fabricaEvento, ServicioGestionEvento servicioGestionEvento) {
		this.fabricaEvento = fabricaEvento;
		this.servicioGestionEvento = servicioGestionEvento;
	}

	public void agregarComentario(String idEvento, ComentarioDto comentarioDto) {
		Comentario comentario = fabricaEvento.crearComentario(comentarioDto);
		servicioGestionEvento.agregarComentario(idEvento, comentario);
	}
}
