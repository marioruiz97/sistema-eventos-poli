package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.Optional;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;

public interface RepositorioCiudad {

	Optional<Ciudad> buscarPorCodigo(Integer codigo);

}
