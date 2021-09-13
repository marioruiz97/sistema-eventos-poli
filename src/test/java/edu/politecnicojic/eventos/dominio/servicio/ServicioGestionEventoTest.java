package edu.politecnicojic.eventos.dominio.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.politecnicojic.eventos.dominio.databuilder.EventoTestDataBuilder;
import edu.politecnicojic.eventos.dominio.databuilder.LugarTestDataBuilder;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;

class ServicioGestionEventoTest {

	private static final String CAMPOS_OBLIGATORIOS = "Faltan campos obligatorios, por favor verifica los datos ingresados";
	private static final String LUGAR_NO_ENCONTRADO = "No se encontr� el lugar al que se asoci� el evento, verifica la informaci�n";
	private static final String FECHA_INVALIDA = "La fecha ingresada debe estar en el futuro";
	private static final String EVENTO_NO_ENCONTRADO = "No se ha encontrado el evento que buscas";

	private static ServicioGestionEvento servicioEvento;
	private static RepositorioEvento repositorioEvento;
	private static RepositorioLugar repositorioLugar;

	@BeforeAll
	static void setUp() {
		repositorioEvento = mock(RepositorioEvento.class);
		repositorioLugar = mock(RepositorioLugar.class);
		servicioEvento = new ServicioGestionEvento(repositorioEvento, repositorioLugar);
	}

	@Test
	void crearFuncionaYBuscaLugarEnBd() {

		// arrange
		Lugar lugar = spy(new LugarTestDataBuilder().conSede(null).build());
		Evento evento = spy(new EventoTestDataBuilder().conLugar(lugar).buildEvento());
		Lugar lugarRetornado = new LugarTestDataBuilder().build();

		Mockito.when(repositorioLugar.buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion()))
				.thenReturn(Optional.of(lugarRetornado));
		Mockito.when(repositorioEvento.crear(evento)).thenReturn(evento);

		// act
		assertThatNoException().isThrownBy(() -> servicioEvento.crear(evento));

		// assert
		verify(repositorioLugar, atLeastOnce()).buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion());
	}

	@Test
	void crearFallaPorCamposObligatorios() {
		// arrange
		Evento evento = spy(new EventoTestDataBuilder().conNombre("").conDescripcion("").buildEvento());

		// act
		ExcepcionFlujo excepcion = Assertions.assertThrows(ExcepcionFlujo.class, () -> servicioEvento.crear(evento));

		// assert
		assertThat(excepcion.getMessage()).isEqualTo(CAMPOS_OBLIGATORIOS);

	}

	@Test
	void crearFallaPorLugarInexistente() {
		// arrange
		Lugar lugar = new LugarTestDataBuilder().conSede(null).build();
		Evento evento = spy(new EventoTestDataBuilder().conLugar(lugar).buildEvento());
		Mockito.when(repositorioLugar.buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion()))
				.thenReturn(Optional.empty());

		// act
		ExcepcionElementoNoEncontrado excepcion = Assertions.assertThrows(ExcepcionElementoNoEncontrado.class,
				() -> servicioEvento.crear(evento));

		// assert
		assertThat(excepcion.getMessage()).isEqualTo(LUGAR_NO_ENCONTRADO);

	}

	@Test
	void crearFallaPorLugarInvalido() {
		// arrange
		Lugar lugar = new LugarTestDataBuilder().conNombre(null).build();
		Evento evento = spy(new EventoTestDataBuilder().conLugar(lugar).buildEvento());

		// act
		ExcepcionFlujo excepcion = Assertions.assertThrows(ExcepcionFlujo.class, () -> servicioEvento.crear(evento));

		// assert
		assertThat(excepcion.getMessage()).isEqualTo(CAMPOS_OBLIGATORIOS);

	}

	@Test
	void crearFallaPorFechaPasado() {
		// arrange
		LocalDate fechaPasado = LocalDate.now().minusDays(20);
		Evento evento = spy(new EventoTestDataBuilder().conFecha(fechaPasado).buildEvento());

		// act
		ExcepcionFlujo excepcion = Assertions.assertThrows(ExcepcionFlujo.class, () -> servicioEvento.crear(evento));

		// assert
		assertThat(excepcion.getMessage()).isEqualTo(FECHA_INVALIDA);

	}

	@Test
	void actualizarEventoFunciona() {

		// arrange
		Lugar lugar = spy(new LugarTestDataBuilder().conSede(null).build());
		Evento evento = spy(new EventoTestDataBuilder().conLugar(lugar).buildEvento());
		Lugar lugarRetornado = new LugarTestDataBuilder().build();

		Mockito.when(repositorioLugar.buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion()))
				.thenReturn(Optional.of(lugarRetornado));

		// act
		assertThatNoException().isThrownBy(() -> servicioEvento.actualizar(evento));

		// assert
		verify(repositorioLugar, atLeastOnce()).buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion());
	}

	@Test
	void agregarComentarioFunciona() {
		// arrange
		Evento evento = new EventoTestDataBuilder().buildEvento();
		String idEvento = evento.getIdEvento();
		Comentario comentario = EventoTestDataBuilder.construirComentario();

		Mockito.when(repositorioEvento.buscarPorId(idEvento)).thenReturn(Optional.of(evento));

		// act - assert
		assertThatNoException().isThrownBy(() -> servicioEvento.agregarComentario(idEvento, comentario));
	}

	@Test
	void agregarComentarioFallaPorEventoNoEncontrado() {
		// arrange
		String idEvento = "1";
		Comentario comentario = EventoTestDataBuilder.construirComentario();

		Mockito.when(repositorioEvento.buscarPorId(idEvento)).thenReturn(Optional.empty());

		// act - assert
		ExcepcionElementoNoEncontrado excepcion = Assertions.assertThrows(ExcepcionElementoNoEncontrado.class,
				() -> servicioEvento.agregarComentario(idEvento, comentario));

		assertThat(excepcion.getMessage()).isEqualTo(EVENTO_NO_ENCONTRADO);
	}

	@Test
	void agregarComentarioFallaPorCamposObligatorios() {
		// arrange
		Evento evento = new EventoTestDataBuilder().buildEvento();
		String idEvento = evento.getIdEvento();
		Comentario comentario = EventoTestDataBuilder.construirComentario("", null);

		Mockito.when(repositorioEvento.buscarPorId(idEvento)).thenReturn(Optional.of(evento));

		// act - assert
		ExcepcionFlujo excepcion = Assertions.assertThrows(ExcepcionFlujo.class,
				() -> servicioEvento.agregarComentario(idEvento, comentario));

		assertThat(excepcion.getMessage()).isEqualTo(CAMPOS_OBLIGATORIOS);
	}

}
