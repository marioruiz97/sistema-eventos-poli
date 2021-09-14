package edu.politecnicojic.eventos.dominio.modelo.usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Facilitador extends Usuario {

	public Facilitador(Usuario usuario) {
		super(usuario.getIdentificacion(), 
				usuario.getNombres(), 
				usuario.getApellidos(), 
				usuario.getEmail(),
				usuario.getTipoRelacion(), 
				usuario.getNombreUsuario(), 
				usuario.getContrasena());
	}
}
