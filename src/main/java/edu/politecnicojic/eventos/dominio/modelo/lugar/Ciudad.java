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
public class Ciudad {

	// private Integer codigo;

	private String nombre;

	private String departamento;

	public void validarCampos() {
		List<String> campos = new ArrayList<>();
		campos.add(nombre);
		campos.add(departamento);
		ValidadorArgumento.validarCampos(campos);
	}

}
