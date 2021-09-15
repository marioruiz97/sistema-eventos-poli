package edu.politecnicojic.eventos.aplicacion.manejador;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaUsuario;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionInicioSesion;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.servicio.ServicioUsuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoUsuarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.SesionDto;

@Service
public class ManejadorUsuario {

	private final ServicioUsuario servicioUsuario;
	private final FabricaUsuario fabricaUsuario;

	@Autowired
	public ManejadorUsuario(ServicioUsuario servicioUsuario, FabricaUsuario fabricaUsuario) {
		this.servicioUsuario = servicioUsuario;
		this.fabricaUsuario = fabricaUsuario;
	}

	public List<Facilitador> buscarFacilitadores(List<String> idsFacilitadores) {
		return idsFacilitadores.stream().map(identificacion -> {
			Usuario usuario = servicioUsuario.buscarUsuario(identificacion);
			return fabricaUsuario.crearFacilitadorDesdeUsuario(usuario);
		}).collect(Collectors.toList());

	}

	public Usuario crear(@Valid NuevoUsuarioDto usuarioDto) {
		return servicioUsuario.crear(fabricaUsuario.convertirDtoADominio(usuarioDto));
	}

	public List<Usuario> buscarTodos() {
		return servicioUsuario.buscarTodos();
	}

	public Usuario iniciarSesion(@Valid SesionDto inicioSesion) {
		try {
			Usuario usuario = servicioUsuario.buscarUsuarioPorCorreo(inicioSesion.getUsuario());
			if (!usuario.getContrasena().equals(obtenerContrasena(inicioSesion)))
				throw new ExcepcionInicioSesion("La contraseña es incorrecta");
			return usuario;
		} catch (ExcepcionElementoNoEncontrado ex) {
			throw new ExcepcionInicioSesion("No existe el usuario en base de datos");
		}
	}

	private String obtenerContrasena(SesionDto inicioSesion) {
		return Base64.getEncoder().encodeToString(inicioSesion.getContrasena().getBytes());
	}

}
