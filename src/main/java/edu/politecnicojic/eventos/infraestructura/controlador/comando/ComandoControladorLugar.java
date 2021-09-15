package edu.politecnicojic.eventos.infraestructura.controlador.comando;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorLugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;
import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import edu.politecnicojic.eventos.infraestructura.controlador.ControladorBase;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoLugarDto;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constantes.API_PATH + "lugares")
public class ComandoControladorLugar extends ControladorBase {

	private final ManejadorLugar manejadorLugar;

	@Autowired
	public ComandoControladorLugar(ManejadorLugar manejadorLugar) {
		this.manejadorLugar = manejadorLugar;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<RespuestaApi> crear(@Valid @RequestBody NuevoLugarDto lugarDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return objetoInvalido(bindingResult);
		Lugar lugar = manejadorLugar.crear(lugarDto);
		RespuestaApi<?> respuesta = crearRespuestaExitosa("Se ha creado el Lugar con éxito", lugar);
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}

}
