package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorLugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constantes.API_PATH + "lugares")
public class ConsultaControladorLugar {

	private final ManejadorLugar manejadorLugar;

	@Autowired
	public ConsultaControladorLugar(ManejadorLugar manejadorLugar) {
		this.manejadorLugar = manejadorLugar;
	}

	@GetMapping
	public List<Lugar> buscarTodos() {
		return manejadorLugar.buscarTodos();
	}
}
