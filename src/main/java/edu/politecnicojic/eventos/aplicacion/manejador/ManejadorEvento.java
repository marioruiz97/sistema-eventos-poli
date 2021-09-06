package edu.politecnicojic.eventos.aplicacion.manejador;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaEvento;
import edu.politecnicojic.eventos.dominio.modelo.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioConsultaEvento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioCreacionEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.ComentarioDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManejadorEvento {

    private final FabricaEvento fabricaEvento;
    private final ServicioCreacionEvento servicioCreacionEvento;
    private final ServicioConsultaEvento servicioConsultaEvento;

    @Autowired
    public ManejadorEvento(FabricaEvento fabricaEvento, ServicioCreacionEvento servicioCreacionEvento, ServicioConsultaEvento servicioConsultaEvento) {
        this.fabricaEvento = fabricaEvento;
        this.servicioCreacionEvento = servicioCreacionEvento;
        this.servicioConsultaEvento = servicioConsultaEvento;
    }

    public Evento crear(NuevoEventoDto eventoDto) {
        Evento evento = fabricaEvento.convertirDtoADominio(eventoDto);
        return servicioCreacionEvento.crear(evento);
    }

    public List<Evento> buscarPorCategorias(List<String> categorias) {
        return servicioConsultaEvento.buscarPorCategorias(categorias);
    }

    public List<Evento> buscar() {
        return servicioConsultaEvento.buscar();
    }

    public void agregarComentario(String idEvento, ComentarioDto comentarioDto) {
        Comentario comentario = fabricaEvento.crearComentario(comentarioDto);
        servicioCreacionEvento.agregarComentario(idEvento, comentario);
    }
}
