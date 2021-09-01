package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Pais;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPais extends MongoRepository<Pais, String> {
}
