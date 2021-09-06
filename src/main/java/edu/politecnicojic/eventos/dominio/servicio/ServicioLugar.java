package edu.politecnicojic.eventos.dominio.servicio;

import edu.politecnicojic.eventos.dominio.modelo.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;
import org.springframework.stereotype.Service;

@Service
public class ServicioLugar {

    private RepositorioLugar repositorioLugar;

    // @Autowired TODO: cuando se cree el repo agregar constructor, volver final la variable y descomentar autowired

    public Lugar buscar(Lugar lugar) {
        return repositorioLugar.buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion()).orElse(null);
    }
}
