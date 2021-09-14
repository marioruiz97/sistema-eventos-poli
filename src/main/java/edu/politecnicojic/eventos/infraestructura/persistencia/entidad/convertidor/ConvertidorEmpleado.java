package edu.politecnicojic.eventos.infraestructura.persistencia.entidad.convertidor;

import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import edu.politecnicojic.eventos.infraestructura.persistencia.entidad.EntidadEmpleado;

public final class ConvertidorEmpleado {

	private ConvertidorEmpleado() {
	}

	public static Usuario convertirEntidadADominio(EntidadEmpleado empleado, TipoRelacion relacion,
			String nombreUsuario, String contrasena) {
		return new Usuario(empleado.getIdentificacion(), empleado.getNombres(), empleado.getApellidos(),
				empleado.getEmail(), relacion, nombreUsuario, contrasena);
	}

}
