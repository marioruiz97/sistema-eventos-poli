package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.politecnicojic.eventos.aplicacion.manejador.eventos.ManejadorConsultaEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;

@RestController
@RequestMapping(Constantes.API_PATH + "eventos")
public class ConsultaControladorEvento {

	private final ManejadorConsultaEvento manejadorEvento;

	@Autowired
	public ConsultaControladorEvento(ManejadorConsultaEvento manejadorEvento) {
		this.manejadorEvento = manejadorEvento;
	}

	@GetMapping
	public List<Evento> buscarEventos(@RequestParam(name = "categoria", required = false) List<String> categorias) {
		return categorias != null && !categorias.isEmpty() ? manejadorEvento.buscarPorCategorias(categorias)
				: manejadorEvento.buscar();
	}
}
