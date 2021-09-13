package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;

public interface RepositorioCategoria {

	List<Categoria> buscarCategoriasDisponibles();
}
