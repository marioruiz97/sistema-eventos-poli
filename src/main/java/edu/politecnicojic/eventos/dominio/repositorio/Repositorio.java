package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.Optional;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;

public interface Repositorio {

	Optional<Usuario> buscarPorIdentificacion(String identificacion);

}
