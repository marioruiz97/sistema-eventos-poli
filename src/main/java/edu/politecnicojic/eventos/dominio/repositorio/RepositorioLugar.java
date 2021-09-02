package edu.politecnicojic.eventos.dominio.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.Lugar;

import java.util.Optional;

public interface RepositorioLugar {

    Optional<Lugar> buscarPorNombreYDireccion(String nombre, String direccion);
}
