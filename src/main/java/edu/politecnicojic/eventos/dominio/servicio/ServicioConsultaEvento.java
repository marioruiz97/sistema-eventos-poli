package edu.politecnicojic.eventos.dominio.servicio;

import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioConsultaEvento {

    private final RepositorioEvento repositorioEvento;

    @Autowired
    public ServicioConsultaEvento(RepositorioEvento repositorioEvento) {
        this.repositorioEvento = repositorioEvento;
    }

    public List<Evento> buscarPorCategorias(List<String> categoria) {
        return repositorioEvento.buscarPorCategorias(categoria);
    }

    public List<Evento> buscar() {
        return repositorioEvento.buscar();
    }
}
