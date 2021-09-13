package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import edu.politecnicojic.eventos.dominio.modeloaborrar.Pais;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioPais;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioPaisMongo extends MongoRepository<Pais, String>, RepositorioPais {

    @Transactional(readOnly = true)
    Optional<Pais> findByNombre(String nombre);

    @Override
    default Pais crearOEditar(Pais pais) {
        return save(pais);
    }

    @Override
    default List<Pais> obtenerTodos() {
        return findAll();
    }

    @Override
    default Pais obtenerPorNombre(String nombre) {
        return findByNombre(nombre).orElse(null);
    }
}
