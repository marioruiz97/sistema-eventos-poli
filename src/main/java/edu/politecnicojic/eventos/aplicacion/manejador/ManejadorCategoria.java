package edu.politecnicojic.eventos.aplicacion.manejador;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManejadorCategoria {

	private final RepositorioCategoria repositorioCategoria;

	@Autowired
	public ManejadorCategoria(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	}

	public List<Categoria> buscarCategoriasDisponibles() {
		return repositorioCategoria.buscarCategoriasDisponibles();
	}
}
