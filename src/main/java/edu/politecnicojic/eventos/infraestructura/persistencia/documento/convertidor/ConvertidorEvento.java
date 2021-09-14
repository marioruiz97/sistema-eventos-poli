package edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor;

import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoEvento;

public final class ConvertidorEvento {

	private ConvertidorEvento() {
	}

	public static Evento convertirDocumentoADominio(DocumentoEvento documento) {
		return new Evento(documento.getIdEvento(), 
				documento.getInformacionEvento(), 
				documento.getAsistentes(),
				documento.getFacilitadores(), 
				documento.getConferencistas(), 
				documento.getOrganizadores(),
				documento.getComentarios());
	}

	public static DocumentoEvento convertirDominioADocumento(Evento evento) {
		return new DocumentoEvento(evento.getIdEvento(), 
				evento.getInformacionEvento(), 
				evento.getAsistentes(),
				evento.getFacilitadores(), 
				evento.getConferencistas(), 
				evento.getOrganizadores(),
				evento.getComentarios());
	}
}
