package edu.politecnicojic.eventos.aplicacion.manejador;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaUsuario;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.servicio.ServicioUsuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoUsuarioDto;

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

}
