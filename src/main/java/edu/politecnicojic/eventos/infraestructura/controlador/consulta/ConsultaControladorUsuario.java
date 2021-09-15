package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorUsuario;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constantes.API_PATH + "usuarios")
public class ConsultaControladorUsuario {

	private final ManejadorUsuario manejadorUsuario;

	@Autowired
	public ConsultaControladorUsuario(ManejadorUsuario manejadorUsuario) {
		this.manejadorUsuario = manejadorUsuario;
	}

	@GetMapping
	public List<Usuario> buscarTodos() {
		return manejadorUsuario.buscarTodos();
	}
}
