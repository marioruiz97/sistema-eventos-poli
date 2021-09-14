package edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoUsuario;

public final class ConvertidorUsuario {

	private ConvertidorUsuario() {
	}

	public static Usuario convertirDocumentoADominio(DocumentoUsuario documento) {
		return new Usuario(
				documento.getIdentificacion(), 
				documento.getNombres(), 
				documento.getApellidos(),
				documento.getEmail(), 
				documento.getTipoRelacion(), 
				documento.getNombreUsuario(),
				documento.getContrasena());
	}

	public static DocumentoUsuario convertirDominioADocumento(Usuario usuario) {
		return new DocumentoUsuario(
				usuario.getIdentificacion(), 
				usuario.getNombres(), 
				usuario.getApellidos(),
				usuario.getEmail(), 
				usuario.getTipoRelacion(), 
				usuario.getNombreUsuario(), 
				usuario.getContrasena());
	}

}
