package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.Optional;

public interface RepositorioOrganizador<T> {

	Optional<T> buscar(Integer codigo);

}
