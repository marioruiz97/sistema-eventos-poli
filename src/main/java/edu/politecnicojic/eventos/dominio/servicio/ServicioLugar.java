package edu.politecnicojic.eventos.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;

@Service
public class ServicioLugar {

	private static final String LUGAR_NO_ENCONTRADO = "No se encontró el lugar al que se asoció el evento, verifica la información";

	private final RepositorioLugar repositorioLugar;

	@Autowired
	public ServicioLugar(RepositorioLugar repositorioLugar) {
		this.repositorioLugar = repositorioLugar;
	}

	public List<Lugar> buscarTodos() {
		return repositorioLugar.buscarTodos();
	}

	public Lugar crear(Lugar lugar) {
		lugar.validarCampos();
		return repositorioLugar.crear(lugar);
	}

	public Lugar buscarPorNombreYDireccion(String nombre, String direccion) {
		return repositorioLugar.buscarPorNombreYDireccion(nombre, direccion)
				.orElseThrow(() -> new ExcepcionElementoNoEncontrado(LUGAR_NO_ENCONTRADO));
	}

}
