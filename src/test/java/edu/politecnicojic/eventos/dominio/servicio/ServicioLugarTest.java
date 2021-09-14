package edu.politecnicojic.eventos.dominio.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.politecnicojic.eventos.dominio.databuilder.LugarTestDataBuilder;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;

class ServicioLugarTest {

	private static final String LUGAR_NO_ENCONTRADO = "No se encontró el lugar al que se asoció el evento, verifica la información";

	private static ServicioLugar servicioLugar;
	private static RepositorioLugar repositorioLugar;

	@BeforeAll
	static void setUp() {
		repositorioLugar = mock(RepositorioLugar.class);
		servicioLugar = new ServicioLugar(repositorioLugar);
	}

	@Test
	void buscarTodosFuncionaDevolviendoCero() {
		// arrange
		List<Lugar> listaEsperada = new ArrayList<>();
		Mockito.when(repositorioLugar.buscarTodos()).thenReturn(listaEsperada);

		// act
		List<Lugar> listaObtenida = servicioLugar.buscarTodos();

		// assert
		assertThat(listaObtenida.isEmpty()).isTrue();

	}

	@Test
	void buscarTodosFunciona() {
		// arrange
		List<Lugar> lugares = new ArrayList<>();
		Mockito.when(repositorioLugar.buscarTodos()).thenReturn(lugares);

		// act - assert
		assertThatNoException().isThrownBy(() -> servicioLugar.buscarTodos());

	}

	@Test
	void buscarPorNombreYDireccionFunciona() {
		// arrange
		String nombre = "Prueba";
		String direccion = "calle falsa 123";
		Lugar lugar = new LugarTestDataBuilder().conNombre(nombre).conDireccion(direccion).build();
		Mockito.when(repositorioLugar.buscarPorNombreYDireccion(nombre, direccion)).thenReturn(Optional.of(lugar));

		// act - assert
		assertThatNoException().isThrownBy(() -> servicioLugar.buscarPorNombreYDireccion(nombre, direccion));
	}

	@Test
	void buscarPorNombreYDireccionFalla() {
		// arrange
		String nombre = "Prueba";
		String direccion = "calle falsa 123";
		Mockito.when(repositorioLugar.buscarPorNombreYDireccion(nombre, direccion)).thenReturn(Optional.empty());

		// act - assert
		ExcepcionElementoNoEncontrado excepcion = Assertions.assertThrows(ExcepcionElementoNoEncontrado.class,
				() -> servicioLugar.buscarPorNombreYDireccion(nombre, direccion));
		assertThat(excepcion.getMessage()).isEqualTo(LUGAR_NO_ENCONTRADO);
	}

	@Test
	void crearLugarFunciona() {
		Lugar lugar = new LugarTestDataBuilder().build();
		Mockito.when(repositorioLugar.crear(lugar)).thenReturn(lugar);

		// act - assert
		assertThatNoException().isThrownBy(() -> servicioLugar.crear(lugar));

	}

	@Test
	void crearLugarFallaPorCamposObligatorios() {
		Lugar lugar = new LugarTestDataBuilder().conSede(null).build();

		// act - assert
		Assertions.assertThrows(ExcepcionFlujo.class, () -> servicioLugar.crear(lugar));

	}
}
