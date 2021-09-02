package edu.politecnicojic.eventos.aplicacion.manejador;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaEvento;
import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.dominio.servicio.ServicioCreacionEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManejadorEvento {

    FabricaEvento fabricaEvento;

    ServicioCreacionEvento servicioCreacionEvento;

    @Autowired
    public ManejadorEvento(FabricaEvento fabricaEvento, ServicioCreacionEvento servicioCreacionEvento) {
        this.fabricaEvento = fabricaEvento;
        this.servicioCreacionEvento = servicioCreacionEvento;
    }

    public Evento crear(NuevoEventoDto eventoDto) {
        Evento evento = fabricaEvento.convertirDtoADominio(eventoDto);
        return servicioCreacionEvento.crear(evento);
    }
}
