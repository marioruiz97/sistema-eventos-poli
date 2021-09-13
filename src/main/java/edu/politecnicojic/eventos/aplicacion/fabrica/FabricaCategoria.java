package edu.politecnicojic.eventos.aplicacion.fabrica;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import org.springframework.stereotype.Component;

@Component
public class FabricaCategoria {

    public Categoria crearCategoria(String nombre) {
        return new Categoria(nombre);
    }
}
