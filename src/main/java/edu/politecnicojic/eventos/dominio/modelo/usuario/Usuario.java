package edu.politecnicojic.eventos.dominio.modelo.usuario;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	private String identificacion;

	private String nombres;

	private String apellidos;

	private String email;

	private TipoRelacion tipoRelacion;

	private String nombreUsuario;

	private String contrasena;

	public void limpiarContrasena() {
		this.contrasena = "";
	}

	public void agregarDatosSistemaPoli(Usuario usuario) {
		this.nombres = usuario.getNombres();
		this.apellidos = usuario.getApellidos();
		this.email = usuario.getEmail();
	}

	public void validarCamposObligatorios() {
		List<String> campos = new ArrayList<>();
		campos.add(identificacion);
		campos.add(nombres);
		campos.add(apellidos);
		campos.add(email);
		campos.add(nombreUsuario);
		campos.add(contrasena);
		ValidadorArgumento.validarCampos(campos);
		ValidadorArgumento.validarTipoRelacion(tipoRelacion);
	}

	public boolean esMiembroPoli() {
		return tipoRelacion != null
				&& (tipoRelacion.equals(TipoRelacion.ADMINISTRATIVO) || tipoRelacion.equals(TipoRelacion.PROFESOR));
	}

	public void cifrarContrasena() {
		byte[] clave = this.contrasena.getBytes();
		this.contrasena = Base64.getEncoder().encodeToString(clave);
	}

}
