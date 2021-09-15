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

import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorUsuario;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.infraestructura.configuracion.Constantes;
import edu.politecnicojic.eventos.infraestructura.configuracion.RespuestaApi;
import edu.politecnicojic.eventos.infraestructura.controlador.ControladorBase;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoUsuarioDto;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constantes.API_PATH + "usuarios")
public class ComandoControladorUsuario extends ControladorBase {

	private final ManejadorUsuario manejadorUsuario;

	@Autowired
	public ComandoControladorUsuario(ManejadorUsuario manejadorUsuario) {
		this.manejadorUsuario = manejadorUsuario;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<RespuestaApi> crear(@Valid @RequestBody NuevoUsuarioDto usuarioDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return objetoInvalido(bindingResult);
		Usuario usuario = manejadorUsuario.crear(usuarioDto);
		RespuestaApi<?> respuesta = crearRespuestaExitosa("El usuario se ha creado con éxito", usuario);
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}

}
