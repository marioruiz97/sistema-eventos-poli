package edu.politecnicojic.eventos.aplicacion.manejador.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.servicio.ServicioGestionEvento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioUsuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;

@Service
public class ManejadorEdicionEvento {

	private final FabricaEvento fabricaEvento;
	private final ServicioGestionEvento servicioGestionEvento;
	private final ServicioUsuario servicioUsuario;

	@Autowired
	public ManejadorEdicionEvento(FabricaEvento fabricaEvento, ServicioGestionEvento servicioGestionEvento,
			ServicioUsuario servicioUsuario) {
		this.fabricaEvento = fabricaEvento;
		this.servicioGestionEvento = servicioGestionEvento;
		this.servicioUsuario = servicioUsuario;
	}

	public void agregarComentario(String idEvento, ComentarioDto comentarioDto) {
		Usuario usuario = servicioUsuario.buscarUsuario(comentarioDto.getUsuario());
		usuario.limpiarContrasena();
		Comentario comentario = fabricaEvento.crearComentario(comentarioDto, usuario);
		servicioGestionEvento.agregarComentario(idEvento, comentario);
	}
}
