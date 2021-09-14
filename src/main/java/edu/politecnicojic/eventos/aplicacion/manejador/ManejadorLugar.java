package edu.politecnicojic.eventos.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.servicio.ServicioLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.LugarDto;

@Service
public class ManejadorLugar {

	private final ServicioLugar servicioLugar;

	@Autowired
	public ManejadorLugar(ServicioLugar servicioLugar) {
		super();
		this.servicioLugar = servicioLugar;
	}

	public Lugar buscarPorNombreYDireccion(LugarDto lugarDto) {
		return servicioLugar.buscarPorNombreYDireccion(lugarDto.getNombre(), lugarDto.getDireccion());
	}
}
