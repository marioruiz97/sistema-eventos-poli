package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioCategoria;
import edu.politecnicojic.eventos.infraestructura.persistencia.documento.DocumentoEvento;

@Repository
public class RepositorioCategoriaImpl implements RepositorioCategoria {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public RepositorioCategoriaImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Categoria> buscarCategoriasDisponibles() {
        return mongoTemplate.query(DocumentoEvento.class).distinct("categorias").as(Categoria.class).all();
    }
}
