package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.mongo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor.ConvertidorLugar;

@Repository
public interface RepositorioLugarMongo extends MongoRepository<DocumentoLugar, String>, RepositorioLugar {

	@Transactional(readOnly = true)
	Optional<DocumentoLugar> findByNombreAndDireccion(String nombre, String direccion);

	@Override
	default Lugar crear(Lugar lugar) {
		return insert(ConvertidorLugar.convertirDominioADocumento(lugar, null));
	}

	@Override
	default List<Lugar> buscarTodos() {
		return findAll().stream().map(ConvertidorLugar::convertirDocumentoADominio).collect(Collectors.toList());
	}

	@Override
	default Optional<Lugar> buscarPorNombreYDireccion(String nombre, String direccion) {
		DocumentoLugar lugar = findByNombreAndDireccion(nombre, direccion).orElse(null);
		if (lugar != null)
			return Optional.of(ConvertidorLugar.convertirDocumentoADominio(lugar));
		else
			return Optional.empty();
	}

}
