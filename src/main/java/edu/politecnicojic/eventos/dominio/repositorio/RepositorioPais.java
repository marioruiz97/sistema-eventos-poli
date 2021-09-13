package edu.politecnicojic.eventos.dominio.repositorio;

import edu.politecnicojic.eventos.dominio.modeloaborrar.Pais;

import java.util.List;

public interface RepositorioPais {

    Pais crearOEditar(Pais pais);

    List<Pais> obtenerTodos();

    Pais obtenerPorNombre(String nombre);
}
