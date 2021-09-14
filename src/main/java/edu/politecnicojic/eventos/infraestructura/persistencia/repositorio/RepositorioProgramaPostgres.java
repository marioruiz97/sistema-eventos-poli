package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.politecnicojic.eventos.dominio.modelo.evento.Programa;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioOrganizador;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadPrograma;

@Repository
public interface RepositorioProgramaPostgres
		extends JpaRepository<EntidadPrograma, Integer>, RepositorioOrganizador<Programa> {

	@Override
	default Optional<Programa> buscar(Integer codigo) {
		EntidadPrograma entidad = findById(codigo).orElse(null);
		if (entidad != null)
			return Optional.of(new Programa(codigo, entidad.getNombre(), entidad.getArea().getCodigo()));
		else
			return Optional.empty();
	}

}
