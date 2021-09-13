package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioEventoMongo extends MongoRepository<Evento, String>, RepositorioEvento {

    /**
     * Métodos de búsqueda utilizando JPQL
     */
    //@Transactional(readOnly = true)
    //List<Evento> findEventosByCategoriasIn(List<Categoria> categorias);

    @Transactional(readOnly = true)
    Optional<Evento> findEventoById(String id);

    /**
     * Métodos implementados desde la interfaz RepositorioEvento
     */
    @Override
    default Evento crear(Evento evento) {
        return insert(evento);
    }

    @Override
    default List<Evento> buscarTodos() {
        return findAll();
    }

    //@Override
    //default List<Evento> buscarPorCategorias(List<Categoria> listadoCategorias) {
    //    return findEventosByCategoriasIn(listadoCategorias);
    //}

    @Override
    default Optional<Evento> buscarPorId(String idEvento) {
        return findEventoById(idEvento);
    }

    @Override
    default void actualizarEvento(Evento evento) {
        save(evento);
    }
}
