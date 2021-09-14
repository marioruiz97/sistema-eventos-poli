package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.mongo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioUsuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoUsuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor.ConvertidorUsuario;

@Repository
public interface RepositorioUsuarioMongo extends MongoRepository<DocumentoUsuario, String>, RepositorioUsuario {

	@Override
	default Usuario crear(Usuario usuario) {
		return insert(ConvertidorUsuario.convertirDominioADocumento(usuario));
	}

	@Override
	default List<Usuario> buscarTodos() {
		return findAll().stream().map(ConvertidorUsuario::convertirDocumentoADominio).collect(Collectors.toList());
	}

	@Override
	default Optional<Usuario> buscarPorIdentificacion(String identificacion) {
		DocumentoUsuario usuario = findById(identificacion).orElse(null);
		if (usuario != null)
			return Optional.of(ConvertidorUsuario.convertirDocumentoADominio(usuario));
		else
			return Optional.empty();
	}

}
