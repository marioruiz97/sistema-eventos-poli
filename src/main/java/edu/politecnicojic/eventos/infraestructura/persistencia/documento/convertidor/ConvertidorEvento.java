package edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor;

import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Asistente;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Conferencista;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoEvento;

public final class ConvertidorEvento {

	private ConvertidorEvento() {
	}

	public static Evento convertirDocumentoADominio(DocumentoEvento documento) {
		final List<Asistente> asistentes = documento.getAsistentes();
		final List<Facilitador> facilitadores = documento.getFacilitadores();
		final List<Conferencista> conferencistas = documento.getConferencistas();
		if (asistentes != null)
			asistentes.forEach(Asistente::limpiarContrasena);
		if (facilitadores != null)
			facilitadores.forEach(Facilitador::limpiarContrasena);
		if (conferencistas != null)
			conferencistas.forEach(Conferencista::limpiarContrasena);

		return new Evento(
				documento.getId(), 
				documento.getInformacionEvento(), 
				asistentes, 
				facilitadores,
				conferencistas, 
				documento.getOrganizadores(), 
				documento.getComentarios());
	}

	public static DocumentoEvento convertirDominioADocumento(Evento evento) {
		return new DocumentoEvento(
				evento.getIdEvento(), 
				evento.getInformacionEvento(), 
				evento.getAsistentes(),
				evento.getFacilitadores(),
				evento.getConferencistas(), 
				evento.getOrganizadores(),
				evento.getComentarios());
	}
}
