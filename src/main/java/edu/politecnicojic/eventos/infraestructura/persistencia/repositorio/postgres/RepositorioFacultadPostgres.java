package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.postgres;

import java.util.Optional;

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

}
