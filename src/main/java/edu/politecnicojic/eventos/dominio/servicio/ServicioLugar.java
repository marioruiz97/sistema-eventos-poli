package edu.politecnicojic.eventos.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioCiudad;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioSede;

@Service
public class ServicioLugar {

	private static final String NO_ENCONTRADO = "No se ha encontrado la %s con código %s";
	private static final String LUGAR_NO_ENCONTRADO = "No se encontró el lugar al que se asoció el evento, verifica la información";

	private final RepositorioLugar repositorioLugar;
	private final RepositorioCiudad repositorioCiudad;
	private final RepositorioSede repositorioSede;

	@Autowired
	public ServicioLugar(RepositorioLugar repositorioLugar, RepositorioCiudad repositorioCiudad,
			RepositorioSede repositorioSede) {
		this.repositorioLugar = repositorioLugar;
		this.repositorioCiudad = repositorioCiudad;
		this.repositorioSede = repositorioSede;
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

	public Ciudad buscarCiudad(Integer codigoCiudad) {
		return repositorioCiudad.buscarPorCodigo(codigoCiudad).orElseThrow(
				() -> new ExcepcionElementoNoEncontrado(String.format(NO_ENCONTRADO, "Ciudad", codigoCiudad)));
	}

	public Sede buscarSede(Integer codigoSede) {
		return repositorioSede.buscarPorCodigo(codigoSede)
				.orElseThrow(() -> new ExcepcionElementoNoEncontrado(String.format(NO_ENCONTRADO, "Sede", codigoSede)));
	}

}
