package edu.politecnicojic.eventos.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Asistente;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Conferencista;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoUsuarioDto;

@Component
public class FabricaUsuario {

	public Facilitador crearFacilitadorDesdeUsuario(Usuario usuario) {
		return new Facilitador(usuario);
	}

	public Asistente crearAsistenteDesdeUsuario(Usuario usuario) {
		return new Asistente(usuario);
	}

	public Conferencista crearConferencistaDesdeUsuario(Usuario usuario) {
		return new Conferencista(usuario);
	}

	public Usuario convertirDtoADominio(NuevoUsuarioDto usuarioDto) {
		return new Usuario(
				usuarioDto.getIdentificacion(), 
				usuarioDto.getNombres(), 
				usuarioDto.getApellidos(),
				usuarioDto.getEmail(), 
				usuarioDto.getTipoRelacion(), 
				usuarioDto.getNombreUsuario(),
				usuarioDto.getContrasena());
	}
}
