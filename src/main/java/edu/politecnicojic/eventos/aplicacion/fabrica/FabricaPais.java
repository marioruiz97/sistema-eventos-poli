package edu.politecnicojic.eventos.aplicacion.fabrica;

import edu.politecnicojic.eventos.dominio.modeloaborrar.Pais;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.PaisDto;
import org.springframework.stereotype.Component;

@Component
public class FabricaPais {

	public Pais convertirDtoADominio(PaisDto paisDto) {
		return new Pais(paisDto.getCodigoPais(), paisDto.getNombre());
	}
}
