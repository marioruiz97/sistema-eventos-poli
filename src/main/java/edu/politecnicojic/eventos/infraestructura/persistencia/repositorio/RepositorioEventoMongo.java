package edu.politecnicojic.eventos.infraestructura.persistencia.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioEventoMongo extends MongoRepository<Evento, String>, RepositorioEvento {

    @Override
    default Evento crear(Evento evento) {
        return insert(evento);
    }
}
