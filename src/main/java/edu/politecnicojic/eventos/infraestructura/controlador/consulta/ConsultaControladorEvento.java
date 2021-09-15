package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorOrganizador;
import edu.politecnicojic.eventos.aplicacion.manejador.eventos.ManejadorConsultaEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constantes.API_PATH + "eventos")
public class ConsultaControladorEvento {

	private final ManejadorConsultaEvento manejadorEvento;
	private final ManejadorOrganizador manejadorOrganizador;

	@Autowired
	public ConsultaControladorEvento(ManejadorConsultaEvento manejadorEvento,
			ManejadorOrganizador manejadorOrganizador) {
		this.manejadorEvento = manejadorEvento;
		this.manejadorOrganizador = manejadorOrganizador;
	}

	@GetMapping
	public List<Evento> buscarEventos(@RequestParam(name = "categoria", required = false) List<String> categorias) {
		return categorias != null && !categorias.isEmpty() ? manejadorEvento.buscarPorCategorias(categorias)
				: manejadorEvento.buscar();
	}

	@GetMapping("/{idEvento}")
	public Evento buscarPorID(@PathVariable("idEvento") @NotNull String idEvento) {
		return manejadorEvento.buscarPorId(idEvento);
	}

	@GetMapping("/organizadores")
	public List<Organizador> buscarOrganizadores() {
		return manejadorOrganizador.buscarOrganizadores();
	}
}
