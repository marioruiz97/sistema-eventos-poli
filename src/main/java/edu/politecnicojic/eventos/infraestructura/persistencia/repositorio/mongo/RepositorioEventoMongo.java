package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.mongo;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.convertidor.ConvertidorEvento;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface RepositorioEventoMongo extends MongoRepository<DocumentoEvento, String>, RepositorioEvento {

	/**
	 * Métodos de búsqueda utilizando JPQL
	 */
	@Transactional(readOnly = true)
	List<DocumentoEvento> findEventosByCategoriasIn(List<Categoria> categorias);

	@Transactional(readOnly = true)
	Optional<DocumentoEvento> findEventoById(String idEvento);

	/**
	 * Métodos implementados desde la interfaz RepositorioEvento
	 */
	@Override
	default Evento crear(Evento evento) {
		return insert(ConvertidorEvento.convertirDominioADocumento(evento));
	}

	@Override
	default List<Evento> buscarTodos() {
		return findAll().stream().map(ConvertidorEvento::convertirDocumentoADominio).collect(Collectors.toList());
	}

	@Override
	default List<Evento> buscarPorCategorias(List<Categoria> listadoCategorias) {
		return findEventosByCategoriasIn(listadoCategorias).stream().map(ConvertidorEvento::convertirDocumentoADominio)
				.collect(Collectors.toList());
	}

	@Override
	default Optional<Evento> buscarPorId(String idEvento) {
		DocumentoEvento evento = findEventoById(idEvento).orElse(null);
		if (evento != null)
			return Optional.of(ConvertidorEvento.convertirDocumentoADominio(evento));
		else
			return Optional.empty();
	}

	@Override
	default void actualizarEvento(Evento evento) {
		save(ConvertidorEvento.convertirDominioADocumento(evento));
	}
}
