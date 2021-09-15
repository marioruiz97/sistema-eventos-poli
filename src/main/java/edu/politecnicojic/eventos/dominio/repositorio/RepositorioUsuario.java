package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;

public interface RepositorioUsuario extends Repositorio {

	Usuario crear(Usuario usuario);

	List<Usuario> buscarTodos();

	@Override
	Optional<Usuario> buscarPorIdentificacion(String identificacion);

	Optional<Usuario> buscarPorCorreo(String correo);

}
