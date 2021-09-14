package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioUsuarioPolitecnico;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadEmpleado;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.convertidor.ConvertidorEmpleado;

public interface RepositorioUsuarioPostgres
		extends JpaRepository<EntidadEmpleado, String>, RepositorioUsuarioPolitecnico {

	@Override
	default boolean existeEnSistemaRelacional(String identificacion) {
		return existsById(identificacion);
	}

	@Override
	default Optional<Usuario> buscarPorIdentificacion(String identificacion) {
		EntidadEmpleado usuarioPoli = findById(identificacion).orElse(null);
		if (usuarioPoli != null)
			return Optional.of(ConvertidorEmpleado.convertirEntidadADominio(usuarioPoli, null, null, null));
		else
			return Optional.empty();
	}

}
