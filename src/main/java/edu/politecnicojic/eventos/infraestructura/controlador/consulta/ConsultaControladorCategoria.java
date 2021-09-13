package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorCategoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constantes.API_PATH + "categorias")
public class ConsultaControladorCategoria {


    private final ManejadorCategoria manejadorCategoria;

    @Autowired
    public ConsultaControladorCategoria(ManejadorCategoria manejadorCategoria) {
        this.manejadorCategoria = manejadorCategoria;
    }

    @GetMapping
    public List<Categoria> buscarDisponibles() {
        return manejadorCategoria.buscarCategoriasDisponibles();
    }
}
