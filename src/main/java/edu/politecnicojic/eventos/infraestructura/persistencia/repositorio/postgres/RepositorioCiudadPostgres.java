package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.postgres;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioCiudad;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor.ConvertidorLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadCiudad;

@Repository
public interface RepositorioCiudadPostgres extends JpaRepository<EntidadCiudad, Integer>, RepositorioCiudad {

	@Override
	default Optional<Ciudad> buscarPorCodigo(Integer codigo) {
		EntidadCiudad entidad = findById(codigo).orElse(null);
		if (entidad != null)
			return Optional.of(ConvertidorLugar.convertirEntidadCiudadADominio(entidad));
		else
			return Optional.empty();
	}

}
