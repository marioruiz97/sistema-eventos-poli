package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.postgres;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.politecnicojic.eventos.dominio.modelo.evento.Facultad;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioOrganizador;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadFacultad;

@Repository
public interface RepositorioFacultadPostgres
		extends JpaRepository<EntidadFacultad, Integer>, RepositorioOrganizador<Facultad> {

	@Override
	default Optional<Facultad> buscar(Integer codigo) {
		EntidadFacultad entidad = findById(codigo).orElse(null);
		if (entidad != null)
			return Optional
					.of(new Facultad(codigo, entidad.getNombre(), entidad.getUbicacion(), entidad.getNumeroTelefono()));
		else
			return Optional.empty();
	}

	@Override
	default List<Facultad> buscarTodos() {
		List<EntidadFacultad> facultades = findAll();
		return !facultades.isEmpty()
				? facultades.stream().map(entidad -> new Facultad(entidad.getCodigo(), entidad.getNombre(),
						entidad.getUbicacion(), entidad.getNumeroTelefono())).collect(Collectors.toList())
				: new ArrayList<>();
	}

}
