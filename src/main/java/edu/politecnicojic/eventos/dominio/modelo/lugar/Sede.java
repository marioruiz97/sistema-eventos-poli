package edu.politecnicojic.eventos.dominio.modelo.lugar;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sede {

	// TODO: BORRAR SI NO SE NECESITA private String codigoSede;

	private String nombre;
	
	private Ciudad ciudad;

	public void validarCampos() {
		ValidadorArgumento.validarCampo(nombre);
		ciudad.validarCampos();
	}
}