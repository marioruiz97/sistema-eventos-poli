package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.postgres;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	default List<Programa> buscarTodos() {
		List<EntidadPrograma> programas = findAll();
		return !programas.isEmpty() ? programas.stream()
				.map(entidad -> new Programa(entidad.getCodigo(), entidad.getNombre(), entidad.getArea().getCodigo()))
				.collect(Collectors.toList()) : new ArrayList<>();
	}

}
