package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.postgres;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioSede;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor.ConvertidorLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadSede;

@Repository
public interface RepositorioSedePostgres extends JpaRepository<EntidadSede, Integer>, RepositorioSede {

	@Override
	default Optional<Sede> buscarPorCodigo(Integer codigo) {
		EntidadSede entidad = findById(codigo).orElse(null);
		if (entidad != null)
			return Optional.of(ConvertidorLugar.convertirEntidadSedeADominio(entidad));
		else
			return Optional.empty();
	}
}
