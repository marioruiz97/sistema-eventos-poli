package edu.politecnicojic.eventos.dominio.modelo;

import java.time.LocalDate;
import java.util.List;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidadorArgumento {

	private static final String CAMPOS_OBLIGATORIOS = "Faltan campos obligatorios, por favor verifica los datos ingresados";
	private static final String FECHA_INVALIDA = "La fecha ingresada debe estar en el futuro";

	public static void validarCampos(List<String> campos) {
		campos.forEach(ValidadorArgumento::validarCampo);
	}

	public static void validarTipoRelacion(TipoRelacion tipoRelacion) {
		if (!TipoRelacion.tipoRelacionEsValida(tipoRelacion))
			throw new ExcepcionFlujo(CAMPOS_OBLIGATORIOS);
	}

	public static void validarCampo(String campo) {
		if (campo == null || campo.trim().equals(""))
			throw new ExcepcionFlujo(CAMPOS_OBLIGATORIOS);

	}

	public static void validarNulo(Object atributo) {
		if (atributo == null)
			throw new ExcepcionFlujo(CAMPOS_OBLIGATORIOS);

	}

	public static void validarVacio(List<?> lista) {
		validarNulo(lista);
		if (lista.isEmpty())
			throw new ExcepcionFlujo(CAMPOS_OBLIGATORIOS);
	}

	public static void validarFechaFutura(LocalDate fechaEvento) {
		if (LocalDate.now().isAfter(fechaEvento))
			throw new ExcepcionFlujo(FECHA_INVALIDA);
	}

}
