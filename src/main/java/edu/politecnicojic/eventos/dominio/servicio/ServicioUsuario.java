package edu.politecnicojic.eventos.dominio.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.repositorio.Repositorio;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioUsuario;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioUsuarioPolitecnico;

@Service
public class ServicioUsuario {

	private static final String USUARIO_NO_ENCONTRADO = "El usuario que buscas no se ha encontrado";

	private final RepositorioUsuario repositorioUsuario;
	private final RepositorioUsuarioPolitecnico repositorioUsuarioPoli;

	@Autowired
	public ServicioUsuario(RepositorioUsuario repositorioUsuario,
			RepositorioUsuarioPolitecnico repositorioUsuarioPoli) {

		this.repositorioUsuario = repositorioUsuario;
		this.repositorioUsuarioPoli = repositorioUsuarioPoli;
	}

	/**
	 * m�todos de creaci�n y gesti�n de usuarios
	 */

	public Usuario crear(Usuario usuario) {
		TipoRelacion.tipoRelacionEsValida(usuario.getTipoRelacion());
		if (usuario.esMiembroPoli()) {
			// buscar los datos en el sistema del poli
			Usuario datosUsuarioPoli = buscarMiembroPoli(usuario.getIdentificacion());
			usuario.agregarDatosSistemaPoli(datosUsuarioPoli);
		}
		usuario.validarCamposObligatorios();
		usuario.cifrarContrasena();
		return repositorioUsuario.crear(usuario);
	}

	/**
	 * m�todos de b�squeda de usuarios
	 */

	public List<Usuario> buscarTodos() {
		List<Usuario> usuariosEncontrados = repositorioUsuario.buscarTodos();
		return usuariosEncontrados.stream().map(usuario -> {
			usuario.limpiarContrasena();
			return usuario;
		}).collect(Collectors.toList());
	}

	public Usuario buscarUsuario(String identificacion) {
		return buscarUsuarioPorIdentificacion(repositorioUsuario, identificacion);
	}

	public Usuario buscarMiembroPoli(String identificacion) {
		return buscarUsuarioPorIdentificacion(repositorioUsuarioPoli, identificacion);
	}

	private Usuario buscarUsuarioPorIdentificacion(Repositorio repositorio, String identificacion) {
		return repositorio.buscarPorIdentificacion(identificacion)
				.orElseThrow(() -> new ExcepcionElementoNoEncontrado(USUARIO_NO_ENCONTRADO));
	}

}
