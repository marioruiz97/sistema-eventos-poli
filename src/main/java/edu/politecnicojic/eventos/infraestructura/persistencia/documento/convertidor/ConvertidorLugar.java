package edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadCiudad;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadSede;

public final class ConvertidorLugar {

	private ConvertidorLugar() {
	}

	public static Lugar convertirDocumentoADominio(DocumentoLugar documento) {
		return new Lugar(documento.getNombre(), documento.getDireccion(), documento.getCiudad(), documento.getSede());
	}

	public static DocumentoLugar convertirDominioADocumento(Lugar lugar, String idLugar) {
		return new DocumentoLugar(idLugar, lugar.getNombre(), lugar.getDireccion(), lugar.getCiudad(), lugar.getSede());
	}

	public static Ciudad convertirEntidadCiudadADominio(EntidadCiudad entidad) {
		return new Ciudad(entidad.getCodigo(), entidad.getNombre(), entidad.getEntidadDepartamento().getNombre());
	}

	public static Sede convertirEntidadSedeADominio(EntidadSede entidad) {
		return new Sede(entidad.getCodigo(), entidad.getNombre(), convertirEntidadCiudadADominio(entidad.getCiudad()));
	}
}
