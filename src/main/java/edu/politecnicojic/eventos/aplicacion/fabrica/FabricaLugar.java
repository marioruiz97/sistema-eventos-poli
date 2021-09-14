package edu.politecnicojic.eventos.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoLugarDto;

@Component
public class FabricaLugar {

	public Lugar convertirDtoADominio(NuevoLugarDto lugarDto, Ciudad ciudad, Sede sede) {
		return new Lugar(lugarDto.getNombre(), lugarDto.getDireccion(), ciudad, sede);
	}

}
