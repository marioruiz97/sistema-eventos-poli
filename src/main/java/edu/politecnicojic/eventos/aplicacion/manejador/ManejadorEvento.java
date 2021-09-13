package edu.politecnicojic.eventos.aplicacion.manejador;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaCategoria;
import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioConsultaEvento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioGestionEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManejadorEvento {

    private final FabricaEvento fabricaEvento;
    private final FabricaCategoria fabricaCategoria;
    private final ServicioGestionEvento servicioGestionEvento;
    private final ServicioConsultaEvento servicioConsultaEvento;

    @Autowired
    public ManejadorEvento(
            FabricaEvento fabricaEvento,
            FabricaCategoria fabricaCategoria,
            ServicioGestionEvento servicioGestionEvento,
            ServicioConsultaEvento servicioConsultaEvento) {
        this.fabricaEvento = fabricaEvento;
        this.fabricaCategoria = fabricaCategoria;
        this.servicioGestionEvento = servicioGestionEvento;
        this.servicioConsultaEvento = servicioConsultaEvento;
    }

    public Evento crear(NuevoEventoDto eventoDto) {
        Evento evento = fabricaEvento.convertirNuevoDtoADominio(eventoDto);
        return servicioGestionEvento.crear(evento);
    }

    public List<Evento> buscarPorCategorias(List<String> nombresCategorias) {
        List<Categoria> categorias = nombresCategorias.stream().map(fabricaCategoria::crearCategoria).collect(Collectors.toList());
        return servicioConsultaEvento.buscarPorCategorias(categorias);
    }

    public List<Evento> buscar() {
        return servicioConsultaEvento.buscarTodos();
    }

    public void agregarComentario(String idEvento, ComentarioDto comentarioDto) {
        Comentario comentario = fabricaEvento.crearComentario(comentarioDto);
        servicioGestionEvento.agregarComentario(idEvento, comentario);
    }
}
