package edu.politecnicojic.eventos.dominio.servicio;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;

class ServicioConsultaEventoTest {

	private static ServicioConsultaEvento servicioEvento;
	private static RepositorioEvento repositorioEvento;

	@BeforeAll
	static void setUp() {
		repositorioEvento = mock(RepositorioEvento.class);
		servicioEvento = new ServicioConsultaEvento(repositorioEvento);
	}

	@Test
	void buscarPorIdFalla() {
		// assert
		String idEvento = "1";
		Mockito.when(repositorioEvento.buscarPorId(idEvento)).thenReturn(Optional.empty());

		// act - assert
		Assertions.assertThrows(ExcepcionElementoNoEncontrado.class, () -> servicioEvento.buscarPorId(idEvento));
	}

	@Test
	void buscarPorCategoriaFunciona() {
		// assert
		List<Categoria> lista = new ArrayList<>();
		Mockito.when(repositorioEvento.buscarPorCategorias(lista)).thenReturn(new ArrayList<Evento>());

		// act - assert
		assertThatNoException().isThrownBy(() -> servicioEvento.buscarPorCategorias(lista));
	}

	@Test
	void buscarTodosFunciona() {
		// assert
		List<Evento> lista = new ArrayList<>();
		Mockito.when(repositorioEvento.buscarTodos()).thenReturn(lista);

		// act - assert
		assertThatNoException().isThrownBy(() -> servicioEvento.buscarTodos());
	}
}
