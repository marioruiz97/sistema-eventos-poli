package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "sedes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadSede implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 30)
    @NotEmpty
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_ciudad", nullable = false)
    private EntidadCiudad ciudad;

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
