package edu.politecnicojic.eventos.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;

public interface RepositorioLugar {

	Lugar crear(Lugar lugar);

	List<Lugar> buscarTodos();

	Optional<Lugar> buscarPorNombreYDireccion(String nombre, String direccion);

}
