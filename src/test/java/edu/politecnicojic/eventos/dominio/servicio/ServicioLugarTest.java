package edu.politecnicojic.eventos.dominio.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.politecnicojic.eventos.dominio.databuilder.LugarTestDataBuilder;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;

class ServicioLugarTest {

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
