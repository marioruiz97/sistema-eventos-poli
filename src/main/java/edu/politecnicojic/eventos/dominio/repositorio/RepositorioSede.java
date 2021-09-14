package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.Optional;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;

public interface RepositorioSede {

	Optional<Sede> buscarPorCodigo(Integer sede);

}
