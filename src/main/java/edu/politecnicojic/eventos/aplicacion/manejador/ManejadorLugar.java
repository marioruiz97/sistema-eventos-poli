package edu.politecnicojic.eventos.aplicacion.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaLugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import edu.politecnicojic.eventos.dominio.servicio.ServicioLugar;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.LugarDto;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoLugarDto;

@Service
public class ManejadorLugar {

	private final ServicioLugar servicioLugar;
	private final FabricaLugar fabricaLugar;

	@Autowired
	public ManejadorLugar(ServicioLugar servicioLugar, FabricaLugar fabricaLugar) {
		this.servicioLugar = servicioLugar;
		this.fabricaLugar = fabricaLugar;
	}

	public Lugar buscarPorNombreYDireccion(LugarDto lugarDto) {
		return servicioLugar.buscarPorNombreYDireccion(lugarDto.getNombre(), lugarDto.getDireccion());
	}

	public Lugar crear(NuevoLugarDto lugarDto) {
		Ciudad ciudad = servicioLugar.buscarCiudad(lugarDto.getCiudad());
		Sede sede = servicioLugar.buscarSede(lugarDto.getSede());
		Lugar lugar = fabricaLugar.convertirDtoADominio(lugarDto, ciudad, sede);
		return servicioLugar.crear(lugar);
	}

	public List<Lugar> buscarTodos() {
		return servicioLugar.buscarTodos();
	}

}
