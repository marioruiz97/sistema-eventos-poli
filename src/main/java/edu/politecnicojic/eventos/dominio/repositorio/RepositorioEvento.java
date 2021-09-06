package edu.politecnicojic.eventos.dominio.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Evento;

import java.util.List;
import java.util.Optional;

public interface RepositorioEvento {

    Evento crear(Evento evento);

    List<Evento> buscar();

    List<Evento> buscarPorCategorias(List<String> categorias);

    Optional<Evento> buscarPorId(String idEvento);

    void guardarEvento(Evento evento);
}
