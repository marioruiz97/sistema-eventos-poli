package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "empleados")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadEmpleado implements Serializable {

	@Id
	@Size(max = 15)
	private String identificacion;

	@Size(max = 30)
	@NotEmpty
	private String nombres;

	@Size(max = 30)
	@NotEmpty
	private String apellidos;

	@Size(max = 40)
	@NotEmpty
	private String email;

	@Column(name = "tipo_contratacion", length = 30, nullable = false)
	private String tipoContratacion;

	@Column(name = "tipo_empleado", length = 30, nullable = false)
	private String tipoEmpleado;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cod_facultad", nullable = false)
	private EntidadFacultad facultad;

	@ManyToOne(optional = false)
	@JoinColumn(name = "codigo_sede", nullable = false)
	private EntidadSede sede;

	@ManyToOne(optional = false)
	@JoinColumn(name = "lugar_nacimiento", nullable = false)
	private EntidadCiudad lugarNacimiento;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
