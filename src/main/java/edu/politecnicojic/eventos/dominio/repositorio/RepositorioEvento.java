package edu.politecnicojic.eventos.dominio.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Evento;

public interface RepositorioEvento {

    Evento crear(Evento evento);
}
