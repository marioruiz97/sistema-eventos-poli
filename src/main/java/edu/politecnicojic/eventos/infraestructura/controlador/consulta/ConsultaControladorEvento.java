package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constantes.API_PATH + "eventos")
public class ConsultaControladorEvento {

    private final ManejadorEvento manejadorEvento;

    @Autowired
    public ConsultaControladorEvento(ManejadorEvento manejadorEvento) {
        this.manejadorEvento = manejadorEvento;
    }

    @GetMapping
    public List<Evento> buscarEventos(@RequestParam(name = "categoria", required = false) List<String> categorias) {
        return categorias != null && !categorias.isEmpty() ? manejadorEvento.buscarPorCategorias(categorias)
                : manejadorEvento.buscar();
    }
}
