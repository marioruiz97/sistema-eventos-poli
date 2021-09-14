package edu.politecnicojic.eventos.dominio.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.politecnicojic.eventos.dominio.databuilder.UsuarioTestDataBuilder;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioUsuario;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioUsuarioPolitecnico;

class ServicioUsuarioTest {

	private static final String CAMPOS_OBLIGATORIOS = "Faltan campos obligatorios, por favor verifica los datos ingresados";
	private static final String USUARIO_NO_ENCONTRADO = "El usuario que buscas no se ha encontrado";

	private static ServicioUsuario servicioUsuario;

	private static RepositorioUsuario repositorioUsuario;
	private static RepositorioUsuarioPolitecnico repositorioUsuarioPolitecnico;

	@BeforeAll
	public static void setUp() {
		repositorioUsuario = mock(RepositorioUsuario.class);
		repositorioUsuarioPolitecnico = mock(RepositorioUsuarioPolitecnico.class);
		servicioUsuario = new ServicioUsuario(repositorioUsuario, repositorioUsuarioPolitecnico);
	}

	/*
	 * crear(Usuario) buscarTodos() buscarUsuario(String) buscarMiembroPoli(String)
	 */

	@Test
	void crearUsuarioExitosoTest() {

		// arrange
		String contrasena = "superclave123";
		Usuario usuario = new UsuarioTestDataBuilder().conContrasena(contrasena)
				.conTipoRelacion(TipoRelacion.SIN_RELACION).build();
		Mockito.when(repositorioUsuario.crear(usuario)).thenReturn(usuario);

		// act
		Usuario result = servicioUsuario.crear(usuario);

		// assert
		assertThatNoException();
		assertThat(result.getContrasena()).isEqualTo(Base64.getEncoder().encodeToString(contrasena.getBytes()));

	}

	@Test
	void crearUsuarioFallaPorCamposObligatorios() {
		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().conContrasena("").conTipoRelacion(null).build();

		// act
		ExcepcionFlujo excepcion = Assertions.assertThrows(ExcepcionFlujo.class, () -> servicioUsuario.crear(usuario));

		// assert
		assertThat(excepcion.getMessage()).isEqualTo(CAMPOS_OBLIGATORIOS);
	}

	@Test
	void crearMiembroPoliEsExitoso() {
		// arrange
		String identificacion = "71665023";

		Usuario usuario = new UsuarioTestDataBuilder().conNombres("").conEmail("").conIdentificacion(identificacion)
				.conTipoRelacion(TipoRelacion.ADMINISTRATIVO).build();

		Usuario result = new UsuarioTestDataBuilder().conIdentificacion(identificacion)
				.conTipoRelacion(TipoRelacion.ADMINISTRATIVO).build();

		Mockito.when(repositorioUsuarioPolitecnico.buscarPorIdentificacion(identificacion))
				.thenReturn(Optional.of(result));
		Mockito.when(repositorioUsuario.crear(usuario)).thenReturn(result);

		// act
		usuario = servicioUsuario.crear(usuario);

		// assert
		assertThatNoException();
		assertThat(usuario.getIdentificacion()).isEqualTo(result.getIdentificacion());
		assertThat(usuario.getNombres()).isEqualTo(result.getNombres());
		assertThat(usuario.getEmail()).isEqualTo(result.getEmail());
		assertThat(usuario.getTipoRelacion()).isEqualTo(TipoRelacion.ADMINISTRATIVO);

	}

	@Test
	void existeEnBdFunciona() {
		// arrange
		String identificacion = "1";
		Mockito.when(repositorioUsuarioPolitecnico.existeEnSistemaRelacional(identificacion)).thenReturn(true);

		// act - assert
		assertThat(servicioUsuario.existeEnSistemaRelacional(identificacion)).isTrue();
	}

	@Test
	void buscarUsuarioConIdentificacionEsExitoso() {
		// arrange
		String identificacion = "71665023";
		Usuario usuario = new UsuarioTestDataBuilder().conIdentificacion(identificacion).build();
		Mockito.when(repositorioUsuario.buscarPorIdentificacion(identificacion)).thenReturn(Optional.of(usuario));

		// act
		Usuario result = servicioUsuario.buscarUsuario(identificacion);

		// assert
		assertThatNoException();
		assertThat(result).isEqualTo(usuario);
	}

	@Test
	void buscarUsuarioConIdentificacionFalla() {
		// arrange
		String identificacion = "71665023";
		Mockito.when(repositorioUsuario.buscarPorIdentificacion(identificacion)).thenReturn(Optional.ofNullable(null));

		// act
		ExcepcionElementoNoEncontrado excepcion = Assertions.assertThrows(ExcepcionElementoNoEncontrado.class,
				() -> servicioUsuario.buscarUsuario(identificacion));

		// assert
		assertThat(excepcion.getMessage()).isEqualTo(USUARIO_NO_ENCONTRADO);
	}

	@Test
	void buscarUsuariosEsExitosoYLimpiaContrasena() {
		// arrange
		List<Usuario> listaEsperada = new ArrayList<>();
		for (int j = 1; j <= 3; j++) {
			listaEsperada.add(new UsuarioTestDataBuilder().conContrasena("unacontrasena123").build());
		}
		Mockito.when(repositorioUsuario.buscarTodos()).thenReturn(listaEsperada);

		// act
		List<Usuario> resultado = servicioUsuario.buscarTodos();

		// assert
		assertThatNoException();
		assertThat(resultado.size()).isEqualTo(listaEsperada.size());
		assertThat(resultado.stream().anyMatch(u -> !u.getContrasena().isEmpty())).isFalse();
	}

}
