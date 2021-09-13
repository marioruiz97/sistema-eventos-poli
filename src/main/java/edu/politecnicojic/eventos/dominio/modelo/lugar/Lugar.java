package edu.politecnicojic.eventos.dominio.modelo.lugar;

import java.util.ArrayList;
import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lugar {

	private String nombre;

	private String direccion;

	private Ciudad ciudad;

	private Sede sede;

	public void validarCampos() {
		List<String> campos = new ArrayList<>();
		campos.add(nombre);
		campos.add(direccion);
		ValidadorArgumento.validarCampos(campos);
		ValidadorArgumento.validarNulo(ciudad);
		ValidadorArgumento.validarNulo(sede);
		ciudad.validarCampos();
		sede.validarCampos();
	}

}
