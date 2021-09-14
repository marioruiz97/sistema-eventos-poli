package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "departamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadDepartamento implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 20)
    @NotEmpty
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, name = "cod_pais")
    private EntidadPais entidadPais;

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
