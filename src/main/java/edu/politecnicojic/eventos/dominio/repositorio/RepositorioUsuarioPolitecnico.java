package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.Optional;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;

public interface RepositorioUsuarioPolitecnico extends Repositorio {

	Usuario crearMiembroPoli(Usuario usuario);

	@Override
	Optional<Usuario> buscarPorIdentificacion(String identificacion);

}
