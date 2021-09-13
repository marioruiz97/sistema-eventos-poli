package edu.politecnicojic.eventos.dominio.modelo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;

class TipoRelacionTest {

	@Test
	void crearEnumValido() {
		String administrativo = "Administrativo";
		assertThat(TipoRelacion.valueOf(administrativo.toUpperCase())).isEqualTo(TipoRelacion.ADMINISTRATIVO);
	}

	@Test
	void crearEnumNoValido() {
		String noExiste = "NoExiste";
		Assertions.assertThrows(IllegalArgumentException.class, () -> TipoRelacion.valueOf(noExiste));
	}

}
