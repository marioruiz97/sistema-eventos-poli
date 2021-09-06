package edu.politecnicojic.eventos.dominio.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Categoria;

import java.util.List;

public interface RepositorioCategoria {
    List<Categoria> buscarCategoriasDisponibles();
}
