package edu.politecnicojic.eventos.dominio.servicio;

import edu.politecnicojic.eventos.dominio.modelo.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;
import org.springframework.stereotype.Service;

@Service
public class ServicioLugar {

    private RepositorioLugar repositorioLugar;

    public Lugar buscar(Lugar lugar) {
        return repositorioLugar.buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion()).orElse(null);
    }
}
