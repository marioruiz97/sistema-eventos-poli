package edu.politecnicojic.eventos.dominio.modelo.lugar;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sede {

	private Integer codigoSede;

	private String nombre;

	private Ciudad ciudad;

	public Sede(Integer codigoSede) {
		this.codigoSede = codigoSede;
	}

	public void validarCampos() {
		ValidadorArgumento.validarCampo(nombre);
		ValidadorArgumento.validarNulo(ciudad);
		ciudad.validarCampos();
	}

}
