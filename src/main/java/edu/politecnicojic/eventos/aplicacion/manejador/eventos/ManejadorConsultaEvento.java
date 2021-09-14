package edu.politecnicojic.eventos.aplicacion.manejador.eventos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaCategoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioConsultaEvento;

@Service
public class ManejadorConsultaEvento {

	private final ServicioConsultaEvento servicioConsultaEvento;
	private final FabricaCategoria fabricaCategoria;

	@Autowired
	public ManejadorConsultaEvento(ServicioConsultaEvento servicioConsultaEvento, FabricaCategoria fabricaCategoria) {
		this.servicioConsultaEvento = servicioConsultaEvento;
		this.fabricaCategoria = fabricaCategoria;
	}

	public List<Evento> buscarPorCategorias(List<String> nombresCategorias) {
		List<Categoria> categorias = nombresCategorias.stream().map(fabricaCategoria::crearCategoria)
				.collect(Collectors.toList());
		return servicioConsultaEvento.buscarPorCategorias(categorias);
	}

	public List<Evento> buscar() {
		return servicioConsultaEvento.buscarTodos();
	}

}
