package edu.politecnicojic.eventos.infraestructura.configuracion;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongodb.MongoWriteException;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<Object> manejarConstraints(ConstraintViolationException ex, WebRequest request) {
		String mensaje = "Hay campos que no cumplen el formato requerido";
		List<String> errores = ex.getConstraintViolations().stream().map(err -> {
			String field = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(err.getPropertyPath().toString()),
					' ') + ": ";
			return field + err.getMessage();
		}).collect(Collectors.toList());
		RespuestaApi<List<String>> respuestaError = new RespuestaApi<>(mensaje, errores);

		return handleExceptionInternal(ex, respuestaError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ExcepcionFlujo.class, ExcepcionElementoNoEncontrado.class })
	protected ResponseEntity<Object> manejarExcepcionesFlujo(RuntimeException ex, WebRequest request) {
		final String mensaje = "Se ha presentado un error de flujo, valide la acción realizada";
		RespuestaApi<String> respuestaError = new RespuestaApi<>(mensaje, ex.getMessage());
		HttpStatus status = (ex instanceof ExcepcionFlujo) ? HttpStatus.BAD_REQUEST : HttpStatus.NOT_FOUND;
		return handleExceptionInternal(ex, respuestaError, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(value = { MongoWriteException.class })
	protected ResponseEntity<Object> manejarClaveDuplicadaMongo(MongoWriteException ex, WebRequest request) {
		final String mensaje = "Se ha presentado un error de base de datos, valide la solicitud";
		RespuestaApi<String> respuestaError = new RespuestaApi<>(mensaje, ex.getMessage());
		return handleExceptionInternal(ex, respuestaError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
