package edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoLugar;

public final class ConvertidorLugar {

	private ConvertidorLugar() {
	}

	public static Lugar convertirDocumentoADominio(DocumentoLugar documento) {
		return new Lugar(documento.getNombre(), documento.getDireccion(), documento.getCiudad(), documento.getSede());
	}

	public static DocumentoLugar convertirDominioADocumento(Lugar lugar, String idLugar) {
		return new DocumentoLugar(idLugar, lugar.getNombre(), lugar.getDireccion(), lugar.getCiudad(), lugar.getSede());
	}
}
