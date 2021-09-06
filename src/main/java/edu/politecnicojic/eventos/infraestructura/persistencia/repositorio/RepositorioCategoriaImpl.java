package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioCategoriaImpl implements RepositorioCategoria {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public RepositorioCategoriaImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Categoria> buscarCategoriasDisponibles() {
        return mongoTemplate.query(Evento.class).distinct("categorias").as(Categoria.class).all();
    }
}
