package edu.politecnicojic.eventos.dominio.modelo.usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Conferencista extends Usuario {

	public Conferencista(Usuario usuario) {
		super(usuario.getIdentificacion(), 
				usuario.getNombres(), 
				usuario.getApellidos(), 
				usuario.getEmail(),
				usuario.getTipoRelacion(), 
				usuario.getNombreUsuario(), 
				usuario.getContrasena());
	}
}
