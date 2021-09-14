package edu.politecnicojic.eventos.dominio.modelo.usuario;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public enum TipoRelacion {
	PROFESOR("Profesor"), 
	ESTUDIANTE("Estudiante"), 
	GRADUADO("Grauado"), 
	EMPRESARIO("Empresario"),
	ADMINISTRATIVO("Administrativo"), 
	DIRECTIVO("Directivo"), 
	OTRO("Otro"),
	SIN_RELACION("Externo al poli (sin relación)");

	@Getter
	private final String nombreTipoRelacion;

	private static final Map<String, TipoRelacion> tiposDisponibles = new HashMap<>();

	static {
		for (TipoRelacion tipo : EnumSet.allOf(TipoRelacion.class)) {
			tiposDisponibles.put(tipo.name(), tipo);
		}
	}

	TipoRelacion(String nombreTipoRelacion) {
		this.nombreTipoRelacion = nombreTipoRelacion;
	}

	public static boolean tipoRelacionEsValida(TipoRelacion relacion) {
		return relacion != null && !relacion.getNombreTipoRelacion().equals("")
				&& tiposDisponibles.get(relacion.name()) != null;
	}

}
