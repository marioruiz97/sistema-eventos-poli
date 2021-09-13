package edu.politecnicojic.eventos.dominio.databuilder;

import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;

public class UsuarioTestDataBuilder {

	private static final String IDENTIFICACION = "1017251545";
	private static final String NOMBRES = "Mario Andres";
	private static final String APELLIDOS = "Ruiz";
	private static final String EMAIL = "marioruiz@gmail.com";
	private static final String NOMBREUSUARIO = "usuario";
	private static final String CONTRASENA = "clave123";
	private static final TipoRelacion RELACION = TipoRelacion.SIN_RELACION;

	private String identificacion;
	private String nombres;
	private String apellidos;
	private String email;
	private TipoRelacion tipoRelacion;
	private String nombreUsuario;
	private String contrasena;

	public UsuarioTestDataBuilder() {
		this.identificacion = IDENTIFICACION;
		this.nombres = NOMBRES;
		this.apellidos = APELLIDOS;
		this.email = EMAIL;
		this.tipoRelacion = RELACION;
		this.nombreUsuario = NOMBREUSUARIO;
		this.contrasena = CONTRASENA;
	}

	public UsuarioTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public UsuarioTestDataBuilder conNombres(String nombres) {
		this.nombres = nombres;
		return this;
	}

	public UsuarioTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	public UsuarioTestDataBuilder conTipoRelacion(TipoRelacion tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
		return this;
	}

	public UsuarioTestDataBuilder conContrasena(String contrasena) {
		this.contrasena = contrasena;
		return this;
	}

	public Usuario build() {
		return new Usuario(identificacion, nombres, apellidos, email, tipoRelacion, nombreUsuario, contrasena);
	}

}
