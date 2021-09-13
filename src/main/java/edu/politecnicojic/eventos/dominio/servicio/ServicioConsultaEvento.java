package edu.politecnicojic.eventos.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;

@Service
public class ServicioConsultaEvento {

	private static final String EVENTO_NO_ENCONTRADO = "El evento que buscas no se ha encontrado";

	private final RepositorioEvento repositorioEvento;

	@Autowired
	public ServicioConsultaEvento(RepositorioEvento repositorioEvento) {
		this.repositorioEvento = repositorioEvento;
	}

	public List<Evento> buscarPorCategorias(List<Categoria> categorias) {
		return repositorioEvento.buscarPorCategorias(categorias);
	}

	public List<Evento> buscarTodos() {
		return repositorioEvento.buscarTodos();
	}

	public Evento buscarPorId(String idEvento) {
		return repositorioEvento.buscarPorId(idEvento)
				.orElseThrow(() -> new ExcepcionElementoNoEncontrado(EVENTO_NO_ENCONTRADO));
	}
}
